from PySide2 import QtWidgets, QtGui
import sys
from tkinter import messagebox as MessageBox
import webbrowser
import os
import subprocess
import json
import psutil
import receptor
import platform

config = "config.json"


def getConf(path):
    if os.path.isfile(path):
        with open(config, 'r', encoding="utf-8") as f:
            jsonStr = f.read()
    else:
        print("Error: No config file")
    return json.loads(jsonStr)


sistema = platform.architecture()


def getServer():
    if sistema[0] == "64bit":
        return "./server/PhotOp_Server_64bits/PhotOp_Server.exe"
    else:
        return "./server/PhotOp_Server_32bits/PhotOp_Server.exe"


def getConfWin():
    if sistema[0] == "64bit":
        return "configWin_64bits\\configWin.exe"
    else:
        return "configWin_32bits\\configWin.exe"


conf = getConf(config)

server = getServer()

configwin = getConfWin()


def isdefault(text):
    return text == conf['df']['Español'] or conf['webbroserpath'] == conf['df']['English']


def initServer():
    if isdefault(conf['userpath']):
        if int(conf['port']) == 8000:
            p = subprocess.Popen([server])
        else:
            p = subprocess.Popen(
                [server, os.path.expanduser('~'), conf['port']])
    else:
        p = subprocess.Popen([server, conf['userpath'], conf['port']])


def getLenguage(leng):
    if leng == 'English':
        idiomFile = "./src/idiom/en.json"
    else:
        idiomFile = "./src/idiom/es.json"
    with open(idiomFile, 'r', encoding="utf-8") as f:
        idiom = f.read()
    return json.loads(idiom)


lg = getLenguage(conf['lg'])


class SystemTrayIcon(QtWidgets.QSystemTrayIcon):
    """
    CREATE A SYSTEM TRAY ICON CLASS AND ADD MENU
    """
    photOpsSvr = "PhotOp_Server.exe"
    killserver = 'taskkill /f /im '+photOpsSvr
    version = 'Photopea Opener 1.3'

    def __init__(self, icon, parent=None):
        QtWidgets.QSystemTrayIcon.__init__(self, icon, parent)
        self.setToolTip(self.version)

        menu = QtWidgets.QMenu(parent)

        open_pho = menu.addAction(lg['openPho'])
        open_pho.triggered.connect(self.open_photopea)
        open_pho.setIcon(QtGui.QIcon("src/menu/photopea.png"))

        localServer = menu.addAction("On/Off Local Server")
        localServer.triggered.connect(self.switch_Server)
        localServer.setIcon(QtGui.QIcon("src/menu/server.png"))

        config = menu.addAction(lg['configTray'])
        config.triggered.connect(self.config)
        config.setIcon(QtGui.QIcon("src/menu/config.png"))

        exit_ = menu.addAction(lg['exitTray'])
        exit_.triggered.connect(self.salir)
        exit_.setIcon(QtGui.QIcon("src/menu/salir.png"))

        menu.addSeparator()
        self.setContextMenu(menu)
        self.activated.connect(self.onTrayIconActivated)

    def open_photopea(self):
        receptor.open("https://www.photopea.com",
                      conf['webbroserpath'], isdefault(conf['webbroserpath']), conf['webapp'])

    def onTrayIconActivated(self, reason):
        if reason == self.DoubleClick:
            self.open_photopea

    def svrIsOn(self):
        return (self.photOpsSvr in (p.name() for p in psutil.process_iter()))

    def switch_Server(self):
        if self.svrIsOn():
            os.system(self.killserver)
            MessageBox.showinfo("¡Servidor Desactivado!",
                                "El servidor esta desactivo :/")
        else:
            initServer()
            MessageBox.showinfo("¡Servidor Activado!",
                                "El servidor esta activo B)")

    def config(self):
        os.startfile(configwin)

    def salir(self):
        if self.svrIsOn():
            os.system(self.killserver)
        sys.exit()


def ini():
    app = QtWidgets.QApplication(sys.argv)
    w = QtWidgets.QWidget()
    tray_icon = SystemTrayIcon(QtGui.QIcon("src/logo.png"), w)
    tray_icon.show()
    sys.exit(app.exec_())


if __name__ == '__main__':
    ini()

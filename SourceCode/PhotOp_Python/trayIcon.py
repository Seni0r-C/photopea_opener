from PySide2 import QtWidgets, QtGui
import sys
from tkinter import messagebox as MessageBox
import os
import psutil
import receptor
import utilities as util
import configWin as cofw

conf = util.getConf(util.config)
server = util.getServer()
lg = util.getLenguage(conf['lg'])

class SystemTrayIcon(QtWidgets.QSystemTrayIcon):
    """
    CREATE A SYSTEM TRAY ICON CLASS AND ADD MENU
    """
    photOpsSvr = "PhotOp_Server.exe"
    killserver = 'taskkill /f /im '+photOpsSvr
    version = 'Photopea Opener 1.3'
    win=None

    def __init__(self, icon, parent=None):
        QtWidgets.QSystemTrayIcon.__init__(self, icon, parent)
        self.setToolTip(self.version)

        menu = QtWidgets.QMenu(parent)

        open_pho = menu.addAction(lg['openPho'])
        open_pho.triggered.connect(self.open_photopea)
        open_pho.setIcon(QtGui.QIcon("src/img/ti/photopea.png"))

        localServer = menu.addAction("On/Off Local Server")
        localServer.triggered.connect(self.switch_Server)

        config = menu.addAction(lg['configTray'])
        config.triggered.connect(self.config)

        exit_ = menu.addAction(lg['exitTray'])
        exit_.triggered.connect(self.salir)

        menu.addSeparator()
        self.setContextMenu(menu)
        self.activated.connect(self.onTrayIconActivated)

    def open_photopea(self):
        conf = util.getConf(util.config)
        receptor.open("https://www.photopea.com",
                      conf['webbroserpath'], util.isdefault(conf['webbroserpath'],conf), conf['webapp'])

    def onTrayIconActivated(self, reason):
        if reason == self.DoubleClick:
            self.open_photopea()

    def svrIsOn(self):
        return (self.photOpsSvr in (p.name() for p in psutil.process_iter()))

    def switch_Server(self):
        if self.svrIsOn():
            os.system(self.killserver)
            MessageBox.showinfo(lg['dessertit'], lg['desser'])
        else:
            util.initServer(server)
            MessageBox.showinfo(lg['actsertit'],lg['actser'])
  
    def config(self):
        cofw.init()

    def salir(self):
        if self.svrIsOn():
            os.system(self.killserver)
        sys.exit()


def ini():
    app = QtWidgets.QApplication(sys.argv)
    w = QtWidgets.QWidget()
    tray_icon = SystemTrayIcon(QtGui.QIcon("src/img/logo.ico"), w)
    tray_icon.show()
    sys.exit(app.exec_())


if __name__ == '__main__':
    ini()

from PySide2 import QtWidgets, QtGui
import sys
from tkinter import messagebox as MessageBox
import webbrowser
import os
import subprocess


class SystemTrayIcon(QtWidgets.QSystemTrayIcon):
    """
    CREATE A SYSTEM TRAY ICON CLASS AND ADD MENU
    """
    serverIsOn = True
    killserver = 'taskkill /f /im PhotOp_Server.exe'
    version = 'Photopea Opener 1.0'

    def __init__(self, icon, parent=None):
        QtWidgets.QSystemTrayIcon.__init__(self, icon, parent)
        self.setToolTip(self.version)

        menu = QtWidgets.QMenu(parent)

        open_pho = menu.addAction("Abrir Photopea")
        open_pho.triggered.connect(self.open_photopea)
        open_pho.setIcon(QtGui.QIcon("src/menu/photopea.png"))

        localServer = menu.addAction("On/Off Local Server")
        localServer.triggered.connect(self.switch_Server)
        localServer.setIcon(QtGui.QIcon("src/menu/server.png"))

        config = menu.addAction("Configuración")
        config.triggered.connect(self.config)
        config.setIcon(QtGui.QIcon("src/menu/config.png"))

        exit_ = menu.addAction("Salir")
        exit_.triggered.connect(self.salir)
        exit_.setIcon(QtGui.QIcon("src/menu/salir.png"))

        menu.addSeparator()
        self.setContextMenu(menu)
        self.activated.connect(self.onTrayIconActivated)

    def open_photopea(self):
        webbrowser.open_new_tab("https://www.photopea.com")

    def onTrayIconActivated(self, reason):
        if reason == self.DoubleClick:
            self.open_photopea

    def switch_Server(self):
        if self.serverIsOn:
            os.system(self.killserver)
            MessageBox.showinfo("¡Servidor Desactivado!",
                                "El servidor esta desactivo :/")
            self.serverIsOn = not self.serverIsOn
        else:
            p = subprocess.Popen(["server/Photopea-Server.exe"])
            MessageBox.showinfo("¡Servidor Activado!",
                                "El servidor esta activo B)")
            self.serverIsOn = not self.serverIsOn

    def config(self):
        MessageBox.showinfo("Ups!",
                            "Por el momento nohay configuraciónes,en versiones futuras podras acceder a esta caracteristica ;)")

    def salir(self):
        if self.serverIsOn == True:
            os.system(self.killserver)
        sys.exit()


def ini():
    app = QtWidgets.QApplication(sys.argv)
    w = QtWidgets.QWidget()
    tray_icon = SystemTrayIcon(QtGui.QIcon("src/logo.png"), w)
    tray_icon.show()
    sys.exit(app.exec_())

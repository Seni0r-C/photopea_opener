import tkinter as tk
import trayIcon as ti
import threading
import receptor as rec
import sys
import utilities as util

def reci(conf,root):
    util.initServer(util.getServer())

    # hilo1 = threading.Thread(target=ti.ini)
    hilo1 = threading.Thread(target=rec.ini,args=(sys.argv, conf['webbroserpath'], ti.util.isdefault(conf['webbroserpath'],conf), conf['webapp']))
    hilo1.start()
    root.destroy()
    ti.ini()

    # rec.ini(sys.argv, conf['webbroserpath'], ti.isdefault(conf['webbroserpath']), conf['webapp'])

def ini(conf):
    root = tk.Tk()
    root.overrideredirect(True)
    root.geometry('0x0')

    ancho_ventana = 650
    alto_ventana = 300

    x_ventana = root.winfo_screenwidth() // 2 - ancho_ventana // 2
    y_ventana = root.winfo_screenheight() // 2 - alto_ventana // 2

    posicion = str(ancho_ventana) + "x" + str(alto_ventana) + \
        "+" + str(x_ventana) + "+" + str(y_ventana)
    root.geometry(posicion)

    root.resizable(0, 0)

    # imagen
    bg = tk.PhotoImage(file="./src/img/ls/LSPO.png")
    myLab = tk.Label(root, image=bg)
    myLab.place(x=0, y=0, relwidth=1, relheight=1)

    def cerrarVentana():
        reci(conf,root)

    root.after(2000, cerrarVentana)
    # root.after(5000, cerrarVentana)
    root.mainloop()


if __name__ == '__main__':
    ini()

import tkinter as tk


def ini():
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
    bg = tk.PhotoImage(file="src/LSPO.png")
    myLab = tk.Label(root, image=bg)
    myLab.place(x=0, y=0, relwidth=1, relheight=1)

    def cerrarVentana():
        root.destroy()

    # root.after(2000, cerrarVentana)
    root.after(3000, cerrarVentana)
    root.mainloop()


if __name__ == '__main__':
    ini()

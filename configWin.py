import win32api
import win32event
from winerror import ERROR_ALREADY_EXISTS
import sys

mutex = win32event.CreateMutex(None, False, "confPhotopea")
error = win32api.GetLastError()

if error == ERROR_ALREADY_EXISTS:
    sys.exit("This app is already running!")

from tkinter import filedialog
import tkinter.ttk as ttk
from tkinter import *
from tkinter.tix import *
from tkinter import messagebox
import json
import os


# Configuration-----------------------------------------------------
config = "config.json"


def getConf(path):
    if os.path.isfile(path):
        with open(config, 'r', encoding="utf-8") as f:
            jsonStr = f.read()
    else:
        print("makefile :)")
    return json.loads(jsonStr)


conf = getConf(config)
# Lenguage


def getLenguage(leng):
    if leng == 'English':
        idiomFile = "./src/idiom/en.json"
    else:
        idiomFile = "./src/idiom/es.json"
    with open(idiomFile, 'r', encoding="utf-8") as f:
        idiom = f.read()
    return json.loads(idiom)


lg = getLenguage(conf['lg'])
# -----------------------------------------------------------------


def initWindow(root):
    root.iconbitmap('logo.ico')
    root.resizable(False, False)
    x_ventana = root.winfo_screenwidth() // 2 - int(conf['ancho_ventana']) // 2
    y_ventana = root.winfo_screenheight() // 2 - int(conf['alto_ventana']) // 2
    posicion = conf['ancho_ventana'] + "x" + conf['alto_ventana'] + \
        "+" + str(x_ventana) + "+" + str(y_ventana)
    root.title(lg['title'])
    root.geometry(posicion)
    root.configure(background=conf['bgColor'])


win = Tk()
initWindow(win)


class configWin:
    def __init__(self, root):
        # Fondo
        Frame1 = Frame(
            root, width=int(conf['ancho_ventana']), height=int(conf['alto_ventana']))
        Frame1.pack()
        Frame1.configure(background=conf['bgColor'])
        # Lenguaje-Lenguage
        LabelLg = Label(Frame1, text=lg['idiomLabel'],
                        font=("DejaVu Sans", 9, "bold"))
        LabelLg.grid(row=0, column=0, sticky="e", padx=10, pady=20)
        LabelLg.configure(background=conf['bgColor'])
        LabelLg.configure(foreground=conf['fgColor'])

        TCombobox1 = ttk.Combobox(Frame1, state="readonly",)
        TCombobox1["values"] = conf['options']
        TCombobox1.set(conf['lg'])
        TCombobox1.grid(row=0, column=1, sticky="ew")
        # Buscador Web-Web Browser

        LabelWb = Label(Frame1, text=lg['webBrowserlabel'],
                        font=("DejaVu Sans", 9, "bold"))
        LabelWb.grid(row=1, column=0, sticky="e", padx=10, pady=20)
        LabelWb.configure(background=conf['bgColor'])
        LabelWb.configure(foreground=conf['fgColor'])

        def put(a, text):
            a.delete(0, END)
            a.insert(0, text)

        def confirmlg(text1, entry1):
            if text1 == conf['df']['Español'] or text1 == conf['df']['English']:
                put(entry1, conf['df'][str(conf['lg'])])
            else:
                entry1.insert(0, text1)

        LabelWebPath = Entry(Frame1)
        confirmlg(conf['webbroserpath'], LabelWebPath)
        LabelWebPath.grid(row=1, column=1, sticky="ew")

        def addApp():
            if LabelWebPath.get() == conf['df'][str(conf['lg'])]:
                filename = filedialog.askopenfilename(title=lg['selectWB'], filetypes=(
                    (lg['exe'], "*.exe"), (lg['allfiles'], "*.*")))
                if not filename == "":
                    put(LabelWebPath, filename)
            else:
                if messagebox.askyesno(lg['dfWBTitle'], lg['dfWBMsg']):
                    put(LabelWebPath, conf['df'][str(conf['lg'])])
                else:
                    filename = filedialog.askopenfilename(title=lg['selectWB'], filetypes=(
                        (lg['exe'], "*.exe"), (lg['allfiles'], "*.*")))
                    if not filename == "":
                        put(LabelWebPath, filename)

        changeWebPath = Button(Frame1, text=lg['changebotton'], command=addApp)
        changeWebPath.grid(row=1, column=2)

        # Abrir como Web App - Open like Web App
        var = IntVar(value=int(conf['webapp']))
        CheckbuttonWebApp = Checkbutton(
            Frame1, text=lg['webApplabel'], font=("DejaVu Sans", 9, "bold"), selectcolor=conf['bgColor'], variable=var)
        CheckbuttonWebApp.grid(row=2, column=1, pady=10)
        CheckbuttonWebApp.configure(background=conf['bgColor'])
        CheckbuttonWebApp.configure(foreground=conf['fgColor'])

        # Opciones Avanzadas-Avanced Options
        Label3 = Label(Frame1, text=lg['advncOption'],
                       font=("Russo One", 10, "bold"))
        Label3.grid(row=4, column=1, sticky="w")
        Label3.configure(background=conf['bgColor'])
        Label3.configure(foreground=conf['fgColor'])
        # Separadores-Separators
        TSeparator1 = ttk.Separator(Frame1)
        TSeparator1.grid(row=3, column=0, sticky="ew")

        TSeparator2 = ttk.Separator(Frame1)
        TSeparator2.grid(row=3, column=2, sticky="ew")

        TSeparator3 = ttk.Separator(Frame1)
        TSeparator3.grid(row=3, column=3, sticky="ew")

        TSeparator4 = ttk.Separator(Frame1)
        TSeparator4.grid(row=3, column=1, sticky="ew")
        # Server Local-Local Seerver
        LabelLSvr = Label(Frame1, text=lg['localservlabel'],
                          font=("DejaVu Sans", 9, "bold"))
        LabelLSvr.grid(row=5, column=0, sticky="e", padx=10, pady=20)
        LabelLSvr.configure(background=conf['bgColor'])
        LabelLSvr.configure(foreground=conf['fgColor'])

        SvrPath = Entry(Frame1)
        confirmlg(conf['userpath'], SvrPath)
        SvrPath.grid(row=5, column=1, sticky="ew")

        def addpath():
            if SvrPath.get() == conf['df'][str(conf['lg'])]:
                dirname = filedialog.askdirectory(title=lg['selectWB'])
                if not dirname == "":
                    put(SvrPath, dirname)
            else:
                if messagebox.askyesno(lg['dfPthTitle'], lg['dfPthMsg']):
                    put(SvrPath, conf['df'][str(conf['lg'])])
                else:
                    dirname = filedialog.askdirectory(title=lg['selectWB'])
                    if not dirname == "":
                        put(SvrPath, dirname)

        chngSvrPath = Button(Frame1, text=lg['changebotton'], command=addpath)
        chngSvrPath.grid(row=5, column=2, padx=5)
        # Puerto del Server-Server's Port
        svrPort = Label(Frame1, text=lg['portlabel'],
                        font=("DejaVu Sans", 9, "bold"))
        svrPort.grid(row=6, column=0, sticky="e", padx=10)
        svrPort.configure(background=conf['bgColor'])
        svrPort.configure(foreground=conf['fgColor'])

        EntryPort = Entry(Frame1)
        EntryPort.insert(0, conf["port"])
        EntryPort.grid(row=6, column=1, sticky="w")
        # ToolTips
        tipWb = Balloon(win)
        tipWb.bind_widget(
            LabelWb, balloonmsg=lg['tooltip1'])

        tipWa = Balloon(win)
        tipWa.bind_widget(CheckbuttonWebApp, balloonmsg=lg['tooltip2'])

        tipPOSvr = Balloon(win)
        tipPOSvr.bind_widget(LabelLSvr, balloonmsg=lg['tooltip3'])

        tipSvrPort = Balloon(win)
        tipSvrPort.bind_widget(svrPort, balloonmsg=lg['tooltip4'])

        # Guardar o Cancelar-Save or Cancel
        def verific():
            conf['lg'] = TCombobox1.get()
            conf['webbroserpath'] = LabelWebPath.get()
            conf['userpath'] = SvrPath.get()
            conf['port'] = EntryPort.get()
            conf['webapp'] = var.get()
            aux = getConf(config)
            return conf == aux

        def saveing():
            a_file = open(config, "w", encoding="utf-8")
            json.dump(conf, a_file)
            a_file.close()

        def saveConf():
            if not verific():
                saveing()
                print("Datos Guardados")
            else:
                print("no hay Cambios")

        saveAll = Button(
            Frame1, text=lg['savelabel'], font=("arial", 10, "bold"), command=saveConf)
        saveAll.grid(row=7, column=1, sticky="e", padx=5)

        cancel = Button(Frame1, text=lg['cancellabel'], font=(
            "arial", 10, "bold"), command=sys.exit)
        cancel.grid(row=7, column=2, sticky="w", padx=5)
        # SAVE BEFORE EXIT

        def on_closing():
            if not verific():
                ex = messagebox.askyesnocancel(lg['quittitle'], lg['quitMsg'])
                if ex == True:
                    saveing()
                    root.destroy()
                elif ex is None:
                    print("XD")
                else:
                    root.destroy()
            else:
                root.destroy()

        root.protocol("WM_DELETE_WINDOW", on_closing)


configWin(win)
win.mainloop()

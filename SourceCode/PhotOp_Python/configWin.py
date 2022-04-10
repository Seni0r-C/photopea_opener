import utilities as util
from tkinter import filedialog
import tkinter.ttk as ttk
from tkinter import *
from tkinter.tix import *
from tkinter import messagebox
import json


# Configuration-----------------------------------------------------
conf = util.getConf(util.config)
# Lenguage
lg = util.getLenguage(conf['lg'])
#Fonts
labelfont="DejaVu Sans"
Advanfont="Russo One"
# -----------------------------------------------------------------

class configWin:
    def __init__(self, root):
        self.closed = False
        # Fondo
        Frame1 = Frame(
            root, width=int(conf['ancho_ventana']), height=int(conf['alto_ventana']))
        Frame1.pack()
        Frame1.configure(background=conf['bgColor'])
        # Lenguaje-Lenguage
        LabelLg = Label(Frame1, text=lg['idiomLabel'],
                        font=(labelfont, 9, "bold"))
        LabelLg.grid(row=0, column=0, sticky="e", padx=10, pady=20)
        LabelLg.configure(background=conf['bgColor'])
        LabelLg.configure(foreground=conf['fgColor'])

        TCombobox1 = ttk.Combobox(Frame1, state="readonly",)
        TCombobox1["values"] = conf['options']
        TCombobox1.set(conf['lg'])
        TCombobox1.grid(row=0, column=1, sticky="ew")
        # Buscador Web-Web Browser

        LabelWb = Label(Frame1, text=lg['webBrowserlabel'],
                        font=(labelfont, 9, "bold"))
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
            Frame1, text=lg['webApplabel'], font=(labelfont, 9, "bold"), selectcolor=conf['bgColor'], variable=var)
        CheckbuttonWebApp.grid(row=2, column=1, pady=10)
        CheckbuttonWebApp.configure(background=conf['bgColor'])
        CheckbuttonWebApp.configure(foreground=conf['fgColor'])

        # Opciones Avanzadas-Avanced Options
        Label3 = Label(Frame1, text=lg['advncOption'],
                       font=(Advanfont, 10, "bold"))
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
                          font=(labelfont, 9, "bold"))
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
                        font=(labelfont, 9, "bold"))
        svrPort.grid(row=6, column=0, sticky="e", padx=10)
        svrPort.configure(background=conf['bgColor'])
        svrPort.configure(foreground=conf['fgColor'])

        EntryPort = Entry(Frame1)
        EntryPort.insert(0, conf["port"])
        EntryPort.grid(row=6, column=1, sticky="w")
        # ToolTips
        tipWb = Balloon(root)
        tipWb.bind_widget(
            LabelWb, balloonmsg=lg['tooltip1'])

        tipWa = Balloon(root)
        tipWa.bind_widget(CheckbuttonWebApp, balloonmsg=lg['tooltip2'])

        tipPOSvr = Balloon(root)
        tipPOSvr.bind_widget(LabelLSvr, balloonmsg=lg['tooltip3'])

        tipSvrPort = Balloon(root)
        tipSvrPort.bind_widget(svrPort, balloonmsg=lg['tooltip4'])

        # Guardar o Cancelar-Save or Cancel
        def verific():
            aux = util.getConf(util.config)
            conf['lg'] = TCombobox1.get()
            if not conf['lg'] == aux:
                if conf['webbroserpath'] == conf['df'][aux['lg']]:
                    conf['webbroserpath'] = conf['df'][conf['lg']]
                else:
                    conf['webbroserpath'] = LabelWebPath.get()
                    
                if conf['userpath'] == conf['df'][aux['lg']]:
                    conf['userpath'] = conf['df'][conf['lg']]
                else:
                    conf['userpath'] = SvrPath.get()

            conf['port'] = EntryPort.get()
            conf['webapp'] = var.get()

            return conf == aux

        def saving():
            a_file = open(util.config, "w", encoding="utf-8")
            json.dump(conf, a_file)
            a_file.close()

        def saveConf():
            if not verific():
                saving()
                print("Datos Guardados")
            else:
                print("no hay Cambios")

        saveAll = Button(
            Frame1, text=lg['savelabel'], font=("arial", 10, "bold"), command=saveConf)
        saveAll.grid(row=7, column=1, sticky="e", padx=5)

        def closewin():
            self.closed = True
            root.destroy()

        cancel = Button(Frame1, text=lg['cancellabel'], font=(
            "arial", 10, "bold"), command=closewin)
        cancel.grid(row=7, column=2, sticky="w", padx=5)
        # SAVE BEFORE EXIT

        def on_closing():
            if not verific():
                ex = messagebox.askyesnocancel(lg['quittitle'], lg['quitMsg'])
                if ex == True:
                    saving()
                    closewin()
                elif ex is None:
                    pass
                else:
                    closewin()
            else:
                closewin()

        root.protocol("WM_DELETE_WINDOW", on_closing)


class MainFrame:
    def __init__(self, root, cf = None):
        self.cf = cf
        self.root = root
        self.initWindow(root)        

    def initWindow(self, root):
        w = conf['ancho_ventana']
        h = conf['alto_ventana']
        x = root.winfo_screenwidth() // 2 - int(w) // 2
        y = root.winfo_screenheight() // 2 - int(h) // 2
        posicion = w + "x" + h + "+" + str(x) + "+" + str(y)
        root.geometry(posicion)
        self.cf = configWin(root)      
        root.resizable(False, False)
        root.iconbitmap('src/img/logo.ico')
        root.title(lg['title'])
        root.configure(background=conf['bgColor'])
    
    def isClosed(self):
        return self.cf.closed

class SW:
    win = None
    def getMain():        
        if not SW.win or SW.win.isClosed():
            SW.win = MainFrame( root=Tk())            
        return SW.win


def init():
    win = SW.getMain()
    win.root.mainloop()

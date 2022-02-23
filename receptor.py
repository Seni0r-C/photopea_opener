import webbrowser
import os


def validar(arg):
    dir = os.path.expanduser('~')
    path = arg.replace(dir, "http://localhost:8000")
    transTable = path.maketrans("\\", "/")
    path = path.translate(transTable)
    return path


def ini(ruta):
    if len(ruta) > 1:
        path = "https://www.photopea.com/#{\"files\":[\"" + \
            validar(ruta[1]) + "\"]}"
        webbrowser.open_new_tab(path)
    else:
        webbrowser.open_new_tab("https://www.photopea.com")

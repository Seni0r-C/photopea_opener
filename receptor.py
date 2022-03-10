from cmath import log
import os
import subprocess


def validar(arg):
    dir = os.path.expanduser('~')
    path = arg.replace(dir, "http://localhost:8000")
    transTable = path.maketrans("\\", "/")
    path = path.translate(transTable)
    return path


def getdefaultBrow():
    try:
        from winreg import HKEY_CLASSES_ROOT, HKEY_CURRENT_USER, OpenKey, QueryValueEx

        with OpenKey(HKEY_CURRENT_USER, r'SOFTWARE\Microsoft\Windows\Shell\Associations\UrlAssociations\http\UserChoice') as regkey:
            browser_choice = QueryValueEx(regkey, 'ProgId')[0]

        with OpenKey(HKEY_CLASSES_ROOT, r'{}\shell\open\command'.format(browser_choice)) as regkey:
            browser_path_tuple = QueryValueEx(regkey, None)
            browser_path = browser_path_tuple[0].split('"')[1]

        return browser_path

    except Exception:
        log.error(
            'Failed to look up default browser in system registry. Using fallback value.')


def open(link, browser, df, solo):
    if solo == 1:
        link = "--app="+link

    if df:
        p = subprocess.Popen([getdefaultBrow(), link])
    else:
        p = subprocess.Popen([browser, link])


def ini(ruta, browser, df, solo):
    if len(ruta) > 1:
        path = "https://www.photopea.com/#{\"files\":[\"" + \
            validar(ruta[1]) + "\"]}"
        open(path, browser, df, solo)
        print(":)?")
    else:
        open("https://www.photopea.com", browser, df, solo)

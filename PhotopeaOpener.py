import threading
import trayIcon as ti
import receptor as rec
import subprocess
import LoadingScreen as ls
import win32api
import win32event
from winerror import ERROR_ALREADY_EXISTS
import sys
import json
import os
mutex = win32event.CreateMutex(None, False, "PhotopeaTrayIcon")
error = win32api.GetLastError()


def isdefault(text):
    return text == conf['df']['Español'] or text == conf['df']['English']


def getConf(path):
    if os.path.isfile(path):
        with open(config, 'r', encoding="utf-8") as f:
            jsonStr = f.read()
    else:
        print("makefile :)")
    return json.loads(jsonStr)


if error == ERROR_ALREADY_EXISTS:
    config = "config.json"
    conf = getConf(config)

    rec.ini(sys.argv, conf['webbroserpath'], isdefault(
        conf['webbroserpath']), conf['webapp'])
    sys.exit("YA ESTA ABIERTOOO")
else:

    config = "config.json"
    conf = getConf(config)

    ls.ini()

    server = ti.getServer()

    if isdefault(conf['userpath']):
        if int(conf['port']) == 8000:
            p = subprocess.Popen([server])
        else:
            p = subprocess.Popen(
                [server, os.path.expanduser('~'), conf['port']])
    else:
        p = subprocess.Popen([server, conf['userpath'], conf['port']])

    hilo1 = threading.Thread(target=ti.ini)
    hilo1.start()
    rec.ini(sys.argv, conf['webbroserpath'], isdefault(conf['webbroserpath']), conf['webapp'])

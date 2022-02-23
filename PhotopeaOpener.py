import threading
import trayIcon as ti
import receptor as rec
import subprocess
import LoadingScreen as ls
import win32api
import win32event
from winerror import ERROR_ALREADY_EXISTS
import sys

mutex = win32event.CreateMutex(None, False, "PhotopeaTrayIcon")
error = win32api.GetLastError()

if error == ERROR_ALREADY_EXISTS:
    rec.ini(sys.argv)
    sys.exit("YA ESTA ABIERTOOO")
else:
    ls.ini()
    p = subprocess.Popen(["server/PhotOp_Server.exe"])
    hilo1 = threading.Thread(target=ti.ini)
    hilo1.start()
    rec.ini(sys.argv)

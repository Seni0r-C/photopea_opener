import sys
import os

PROC_PATH = os.path.abspath (os.path.realpath (__file__))
ROOT = os.path.dirname (PROC_PATH)
os.chdir(ROOT)

import win32api
import win32event
from winerror import ERROR_ALREADY_EXISTS

mutex = win32event.CreateMutex(None, False, "PhotopeaTrayIcon")
error = win32api.GetLastError()

import utilities as util

conf = util.getConf(util.config)

if error == ERROR_ALREADY_EXISTS:
    import receptor as rec
    rec.ini(sys.argv, conf['webbroserpath'], util.isdefault(
        conf['webbroserpath'],conf), conf['webapp'])
    sys.exit("PhotOp Already Open")
else:
    import LoadingScreen as ls
    ls.ini(conf)


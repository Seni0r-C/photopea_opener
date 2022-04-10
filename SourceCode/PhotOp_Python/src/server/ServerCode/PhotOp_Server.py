import os
import win32api
import win32event
from winerror import ERROR_ALREADY_EXISTS
import sys

mutex = win32event.CreateMutex(None, False, "PhoOpServer")
error = win32api.GetLastError()

if error == ERROR_ALREADY_EXISTS:
    sys.exit("This app is already running!")

# ----------------------------------------------------------------

dir = sys.argv[1] if len(sys.argv) > 1 else os.path.expanduser('~')
os.chdir(dir)

try:
    # Python 3
    from http.server import HTTPServer, SimpleHTTPRequestHandler, test as test_orig

    def test(*args):
        test_orig(*args, port=int(sys.argv[2]) if len(sys.argv) > 2 else 8000)

except ImportError:
    # Python 2
    from BaseHTTPServer import HTTPServer, test
    from SimpleHTTPServer import SimpleHTTPRequestHandler


class CORSRequestHandler (SimpleHTTPRequestHandler):
    def end_headers(self):
        self.send_header('Access-Control-Allow-Origin',
                         'https://www.photopea.com')
        SimpleHTTPRequestHandler.end_headers(self)


test(CORSRequestHandler, HTTPServer)

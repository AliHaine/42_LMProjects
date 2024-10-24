import sys
import re
import requests
import os
import shutil
from bs4 import BeautifulSoup

args = sys.argv


def args_checker():
    if len(args) <= 1:
        print("No args provided.")
        exit(1)


def directory_setup():
    directory = "data/"

    for index, arg in enumerate(args):
        if arg == "-p":
            try:
                directory = args[index + 1]
            except IndexError:
                print("No folder provided for the flag -p.")
                args.pop(index)
                break
            del args[index:index + 2]
            break

    if os.path.isdir(directory) is True:
        shutil.rmtree(directory)
    os.mkdir(directory)
    os.chdir(directory)


args_checker()

url = args.pop()
print(f"Url provided: {url}")

directory_setup()

url_response = None
try:
    url_response = requests.get(url)
except requests.exceptions.RequestException as e:
    print(f"Error occured with the URL provided {e}")
    exit(1)
soup = BeautifulSoup(url_response.text, 'html.parser')
img_tags = soup.find_all('img')

urls = [img['src'] for img in img_tags]

for url in urls:
    filename = re.search(r'/([\w_-]+[.](jpg|jpeg|bmp|gif|png))$', url)
    if not filename:
        continue
    print(f"Download {filename.group(1)}")
    with open(filename.group(1), mode='wb') as f:
        response = requests.get(url)
        f.write(response.content)
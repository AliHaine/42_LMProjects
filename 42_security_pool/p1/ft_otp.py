import hashlib
from cryptography.fernet import Fernet

line = None
with open('key.txt', 'r') as f:
    line = f.readline()

hash_object = hashlib.sha1(bytes(line, encoding="ascii"))
with open('ft_otp.key', 'w') as f:
    f.write(hash_object.hexdigest())



hex_key = int(line, 16)
hex_key = str(line)
print(hex_key)
key = Fernet.generate_key()
print(key)
key = Fernet(key)
print(key.encrypt(hex_key.encode()))
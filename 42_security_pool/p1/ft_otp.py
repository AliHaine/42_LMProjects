from cryptography.fernet import Fernet

line = None
with open('key.txt', 'r') as f:
    line = f.readline()

key = Fernet.generate_key()
fernet_obj = Fernet(key)
crypt = fernet_obj.encrypt(line.encode())
print(f"Encrypted: {crypt.decode()}\nKey: {key.decode()}")
with open('ft_otp.key', 'w') as f:
    f.write(crypt.decode())

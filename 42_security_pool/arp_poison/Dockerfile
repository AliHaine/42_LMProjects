FROM python:3

WORKDIR /usr/src/app

RUN pip install scapy && \
    apt update && \
    apt -y install libpcap-dev &&\
    mkdir hacked

COPY inquisitor.py .

CMD ["tail", "-f", "/dev/null"]
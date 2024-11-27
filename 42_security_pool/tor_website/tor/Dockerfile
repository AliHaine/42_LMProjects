FROM debian:latest

RUN apt update -y && apt install tor -y

RUN echo "HiddenServiceDir /var/lib/tor/hidden_service/" > /etc/tor/torrc
RUN echo "HiddenServicePort 80 nginx:80" >> /etc/tor/torrc

CMD     ["tor"]
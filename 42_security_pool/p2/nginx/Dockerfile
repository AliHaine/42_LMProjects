FROM nginx:latest

RUN apt-get update && \
    apt-get install -y openssh-server

RUN echo "root:mdp" | chpasswd

COPY ./sshd_config 	/etc/ssh

CMD service ssh start && nginx -g 'daemon off;'
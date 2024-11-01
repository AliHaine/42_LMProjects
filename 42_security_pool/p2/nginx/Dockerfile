FROM nginx:latest

RUN apt-get update && \
    apt-get install -y openssh-server

RUN echo "root:mdp" | chpasswd

# Update SSH config to allow password authentication and root login
RUN sed -i 's/#PermitRootLogin prohibit-password/PermitRootLogin yes/' /etc/ssh/sshd_config && \
    echo "PasswordAuthentication yes" >> /etc/ssh/sshd_config

EXPOSE 1212

CMD service ssh start && nginx -g 'daemon off;'
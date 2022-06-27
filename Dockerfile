FROM ubuntu

RUN apt-get update

RUN apt-get install telnet -y

RUN apt-get install curl -y

RUN apt-get install iputils-ping -y

CMD ["sh", "-c", "tail -f /dev/null"]
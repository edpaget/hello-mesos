FROM java:openjdk-7-jdk

RUN wget -q -O /usr/local/bin/lein https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein && \
    chmod +x /usr/local/bin/lein

ADD . /hello-mesos
WORKDIR /hello-mesos

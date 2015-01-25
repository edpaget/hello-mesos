FROM garland/mesosphere-docker-mesos-master:latest

RUN apt-get update
RUN apt-get install -y --no-install-recommends wget
RUN wget -q -O /usr/local/bin/lein https://raw.githubusercontent.com/technomancy/leiningen/stable/bin/lein 
RUN chmod +x /usr/local/bin/lein

ADD . /hello-mesos
WORKDIR /hello-mesos

RUN lein deps

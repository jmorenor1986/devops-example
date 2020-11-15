FROM ubuntu:latest
RUN apt-get update -y && apt-get install curl -y
RUN apt install openjdk-11-jre-headless -y
RUN  curl https://ftp.cixug.es/apache/kafka/2.6.0/kafka_2.13-2.6.0.tgz -o kafka.tgz
RUN tar -xvzf kafka.tgz --strip 1
COPY docker-entrypoint.sh docker-entrypoint.sh
ENTRYPOINT ['bin/zookeeper-server-start.sh','config/zookeeper.properties']


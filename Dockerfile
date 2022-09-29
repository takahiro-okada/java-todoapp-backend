FROM mysql:8.0-debian
RUN apt-get update #パッケージリストの更新
RUN apt-get -y install locales-all
ENV LANG ja_JP.UTF-8
ENV LANGUAGE ja_JP:ja
ENV LC_ALL ja_JP.UTF-8
COPY ./conf/mysql/my.cnf /etc/my.conf

# Reproduce memory leak in Spring Cloud Gateway

This project reproduces a major memory leak in Spring Cloud Gateway 2.2.4.

To reproduce the issue, two docker containers are launched using docker compose. One container
is running a minimal Spring Cloud Gateway application that will rewrite the response body
and the other container is running Apache web server with the gzip module enabled.

The memory leak is manifesting itself when the backend httpd server returns the response gzipped and
Spring Cloud Gateway is rewriting the response body. If the response is returned uncompressed, there
is no memory leak.

Build the two docker containers using maven and Java 11:

    mvn clean package

Launch the stack using docker-compose:

    docker-compose up

Run a load test script that will retrieve the content without any gzip compression. This will work
without any memory leak:

    ./load_test_nogzip.sh

The second load test will retrieve the content using gzip compression and will make the Spring Cloud Gateway
server to run out of memory after a few requests:

    ./load_test_gzip.sh

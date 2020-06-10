FROM httpd:2.4.43-alpine

# Enable gzip module
RUN printf "LoadModule deflate_module modules/mod_deflate.so\nSetOutputFilter DEFLATE\n" >>/usr/local/apache2/conf/httpd.conf

# Add 128 KB data file
RUN LC_CTYPE=C tr -dc 'a-z' </dev/random | head -c 131072 >/usr/local/apache2/htdocs/data.txt

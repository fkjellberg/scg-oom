#!/bin/bash

for i in {1..10000}; do
    curl -s -H "Accept-Encoding: gzip" http://localhost:8080/data.txt >/dev/null
    echo -n .
done

echo

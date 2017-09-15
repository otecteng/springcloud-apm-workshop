#!/usr/bin/env bash

./gradlew build
mv build/libs/app.jar docker/
cd docker
docker rmi workshop/bff:1
docker build -t workshop/bff:1 .
cd ..


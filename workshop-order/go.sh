#!/usr/bin/env bash

./gradlew build
mv build/libs/app.jar docker/
cd docker
docker rmi workshop/order:1
docker build -t workshop/order:1 .
cd ..


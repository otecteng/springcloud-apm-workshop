#!/usr/bin/env bash

./gradlew build
mv build/libs/app.jar docker/
cd docker
docker rmi workshop/product:1
docker build -t workshop/product:1 .
cd ..


#!/bin/bash

set -e

TYPE=${1:-publisher}

./gradlew shadowJar

if [ $TYPE = "publisher" ]
then
  docker build -t demopublisher --build-arg main=hu.bme.mit.inf.cps.demopublisher.ShapesApplication .
  docker run -it --rm demopublisher:latest
else
  docker build -t demosubscriber --build-arg main=hu.bme.mit.inf.cps.demopublisher.ShapesReceiverApplication .
  docker run -it --rm demosubscriber:latest
fi

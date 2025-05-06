#!/usr/bin/env bash

./mvnw package
docker build -t moex-api .
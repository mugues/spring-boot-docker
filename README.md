# spring-boot-docker [![Build Status](https://travis-ci.org/mugues/spring-boot-docker.svg?branch=master)](https://travis-ci.org/mugues/spring-boot-docker)

# Project Title

spring-boot-docker

## Getting Started
These instructions will get you a copy of the project up and running on your local machine for development and testing purposes. 

To compile it: change the propertyy docker.image.prefix on pom.xml: this property need to be set with your docker.io account
to build and push docker image
In maven settings.xml add the following entry:

```
<server>
      <id>docker.io</id>
      <username>username</username>
      <password>password</password>
    </server>
```

```
mvn clean install
```
 will compile, execute unit tests, run the spring boot application and execute IT tests on local spring boot application.
if you want to build the docker image on docker hub then

```
mvn dockerfile:build
```

Once created the image you can just user docker to start the container:

```
docker run -p 8080:8080 -t ${docker.image.prefix}/spring-boot-docker:latest
```

if you want to push the docker image on docker hub then:

```
mvn dockerfile:push
```

To launch SpringBoot application on local machine:

IDEA: 
Run com.sample.Application

Postman collection
https://www.getpostman.com/collections/8d1d8db7f814a3b404ca



### Prerequisites
mvn 3.x
jdk 8
docker

```
Give examples
```
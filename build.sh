#/bin/bash

cd spring-boot-activemq
mvn clean package 

cd ../spring-boot-actuator
mvn clean package 

cd ../spring-boot-hello
mvn clean package 

cd ../spring-boot-jsp
mvn clean package 

cd ../spring-boot-mongodb
mvn clean package 

cd ../spring-boot-mysql
mvn clean package 

cd ../spring-boot-rabbitmq
mvn clean package 

cd ../spring-boot-redis
mvn clean package 

cd ../spring-boot-restful
mvn clean package 

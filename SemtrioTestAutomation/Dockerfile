#Use the OpenJDK 14 image as the base image
FROM maven:3.8.6-jdk-11

#copy the app files from host machine to image file system
COPY src /home/SeleniumTestAutomationFramework/src
COPY pom.xml /home/SeleniumTestAutomationFramework
COPY testng.xml /home/SeleniumTestAutomationFramework

RUN mvn -f /home/SeleniumTestAutomationFramework/pom.xml clean test -DsikpTests=true


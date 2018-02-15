# Learning how to use java in Visual Studio Code

## Setup

### Install Java environment on Linux

[Install OpenJDK](http://openjdk.java.net/install/)

### Install Visual Studio code on Linux

To install Visual Studio code on Linux you have to follow the steps describe on this website
[Install vs Code](https://code.visualstudio.com/docs/setup/linux)

### Extensions in Visual Studio Code

Install the following extensions in vs Code :

* Debugger for Java
* Java Extension Pack
* Java Test Runner
* Language Support for Java
* Maven Project Explorer

### Setup Visual Studio Code

Go to Visual Studio Code settings. Find `java.home` setting and override its value with the path to your OpenJDK. On Ubuntu you should give the foolowing value
`usr/lib/jvm/java-8-openjdk-amd64` if you installed openjdk-8-jdk

### Last tip

When you will create a Java project you should have the following notifications in vs Code : "Classpath is incomplete. Only syntax errors will be reported".
To fix this warning you have to add a pom.xml file or a build.gradle file. Check this website for a [minimal pom.xml file](https://maven.apache.org/guides/introduction/introduction-to-the-pom.html) and this one for a [minimal build.gradle file](https://spring.io/guides/gs/gradle/)

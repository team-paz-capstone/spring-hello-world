Spring Boot Hello World
===

Playground for learning and experimenting with Spring Boot.

Getting Started
---

Make sure Java is installed on your system:
```bash
$ java -version
```

I am using JDK v. 8, which can be downloaded here: https://www.oracle.com/technetwork/java/javase/downloads/jdk8-downloads-2133151.html

It's a good idea if we standardize on a given version of Java, but for this project, it probably won't matter (as long as
you're using at least version 8).

```bash
Matthews-MBP:spring-hello-world matthewanderson$ java -version
java version "1.8.0_181"
Java(TM) SE Runtime Environment (build 1.8.0_181-b13)
Java HotSpot(TM) 64-Bit Server VM (build 25.181-b13, mixed mode)
Matthews-MBP:spring-hello-world matthewanderson$
```


You will also need to install Maven (Java's dependency management system and build tool - similar to NPM for Node or pip for Python.)
https://maven.apache.org/install.html

Verify Maven has installed correctly:
```bash
$ mvn -version
```

Running the application
---

After cloning the repository, execute the following command from the project root:

```bash
$ mvn spring-boot:run
```

The application should spin up - keep an eye on the terminal for any errors. I'm happy to help troubleshoot.

By default, the application will be running on **localhost:8080**.
# Reactive JVM applications with Eclipse Vert.x

Do you need to develop web applications that process tons of requests concurrently? Do you need to build applications that startup and scales quickly on your cloud environment? I'm going to introduce Eclipse Vert.x, a toolkit to build reactive applications on JVM that will make your wishes come true. Vert.x combines asynchronous programming model with simple APIs to allow you to easily build performant applications based on I/O processing like Web APIs servers, IoT message processors, etc. You will learn the fundamentals of Reactive programming with Vert.x and how to build a web application with Vert.x Web.

Slide deck link: https://redhat.slides.com/fguardia/vertx-introduction?token=B1JFkIqv

## Build

```bash
mvn clean compile
```

## Run

To run the `core` example:

```bash
mvn exec:java -Dexec.mainClass="io.slinkydeveloper.vertx.introduction.demo.core.Launcher"
```

To run the `web` example:

```bash
mvn exec:java -Dexec.mainClass="io.slinkydeveloper.vertx.introduction.demo.web.Launcher"
```

## About me
Francesco is a software engineer student, working at Red Hat and studying at Politecnico di Milano. He is an active member of Eclipse Vert.x community since two years and a couple of months ago he joined the Vert.x team in Red Hat. He manages various components of the stack, including OpenAPI integration & Event bus services. He's also experienced in NodeJS and Scala/Akka. He's a strong believer of Open Source and a racing cars passionate

Twitter: http://twitter.com/slinkyguardiani/

Github: http://github.com/slinkydeveloper/

# jaxrs-unit

A library for unit testing of JAX-RS application.
 
The goal is to write unit tests without a real JavaEE server. 
But tests use real JAX-RS implementation (Jersey or RestEasy) with in-memory containers. 

JaxRS Unit provides an API to encapsulate the specific im-memory containers.

## Build status

[![Build Status](https://buildhive.cloudbees.com/job/binout/job/jaxrs-unit/badge/icon)](https://buildhive.cloudbees.com/job/binout/job/jaxrs-unit)
 
## Environment

- `java-1.7`

## Build

```bash
mvn clean verify
```

## Usage


### Maven

Release versions are deployed on my repository :

```xml
<repository>
    <id>binout-cloudbees-release</id>
    <name>binout-cloudbees-release</name>
    <url>https://repository-binout.forge.cloudbees.com/release/</url>
</repository>
```

You have to add api dependency :

```xml
<dependency>
    <groupId>org.jaxrs-unit</groupId>
    <artifactId>jaxrs-unit-api</artifactId>
    <version>${version}</version>
    <scope>test</scope>
</dependency>
```

You have to choose an implementation :

- RestEasy
```xml
<dependency>
    <groupId>org.jaxrs-unit</groupId>
    <artifactId>jaxrs-unit-resteasy</artifactId>
    <version>${version}</version>
    <scope>test</scope>
</dependency>
```
- Jersey
```xml
<dependency>
    <groupId>org.jaxrs-unit</groupId>
    <artifactId>jaxrs-unit-jersey</artifactId>
    <version>${version}</version>
    <scope>test</scope>
</dependency>
```

### Hello World

Considering a JAX-RS resource :
```java
@Path("/hello")
public class HelloResource {
    @GET
    public String hello() {
        return "hello";
    }
}
```

You can write a unit test like this :
```java
public class HelloTest {
    private JaxrsServer server;

    @Before
    public void init() {
        server = JaxrsUnit.newServer(HelloResource.class);
    }

    @Test
    public void should_return_hello() {
        JaxrsResource resource = server.resource("/hello");

        JaxrsResponse response = resource.get();

        assertThat(response.ok()).isTrue();
        assertThat(response.content()).isEqualTo("hello");
    }
}
```

## TODO

- resource scanning
- resource injection
- jaxrs 2


### Create jar file with all dependencies

```groovy
jar {
    manifest {
        attributes "Main-Class": "lk.ijse.webservice.resource_access.Main"
    }

    from {
        configurations.compile.collect { it.isDirectory() ? it : zipTree(it) }
    }
}
```

### Add Procfile

```shell script
 web:java -jar build/libs/resource_accesss-1.0-SNAPSHOT.jar
```

### Add Build File

```shell script
build: gradle :jar
```
### Change port
```java

  private static int getPort() {
        return Integer.parseInt(System.getenv().getOrDefault("PORT", "5000"));
    }

  connector.setPort(getPort());    

```

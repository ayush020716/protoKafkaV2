## Package `org.example.config`

### Class `PropertiesLoader`

Loads application configuration from `application.properties` on the classpath.

#### Methods

- `public static Properties loadProperties()`
  - Reads `src/main/resources/application.properties` and returns a `Properties` instance.

#### Example

```java
Properties props = PropertiesLoader.loadProperties();
String topic = props.getProperty("kafka.topic.name");
```


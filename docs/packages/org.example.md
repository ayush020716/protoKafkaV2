## Package `org.example`

### Class `Main`

Entry point for the application.

#### Methods

- `public static void main(String[] args)`
  - Starts the Kafka service and subscribes to the configured topic.

#### Example

```java
public class Main {
    public static void main(String[] args) throws Exception {
        KafkaService service = new KafkaService();
        service.subscribe();
    }
}
```


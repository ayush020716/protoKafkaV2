## Package `org.example.kafka.service`

### Class `KafkaService`

High-level Kafka producer and consumer service for `Data.User` messages.

#### Constructors

- `public KafkaService()`
  - Loads `kafka.topic.name` and `kafka.default.key` from `application.properties` using `PropertiesLoader`.

#### Methods

- `public Future<RecordMetadata> sendMessage(Data.User user)`
  - Sends a `User` message to the configured topic with the default key.

- `public void subscribe()`
  - Subscribes a background consumer to the configured topic and logs consumed messages.

#### Example: Produce

```java
KafkaService service = new KafkaService();
User user = User.newBuilder()
    .setId("10")
    .setFirstName("FName")
    .setLastName("LName")
    .build();
service.sendMessage(user).get();
```

#### Example: Consume

```java
KafkaService service = new KafkaService();
service.subscribe();
```

#### Configuration

Set in `src/main/resources/application.properties`:

- `kafka.topic.name`
- `kafka.default.key`


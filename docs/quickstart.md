## Quickstart

### Prerequisites

- Java 17+
- Kafka at `localhost:9092`
- Confluent Schema Registry at `http://localhost:8081`

### Build

```bash
./gradlew build
```

### Configure

Edit `src/main/resources/application.properties`:

- `kafka.topic.name=myTopic`
- `kafka.default.key=myKey`

### Run Producer/Consumer

```bash
./gradlew run --args=""
```

Or invoke directly in code:

```java
KafkaService service = new KafkaService();
service.subscribe();
// service.sendMessage(user);
```


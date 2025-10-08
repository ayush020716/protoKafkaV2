## Package `org.example.kafka.builder`

### Class `KafkaProducerBuilder`

Factory for Kafka `Producer<String, Data.User>` configured for Confluent Protobuf serialization.

#### Methods

- `public static Producer KaKafkaProducerBuilder()`
  - Returns a configured `KafkaProducer<String, Data.User>`.
  - Bootstrap servers: `localhost:9092`
  - Value serializer: `KafkaProtobufSerializer`
  - Schema Registry: `http://localhost:8081`

#### Example

```java
Producer<String, User> producer = KafkaProducerBuilder.KaKafkaProducerBuilder();
producer.send(new ProducerRecord<>("myTopic", "myKey", user));
```

### Class `KafkaConsumerBuilder`

Factory for Kafka `Consumer<String, Data.User>` configured for Confluent Protobuf deserialization.

#### Methods

- `public static Consumer KafkaConsumerBuilder()`
  - Returns a configured `KafkaConsumer<String, Data.User>` and subscribes to `protoKafka`.
  - Bootstrap servers: `localhost:9092`
  - Group: `protobuf-consumer-group`
  - Auto offset reset: `earliest`
  - Auto commit: disabled
  - Value deserializer: `KafkaProtobufDeserializer` (specific type `Data.User`)

#### Example

```java
Consumer<String, User> consumer = KafkaConsumerBuilder.KafkaConsumerBuilder();
consumer.poll(Duration.ofSeconds(1));
```


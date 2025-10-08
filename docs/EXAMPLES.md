## Examples

### Produce a User message

```java
import Data.User;
import org.example.kafka.service.KafkaService;

KafkaService service = new KafkaService();
User user = User.newBuilder()
    .setId("123")
    .setFirstName("Ada")
    .setLastName("Lovelace")
    .build();
service.sendMessage(user).get();
```

### Consume messages

```java
KafkaService service = new KafkaService();
service.subscribe();
```

### Generate .proto from POJO

```java
import org.example.resolver.ProtoSchemaGenerator;

ProtoSchemaGenerator generator = new ProtoSchemaGenerator();
generator.generateProtobufSchema(org.example.model.User.class, "./ProtoFiles");
```


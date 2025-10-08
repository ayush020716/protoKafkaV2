## Package `org.example.model`

### Class `User`

Simple POJO representing a user. Contains private fields such as `id`, `firstName`, `lastName`, `email`, `age`, `password`, `address`, `phone`, `bio`.

#### Methods

- `public String toJSON()` — returns a naive JSON string of all fields.

#### Example

```java
User user = new User();
// set fields via reflection or add setters if needed
String json = user.toJSON();
```

Note: The generated Protobuf `Data.User` class (under `src/ProtoGen/...`) is separate and used for Kafka messaging.


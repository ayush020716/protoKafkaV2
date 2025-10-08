## Package `org.example.resolver`

Utilities for mapping Java types to Protobuf and generating `.proto` schemas.

### Class `ProtobufUtils`

Static helpers to determine mapping of Java primitives, collections, and maps to proto constructs.

#### Key Methods

- `public static boolean isPrimitiveType(Class<?> clazz)`
- `public static Class<?> getProtobufType(Class<?> clazz)`
- `public static boolean isPrimitiveListType(Class<?> clazz)`
- `public static Class<?> getProtoListType(Class<?> clazz)`
- `public static boolean isPrimitiveMapType(Class<?> clazz)`
- `public static Class<?> getProtoMapType(Class<?> clazz)`
- `public static boolean isPrimitiveKeyType(Class<?> clazz)`
- `public static Class<?> getProtoKeyType(Class<?> clazz)`

These use placeholder classes under `org.example.resolver.prototypes` (e.g., `int32`, `int64`, `string`, `map`, `repeated`, `bool`).

### Class `ProtoSchemaGenerator`

Generates `.proto` files for a given root class and its dependencies.

#### Methods

- `public void generateProtobufSchema(Class<?> rootClass, String outputDirectoryPath)`
  - Creates a `.proto` file for `rootClass` and nested dependencies.

- `public static void clearFile(String fileName)`
  - Utility to clear a file's contents.

#### Example

```java
ProtoSchemaGenerator generator = new ProtoSchemaGenerator();
generator.generateProtobufSchema(MyClass.class, "./ProtoFiles");
```


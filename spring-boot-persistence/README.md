# Spring Boot Persistence
Object-Relational Mapping (ORM) is the process of converting Java objects to database tables. In other words, this allows us to interact with a relational database without any SQL. The Java Persistence API (JPA) is a specification that defines how to persist data in Java applications. The primary focus of JPA is the ORM layer.

## Optional as Return Type
The Optional type was introduced in Java 8.  It provides a clear and explicit way to convey the message that there may not be a value, without using null.
When getting an Optional return type, we're likely to check if the value is missing, leading to fewer NullPointerExceptions in the applications. However the Optional type isn't suitable in all places.

An Optional type can be a return type for most methods except some scenarios discussed later in the tutorial.
Most of the time, returning an Optional is just fine:
```sh
public static Optional<User> findUserByName(String name) {
    User user = usersByName.get(name);
    Optional<User> opt = Optional.ofNullable(user);
    return opt;
}
```

## Spring Data Repositories - Collections X Stream
It's important to use Stream and List in the appropriate context, as using them in situations where they aren't the best choice may lead to issues such as poor performance or unexpected behavior. It's always good to evaluate alternatives and choose the one that's most suitable for the problem.

The **List is ideal for small result sets where all records are needed at once, while Stream is better for large result sets that can be processed one by one** and also where the client requires a Stream rather than a Collection.

While querying data in Stream, we should prefer a database query rather than the intermediate Stream methods if both can produce the same result.

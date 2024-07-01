```java
// imports

public class GrpcServer {

    private static int SERVER_PORT = 8000;

    public static void main(String[] args) {
        try {
            if (args.length > 0) SERVER_PORT = Integer.parseInt(args[0]);

            io.grpc.Server svc = ServerBuilder.forPort(SERVER_PORT)
                    .addService(new NameProcessor())
                    .build();

            svc.start();
            System.out.println("Server started on port " + SERVER_PORT);

            svc.awaitTermination();
        } catch (Exception ex) {
            System.err.println("An error occurred: " + ex.getMessage());
        }
    }
}
```

```java
// imports

public class NameProcessor extends NameServiceGrpc.NameServiceImplBase {
    // Default Instance for a easier implementation
    private Firestore firestore = FirestoreOptions.getDefaultInstance().getService();

    @Override
    public ...
}
```
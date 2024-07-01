```java
/*
* Cloud Function com trigger de PubSub
*/

// imports

public class Entrypoint implements BackgroundFunction<PSmessage> {
    // Default Instance for a easier implementation
    private static Firestore db = FirestoreOptions.getDefaultInstance().getService();

    @Override
    public void accept(PSmessage message, Context context) throws Exception {
        if (db == null) {
            throw new RuntimeException("Error connecting to Firestore");
        }
        String data = new String(Base64.getDecoder().decode(message.data));

        // process data
    }
}

public class PSmessage {
    String data;
    Map<String, String> attributes;
}

/*
* Cloud Function com trigger de HTTP
*/

// imports

public class Entrypoint implements HttpFunction {

    @Override
    public void service(HttpRequest request, HttpResponse response) throws Exception {
        BufferedWriter writer = response.getWriter();

        // ...

        writer.write(new Gson().toJson(...));
    }
}
```
```java
// imports

public class App {
    private static String svcIP = "localhost";
    private static int svcPort = 8000;
    private static ManagedChannel channel;
    private static NameServiceGrpc.NameServiceBlockingStub blockingStub;
    private static NameServiceGrpc.NameServiceStub noBlockStub;

    public static void main(String[] args) {
        try {
            if (args.length == 2) {
                svcIP = args[0];
                svcPort = Integer.parseInt(args[1]);
            }
            System.out.println("connected to " + svcIP + ":" + svcPort);
            channel = ManagedChannelBuilder.forAddress(svcIP, svcPort)
                    .usePlaintext()
                    .build();

            blockingStub = NameServiceGrpc.newBlockingStub(channel);
            noBlockStub = NameServiceGrpc.newStub(channel);

            // ...

            Thread.sleep(10000); // 10 seconds

            channel.shutdown();
        } catch (Exception ex) {
            System.out.println("Unhandled exception");
            ex.printStackTrace();
        }
    }

    // implement the service methods in the cliente side
    static void ...
}
```
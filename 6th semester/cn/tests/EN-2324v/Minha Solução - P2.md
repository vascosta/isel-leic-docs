# 9

## a
````java
// imports

public class FabricServer {

    private static int SERVER_PORT = 8000;

    public static void main(String[] args) {
        try {
            if (args.length > 0) SERVER_PORT = Integer.parseInt(args[0]);

            io.grpc.Server svc = ServerBuilder.forPort(SERVER_PORT)
                    .addService(new FabricProcessor())
                    .build();

            svc.start();
            System.out.println("Server started on port " + SERVER_PORT);

            svc.awaitTermination();
        } catch (Exception ex) {
            System.err.println("An error occurred: " + ex.getMessage());
        }
    }
}
````

````java
// imports

public class FabricProcessor extends FabricServiceGrpc.FabricServiceImplBase {

    @Override
    public StreamObserver<Measure> controller(StreamObserver<Command> responseObserver) {
        return new StreamObserver<Measure>() {
            @Override
            public void onNext(Measure measure) {
                Double value = measure.getValue();
                if (value > 100 && value < 500) {
                    Command cmd1 = Command.newBuilder().setCmd("Cmd1").build();
                    Command cmd2 = Command.newBuilder().setCmd("Cmd2").build();
                    Command cmd3 = Command.newBuilder().setCmd("Cmd3").build();
                    responseObserver.onNext(cmd1);
                    responseObserver.onNext(cmd2);
                    responseObserver.onNext(cmd3);
                } 
                else if (measure.getValue() > 500) {
                    Command turnOff = Command.newBuilder().setCmd("TurnOff").build();
                    responseObserver.onNext(turnOff);
                }
            }

            @Override
            public void onError(Throwable t) {
                // handle error
            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}
````

## b
````java
// imports

public class FabricApp {
    private static String svcIP = "localhost";
    private static int svcPort = 8000;
    private static ManagedChannel channel;
    private static FabricServiceGrpc.FabricServiceBlockingStub blockingStub;
    private static FabricServiceGrpc.FabricServiceStub noBlockStub;

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

            blockingStub = FabricServiceGrpc.newBlockingStub(channel);
            noBlockStub = FabricServiceGrpc.newStub(channel);

            StreamObserver<Command> responseObserver = new StreamObserver<Command>() {
                @Override
                public void onNext(Command command) {
                    System.out.println("Command received: " + command.getCmd());
                }

                @Override
                public void onError(Throwable throwable) {
                    // handle error
                }

                @Override
                public void onCompleted() {
                    System.out.println("All commands received");
                }
            };

            StreamObserver<Measure> requestObserver = noBlockStub.controller(responseObserver);

            List<Double> temperatures = Arrays.asList(10.0, 30.0, 150.0, 550.0);

            for (Double temp : temperatures) {
                requestObserver.onNext(
                    Measure
                        .newBuilder()
                        .setMachid("Mach99")
                        .setValue(temp)
                        .build()
                );
            }

            requestObserver.onCompleted();

            Thread.sleep(10000); // 10 seconds

            channel.shutdown();
        } catch (Exception ex) {
            System.out.println("Unhandled exception");
            ex.printStackTrace();
        }
    }
}
```
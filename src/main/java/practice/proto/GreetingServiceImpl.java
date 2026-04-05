package practice.proto;

import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreeterGrpc.GreeterImplBase {
    @Override
    public void sayHello(HelloRequest request, StreamObserver<HelloReply> responseObserver) {
        String name = request.getName();

        HelloReply reply = HelloReply.newBuilder()
                .setMessage("Hello " + name + ", gRPC is working!")
                .build();

        responseObserver.onNext(reply);
        responseObserver.onCompleted();
    }
}

package org.example;

import com.example.grpc.GreetingServiceGrpc;
import com.example.grpc.GreetingServiceOuterClass;

import io.grpc.stub.StreamObserver;

public class GreetingServiceImpl extends GreetingServiceGrpc.GreetingServiceImplBase {

	@Override
	public void greeting(GreetingServiceOuterClass.HelloRequest request,
			StreamObserver<GreetingServiceOuterClass.HelloResponse> responceObserver) {

		System.out.println("Request: " + request);

		GreetingServiceOuterClass.HelloResponse response = GreetingServiceOuterClass.HelloResponse.newBuilder()
				.setGreeting("Hello from server,  " + request.getName()).build();

		responceObserver.onNext(response);

		responceObserver.onCompleted();
	}

}

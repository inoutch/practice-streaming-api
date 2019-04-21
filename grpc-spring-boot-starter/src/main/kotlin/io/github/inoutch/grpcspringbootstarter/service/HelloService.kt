package io.github.inoutch.grpcspringbootstarter.service

import io.github.inoutch.grpccommon.HelloGrpc
import io.github.inoutch.grpccommon.HelloOuterClass
import io.grpc.stub.StreamObserver

class HelloService : HelloGrpc.HelloImplBase() {
    override fun hello(request: HelloOuterClass.HelloRequest?,
                       responseObserver: StreamObserver<HelloOuterClass.HelloResponse>?) {
        
    }
}

package io.github.inoutch.grpcclient

import io.github.inoutch.grpccommon.HelloGrpc
import io.github.inoutch.grpccommon.HelloOuterClass
import io.grpc.ManagedChannelBuilder

object GRpcClient {
    @JvmStatic
    fun main(args: Array<String>) {
        val channel = ManagedChannelBuilder.forAddress("localhost", 6565)
                .build()

        val stub = HelloGrpc.newBlockingStub(channel)
        val request = HelloOuterClass.HelloRequest.newBuilder()
                .setRequest("hey!")
                .build()

        val relay = stub.hello(request)
        println(relay.response)
    }
}

package com.bigdata.netty.grpc;

import com.bigdata.netty.proto.StreamRequest;
import com.bigdata.netty.proto.StreamResponse;
import com.bigdata.netty.proto.StudentServiceGrpc;

import com.bigdata.proto.*;
import io.grpc.ManagedChannel;
import io.grpc.ManagedChannelBuilder;
import io.grpc.stub.StreamObserver;

import java.time.LocalDateTime;
import java.util.Iterator;

public class GpcClient {

    public static void main(String[] args) {
        ManagedChannel managedChannel = ManagedChannelBuilder.forAddress("localhost",8899)
                .usePlaintext().build();

//        StudentServiceGrpc.StudentServiceBlockingStub blockingStub = StudentServiceGrpc.newBlockingStub(managedChannel);
//
//        MyResponse myResponse = blockingStub.getRealByUsername(MyRequest.newBuilder().setUsername("zhangsan").build());
//
//        System.out.println(myResponse.getRealname());
//        System.out.println("----------------------");
//        Iterator<StudentResponse> studentByAge = blockingStub.getStudentByAge(StudentRequest.newBuilder().setAge(20).build());
//        while (studentByAge.hasNext()){
//            StudentResponse studentResponse = studentByAge.next();
//            System.out.println(studentResponse.getName() + " " + studentResponse.getAge() + studentResponse.getCity());
//        }
//        System.out.println("--------------------");

//        //服务器端返回的结果  2
//        StreamObserver<StudentResponseList> streamObserver = new StreamObserver<StudentResponseList>() {
//            @Override
//            public void onNext(StudentResponseList value) {
//                value.getStudentResponseList().forEach(x->{
//                    System.out.println(x.getName());
//                    System.out.println(x.getCity());
//                    System.out.println(x.getAge());
//                    System.out.println("*********");
//                });
//            }
//
//            @Override
//            public void onError(Throwable t) {
//                System.out.println(t.getMessage());
//            }
//
//            @Override
//            public void onCompleted() {
//                System.out.println("completed!");
//            }
//        };
//
//        /**
//         *  客户端以流形式发送数据
//         */
        StudentServiceGrpc.StudentServiceStub stub = StudentServiceGrpc.newStub(managedChannel);
//        StreamObserver<StudentRequest> studentRequestStreamObserver = stub.getStudentWrapperByAges(streamObserver);
//
//        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(20).build());
//        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(21).build());
//        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(22).build());
//        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(24).build());
//        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(25).build());
//        studentRequestStreamObserver.onNext(StudentRequest.newBuilder().setAge(26).build());


        StreamObserver<StreamRequest> requestStreamObserver = stub.biTask(new StreamObserver<StreamResponse>() {
            @Override
            public void onNext(StreamResponse value) {
                System.out.println(value.getResponseInfo());

            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            @Override
            public void onCompleted() {
                System.out.println("onComplemed");
            }
        });

        for (int i = 0; i < 10; i++) {
            requestStreamObserver.onNext(StreamRequest.newBuilder().setRequestInfo(LocalDateTime.now().toString()).build());

            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                throw new RuntimeException(e);
            }
        }



//        studentRequestStreamObserver.onCompleted();
        try {
            Thread.sleep(500000);
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }
    }
}

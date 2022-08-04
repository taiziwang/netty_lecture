package com.bigdata.netty.grpc;

import com.bigdata.proto.*;
import com.bigdata.proto.StudentServiceGrpc.StudentServiceImplBase;
import io.grpc.stub.StreamObserver;

import java.util.UUID;

public class StudentServiceImpl extends StudentServiceImplBase {
    @Override
    public void getRealByUsername(MyRequest request, StreamObserver<MyResponse> responseObserver) {
        System.out.println("接收到客户端信息：" + request.getUsername());

        responseObserver.onNext(MyResponse.newBuilder().setRealname("Andrew").build());
        responseObserver.onCompleted();
    }


    @Override
    public void getStudentByAge(StudentRequest request, StreamObserver<StudentResponse> responseObserver) {
        System.out.println("接收到客户端信息：" + request.getAge());
        responseObserver.onNext(StudentResponse.newBuilder().setName("andrew1").setAge(10).setCity("beijing1").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("andrew2").setAge(20).setCity("beijing2").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("andrew3").setAge(30).setCity("beijing3").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("andrew4").setAge(40).setCity("beijing4").build());
        responseObserver.onNext(StudentResponse.newBuilder().setName("andrew5").setAge(50).setCity("beijing5").build());
        responseObserver.onCompleted();

    }

    /**
     * grpc双向流
     * @param responseObserver
     * @return
     */
    @Override
    public StreamObserver<StudentRequest> getStudentWrapperByAges(StreamObserver<StudentResponseList> responseObserver) {

        return new StreamObserver<StudentRequest>() {
            /**
             *  接受客户端的请求
             * @param value the value passed to the stream
             */
            @Override
            public void onNext(StudentRequest value) {
                System.out.println("onNext: " + value.getAge());
            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());
            }

            /**
             * kehuduan  all data send  over, chufa onCompeleted.
             */
            @Override
            public void onCompleted() {
                StudentResponse studentResponse = StudentResponse.newBuilder().setName("and").setAge(20).setCity("beijing").build();
                StudentResponse studentResponse1 = StudentResponse.newBuilder().setName("lisi").setAge(30).setCity("guangzhou").build();
                StudentResponseList studentResponseList = StudentResponseList.newBuilder().addStudentResponse(studentResponse).addStudentResponse(studentResponse1).build();
                responseObserver.onNext(studentResponseList);
                responseObserver.onCompleted();
            }
        };
    }

    @Override
    public StreamObserver<StreamRequest> biTask(StreamObserver<StreamResponse> responseObserver) {
        return new StreamObserver<StreamRequest>() {
            @Override
            public void onNext(StreamRequest value) {
                System.out.println(value.getRequestInfo());
                responseObserver.onNext(StreamResponse.newBuilder().setResponseInfo(UUID.randomUUID().toString()).build());


            }

            @Override
            public void onError(Throwable t) {
                System.out.println(t.getMessage());

            }

            @Override
            public void onCompleted() {
                responseObserver.onCompleted();
            }
        };
    }
}


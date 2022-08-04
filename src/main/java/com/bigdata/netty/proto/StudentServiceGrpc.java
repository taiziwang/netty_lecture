package com.bigdata.netty.proto;

import com.bigdata.proto.MyRequest;
import com.bigdata.proto.MyResponse;
import com.bigdata.proto.StudentRequest;
import com.bigdata.proto.StudentResponse;
import com.bigdata.proto.StudentResponseList;
import com.bigdata.proto.*;

import static io.grpc.MethodDescriptor.generateFullMethodName;

/**
 */
@javax.annotation.Generated(
    value = "by gRPC proto compiler (version 1.48.0)",
    comments = "Source: Student.proto")
@io.grpc.stub.annotations.GrpcGenerated
public final class StudentServiceGrpc {

  private StudentServiceGrpc() {}

  public static final String SERVICE_NAME = "com.bigdata.proto.StudentService";

  // Static method descriptors that strictly reflect the proto.
  private static volatile io.grpc.MethodDescriptor<com.bigdata.proto.MyRequest,
          com.bigdata.proto.MyResponse> getGetRealByUsernameMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetRealByUsername",
      requestType = com.bigdata.proto.MyRequest.class,
      responseType = com.bigdata.proto.MyResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.UNARY)
  public static io.grpc.MethodDescriptor<com.bigdata.proto.MyRequest,
          com.bigdata.proto.MyResponse> getGetRealByUsernameMethod() {
    io.grpc.MethodDescriptor<com.bigdata.proto.MyRequest, com.bigdata.proto.MyResponse> getGetRealByUsernameMethod;
    if ((getGetRealByUsernameMethod = StudentServiceGrpc.getGetRealByUsernameMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetRealByUsernameMethod = StudentServiceGrpc.getGetRealByUsernameMethod) == null) {
          StudentServiceGrpc.getGetRealByUsernameMethod = getGetRealByUsernameMethod =
              io.grpc.MethodDescriptor.<com.bigdata.proto.MyRequest, com.bigdata.proto.MyResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.UNARY)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetRealByUsername"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.bigdata.proto.MyRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.bigdata.proto.MyResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetRealByUsernameMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.bigdata.proto.StudentRequest,
          com.bigdata.proto.StudentResponse> getGetStudentByAgeMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentByAge",
      requestType = com.bigdata.proto.StudentRequest.class,
      responseType = com.bigdata.proto.StudentResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
  public static io.grpc.MethodDescriptor<com.bigdata.proto.StudentRequest,
          com.bigdata.proto.StudentResponse> getGetStudentByAgeMethod() {
    io.grpc.MethodDescriptor<com.bigdata.proto.StudentRequest, com.bigdata.proto.StudentResponse> getGetStudentByAgeMethod;
    if ((getGetStudentByAgeMethod = StudentServiceGrpc.getGetStudentByAgeMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentByAgeMethod = StudentServiceGrpc.getGetStudentByAgeMethod) == null) {
          StudentServiceGrpc.getGetStudentByAgeMethod = getGetStudentByAgeMethod =
              io.grpc.MethodDescriptor.<com.bigdata.proto.StudentRequest, com.bigdata.proto.StudentResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.SERVER_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudentByAge"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.bigdata.proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.bigdata.proto.StudentResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetStudentByAgeMethod;
  }

  private static volatile io.grpc.MethodDescriptor<com.bigdata.proto.StudentRequest,
          com.bigdata.proto.StudentResponseList> getGetStudentWrapperByAgesMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "GetStudentWrapperByAges",
      requestType = com.bigdata.proto.StudentRequest.class,
      responseType = com.bigdata.proto.StudentResponseList.class,
      methodType = io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
  public static io.grpc.MethodDescriptor<com.bigdata.proto.StudentRequest,
          com.bigdata.proto.StudentResponseList> getGetStudentWrapperByAgesMethod() {
    io.grpc.MethodDescriptor<com.bigdata.proto.StudentRequest, com.bigdata.proto.StudentResponseList> getGetStudentWrapperByAgesMethod;
    if ((getGetStudentWrapperByAgesMethod = StudentServiceGrpc.getGetStudentWrapperByAgesMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getGetStudentWrapperByAgesMethod = StudentServiceGrpc.getGetStudentWrapperByAgesMethod) == null) {
          StudentServiceGrpc.getGetStudentWrapperByAgesMethod = getGetStudentWrapperByAgesMethod =
              io.grpc.MethodDescriptor.<com.bigdata.proto.StudentRequest, com.bigdata.proto.StudentResponseList>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.CLIENT_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "GetStudentWrapperByAges"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.bigdata.proto.StudentRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  com.bigdata.proto.StudentResponseList.getDefaultInstance()))
              .build();
        }
      }
    }
    return getGetStudentWrapperByAgesMethod;
  }

  private static volatile io.grpc.MethodDescriptor<StreamRequest,
          StreamResponse> getBiTaskMethod;

  @io.grpc.stub.annotations.RpcMethod(
      fullMethodName = SERVICE_NAME + '/' + "BiTask",
      requestType = StreamRequest.class,
      responseType = StreamResponse.class,
      methodType = io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
  public static io.grpc.MethodDescriptor<StreamRequest,
      StreamResponse> getBiTaskMethod() {
    io.grpc.MethodDescriptor<StreamRequest, StreamResponse> getBiTaskMethod;
    if ((getBiTaskMethod = StudentServiceGrpc.getBiTaskMethod) == null) {
      synchronized (StudentServiceGrpc.class) {
        if ((getBiTaskMethod = StudentServiceGrpc.getBiTaskMethod) == null) {
          StudentServiceGrpc.getBiTaskMethod = getBiTaskMethod =
              io.grpc.MethodDescriptor.<StreamRequest, StreamResponse>newBuilder()
              .setType(io.grpc.MethodDescriptor.MethodType.BIDI_STREAMING)
              .setFullMethodName(generateFullMethodName(SERVICE_NAME, "BiTask"))
              .setSampledToLocalTracing(true)
              .setRequestMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  StreamRequest.getDefaultInstance()))
              .setResponseMarshaller(io.grpc.protobuf.lite.ProtoLiteUtils.marshaller(
                  StreamResponse.getDefaultInstance()))
              .build();
        }
      }
    }
    return getBiTaskMethod;
  }

  /**
   * Creates a new async stub that supports all call types for the service
   */
  public static StudentServiceStub newStub(io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceStub>() {
        @Override
        public StudentServiceStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceStub(channel, callOptions);
        }
      };
    return StudentServiceStub.newStub(factory, channel);
  }

  /**
   * Creates a new blocking-style stub that supports unary and streaming output calls on the service
   */
  public static StudentServiceBlockingStub newBlockingStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceBlockingStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceBlockingStub>() {
        @Override
        public StudentServiceBlockingStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceBlockingStub(channel, callOptions);
        }
      };
    return StudentServiceBlockingStub.newStub(factory, channel);
  }

  /**
   * Creates a new ListenableFuture-style stub that supports unary calls on the service
   */
  public static StudentServiceFutureStub newFutureStub(
      io.grpc.Channel channel) {
    io.grpc.stub.AbstractStub.StubFactory<StudentServiceFutureStub> factory =
      new io.grpc.stub.AbstractStub.StubFactory<StudentServiceFutureStub>() {
        @Override
        public StudentServiceFutureStub newStub(io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
          return new StudentServiceFutureStub(channel, callOptions);
        }
      };
    return StudentServiceFutureStub.newStub(factory, channel);
  }

  /**
   */
  public static abstract class StudentServiceImplBase implements io.grpc.BindableService {

    /**
     */
    public void getRealByUsername(com.bigdata.proto.MyRequest request,
                                  io.grpc.stub.StreamObserver<com.bigdata.proto.MyResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetRealByUsernameMethod(), responseObserver);
    }

    /**
     */
    public void getStudentByAge(com.bigdata.proto.StudentRequest request,
                                io.grpc.stub.StreamObserver<com.bigdata.proto.StudentResponse> responseObserver) {
      io.grpc.stub.ServerCalls.asyncUnimplementedUnaryCall(getGetStudentByAgeMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.bigdata.proto.StudentRequest> getStudentWrapperByAges(
        io.grpc.stub.StreamObserver<com.bigdata.proto.StudentResponseList> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getGetStudentWrapperByAgesMethod(), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<StreamRequest> biTask(
        io.grpc.stub.StreamObserver<StreamResponse> responseObserver) {
      return io.grpc.stub.ServerCalls.asyncUnimplementedStreamingCall(getBiTaskMethod(), responseObserver);
    }

    @Override public final io.grpc.ServerServiceDefinition bindService() {
      return io.grpc.ServerServiceDefinition.builder(getServiceDescriptor())
          .addMethod(
            getGetRealByUsernameMethod(),
            io.grpc.stub.ServerCalls.asyncUnaryCall(
              new MethodHandlers<
                      com.bigdata.proto.MyRequest,
                      com.bigdata.proto.MyResponse>(
                  this, METHODID_GET_REAL_BY_USERNAME)))
          .addMethod(
            getGetStudentByAgeMethod(),
            io.grpc.stub.ServerCalls.asyncServerStreamingCall(
              new MethodHandlers<
                      com.bigdata.proto.StudentRequest,
                      com.bigdata.proto.StudentResponse>(
                  this, METHODID_GET_STUDENT_BY_AGE)))
          .addMethod(
            getGetStudentWrapperByAgesMethod(),
            io.grpc.stub.ServerCalls.asyncClientStreamingCall(
              new MethodHandlers<
                      com.bigdata.proto.StudentRequest,
                      com.bigdata.proto.StudentResponseList>(
                  this, METHODID_GET_STUDENT_WRAPPER_BY_AGES)))
          .addMethod(
            getBiTaskMethod(),
            io.grpc.stub.ServerCalls.asyncBidiStreamingCall(
              new MethodHandlers<
                StreamRequest,
                StreamResponse>(
                  this, METHODID_BI_TASK)))
          .build();
    }
  }

  /**
   */
  public static final class StudentServiceStub extends io.grpc.stub.AbstractAsyncStub<StudentServiceStub> {
    private StudentServiceStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentServiceStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceStub(channel, callOptions);
    }

    /**
     */
    public void getRealByUsername(com.bigdata.proto.MyRequest request,
                                  io.grpc.stub.StreamObserver<com.bigdata.proto.MyResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncUnaryCall(
          getChannel().newCall(getGetRealByUsernameMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public void getStudentByAge(com.bigdata.proto.StudentRequest request,
                                io.grpc.stub.StreamObserver<com.bigdata.proto.StudentResponse> responseObserver) {
      io.grpc.stub.ClientCalls.asyncServerStreamingCall(
          getChannel().newCall(getGetStudentByAgeMethod(), getCallOptions()), request, responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<com.bigdata.proto.StudentRequest> getStudentWrapperByAges(
        io.grpc.stub.StreamObserver<com.bigdata.proto.StudentResponseList> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncClientStreamingCall(
          getChannel().newCall(getGetStudentWrapperByAgesMethod(), getCallOptions()), responseObserver);
    }

    /**
     */
    public io.grpc.stub.StreamObserver<StreamRequest> biTask(
        io.grpc.stub.StreamObserver<StreamResponse> responseObserver) {
      return io.grpc.stub.ClientCalls.asyncBidiStreamingCall(
          getChannel().newCall(getBiTaskMethod(), getCallOptions()), responseObserver);
    }
  }

  /**
   */
  public static final class StudentServiceBlockingStub extends io.grpc.stub.AbstractBlockingStub<StudentServiceBlockingStub> {
    private StudentServiceBlockingStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentServiceBlockingStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceBlockingStub(channel, callOptions);
    }

    /**
     */
    public com.bigdata.proto.MyResponse getRealByUsername(com.bigdata.proto.MyRequest request) {
      return io.grpc.stub.ClientCalls.blockingUnaryCall(
          getChannel(), getGetRealByUsernameMethod(), getCallOptions(), request);
    }

    /**
     */
    public java.util.Iterator<com.bigdata.proto.StudentResponse> getStudentByAge(
        com.bigdata.proto.StudentRequest request) {
      return io.grpc.stub.ClientCalls.blockingServerStreamingCall(
          getChannel(), getGetStudentByAgeMethod(), getCallOptions(), request);
    }
  }

  /**
   */
  public static final class StudentServiceFutureStub extends io.grpc.stub.AbstractFutureStub<StudentServiceFutureStub> {
    private StudentServiceFutureStub(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      super(channel, callOptions);
    }

    @Override
    protected StudentServiceFutureStub build(
        io.grpc.Channel channel, io.grpc.CallOptions callOptions) {
      return new StudentServiceFutureStub(channel, callOptions);
    }

    /**
     */
    public com.google.common.util.concurrent.ListenableFuture<com.bigdata.proto.MyResponse> getRealByUsername(
        com.bigdata.proto.MyRequest request) {
      return io.grpc.stub.ClientCalls.futureUnaryCall(
          getChannel().newCall(getGetRealByUsernameMethod(), getCallOptions()), request);
    }
  }

  private static final int METHODID_GET_REAL_BY_USERNAME = 0;
  private static final int METHODID_GET_STUDENT_BY_AGE = 1;
  private static final int METHODID_GET_STUDENT_WRAPPER_BY_AGES = 2;
  private static final int METHODID_BI_TASK = 3;

  private static final class MethodHandlers<Req, Resp> implements
      io.grpc.stub.ServerCalls.UnaryMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ServerStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.ClientStreamingMethod<Req, Resp>,
      io.grpc.stub.ServerCalls.BidiStreamingMethod<Req, Resp> {
    private final StudentServiceImplBase serviceImpl;
    private final int methodId;

    MethodHandlers(StudentServiceImplBase serviceImpl, int methodId) {
      this.serviceImpl = serviceImpl;
      this.methodId = methodId;
    }

    @Override
    @SuppressWarnings("unchecked")
    public void invoke(Req request, io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_REAL_BY_USERNAME:
          serviceImpl.getRealByUsername((MyRequest) request,
              (io.grpc.stub.StreamObserver<MyResponse>) responseObserver);
          break;
        case METHODID_GET_STUDENT_BY_AGE:
          serviceImpl.getStudentByAge((StudentRequest) request,
              (io.grpc.stub.StreamObserver<StudentResponse>) responseObserver);
          break;
        default:
          throw new AssertionError();
      }
    }

    @Override
    @SuppressWarnings("unchecked")
    public io.grpc.stub.StreamObserver<Req> invoke(
        io.grpc.stub.StreamObserver<Resp> responseObserver) {
      switch (methodId) {
        case METHODID_GET_STUDENT_WRAPPER_BY_AGES:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.getStudentWrapperByAges(
              (io.grpc.stub.StreamObserver<StudentResponseList>) responseObserver);
        case METHODID_BI_TASK:
          return (io.grpc.stub.StreamObserver<Req>) serviceImpl.biTask(
              (io.grpc.stub.StreamObserver<StreamResponse>) responseObserver);
        default:
          throw new AssertionError();
      }
    }
  }

  private static volatile io.grpc.ServiceDescriptor serviceDescriptor;

  public static io.grpc.ServiceDescriptor getServiceDescriptor() {
    io.grpc.ServiceDescriptor result = serviceDescriptor;
    if (result == null) {
      synchronized (StudentServiceGrpc.class) {
        result = serviceDescriptor;
        if (result == null) {
          serviceDescriptor = result = io.grpc.ServiceDescriptor.newBuilder(SERVICE_NAME)
              .addMethod(getGetRealByUsernameMethod())
              .addMethod(getGetStudentByAgeMethod())
              .addMethod(getGetStudentWrapperByAgesMethod())
              .addMethod(getBiTaskMethod())
              .build();
        }
      }
    }
    return result;
  }
}

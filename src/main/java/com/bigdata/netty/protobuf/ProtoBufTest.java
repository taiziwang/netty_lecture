package com.bigdata.netty.protobuf;

import com.google.protobuf.InvalidProtocolBufferException;

// wangsha@wangshadeiMac netty_lecture % protoc --java_out=src/main/java src/protobuf/Student.proto
public class ProtoBufTest {

    public static void main(String[] args) throws InvalidProtocolBufferException {

        //定以一个student对象，在A服务器上
        DataInfo.Student student = DataInfo.Student.newBuilder().setName("andrew").setAge(20).setAddress("北京").build();
        //序列化一个数组，可以在网络上传输
        byte[] student2ByteArray= student.toByteArray();
        //反序列化，在B服务器上
        DataInfo.Student student2 = DataInfo.Student.parseFrom(student2ByteArray);

        System.out.println(student2);

        System.out.println(student2.getAddress());
        System.out.println(student2.getName());
        System.out.println(student2.getAge());

    }

}

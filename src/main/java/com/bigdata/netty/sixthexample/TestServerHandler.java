package com.bigdata.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

public class TestServerHandler extends SimpleChannelInboundHandler<MyDataInfo.MyMessage> {

    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.MyMessage msg) throws Exception {
        MyDataInfo.MyMessage.DataType dataType = msg.getDataType();
        if(dataType == MyDataInfo.MyMessage.DataType.PersonType){
            MyDataInfo.People person = msg.getPerson();
            System.out.println(person.getAddress());
            System.out.println(person.getAge());
            System.out.println(person.getName());

        }else if(dataType == MyDataInfo.MyMessage.DataType.DogType){
            MyDataInfo.Dog dog = msg.getDog();
            System.out.println(dog.getAddress());
            System.out.println(dog.getName());

        }else {
            MyDataInfo.Cat cat = msg.getCat();
            System.out.println(cat.getCity());
            System.out.println(cat.getName());

        }
    }
}

package com.bigdata.netty.sixthexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.Random;

public class MyClientHandler  extends SimpleChannelInboundHandler<MyDataInfo.People> {
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, MyDataInfo.People msg) throws Exception {

    }

    //链接激活 每次启动发送的消息可以达到不一样

    /**
     *  客户端给服务端发送多协议消息
     * @param ctx
     * @throws Exception
     */
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {

        int ramdomInt = new Random().nextInt(3);
        MyDataInfo.MyMessage myMessage = null;
        if(0 ==  ramdomInt){

            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.PersonType)
                    .setPerson(MyDataInfo.People.newBuilder()
                            .setAddress("上海").setName("Andrew").setAge(18).build())
                    .build();
        }else if( 1 ==  ramdomInt){
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.DogType)
                    .setDog(MyDataInfo.Dog.newBuilder()
                            .setName("Andrew_dog").setAddress("北京").build())
                    .build();
        }else {
            myMessage = MyDataInfo.MyMessage.newBuilder()
                    .setDataType(MyDataInfo.MyMessage.DataType.CateType)
                    .setCat(MyDataInfo.Cat.newBuilder()
                            .setName("Andrew_Cat").setCity("湖北").build())
                    .build();
        }
        // 客户端一链接上服务端，立马发送一条消息person
        ctx.channel().writeAndFlush(myMessage);
    }
}

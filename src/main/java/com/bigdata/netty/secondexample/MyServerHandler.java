package com.bigdata.netty.secondexample;

import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;

import java.util.UUID;

public class MyServerHandler extends SimpleChannelInboundHandler<String> {  //String 范型
     //客户端 发送过来的 String msg
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        System.out.println(ctx.channel().remoteAddress() + "," + msg);
        ctx.channel().writeAndFlush("from server: "+ UUID.randomUUID());
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
                cause.printStackTrace();
                ctx.close();
    }
}

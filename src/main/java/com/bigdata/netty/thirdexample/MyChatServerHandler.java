package com.bigdata.netty.thirdexample;

import io.netty.channel.Channel;
import io.netty.channel.ChannelHandlerContext;
import io.netty.channel.SimpleChannelInboundHandler;
import io.netty.channel.group.ChannelGroup;
import io.netty.channel.group.DefaultChannelGroup;
import io.netty.util.concurrent.GlobalEventExecutor;


/**
 *业务内容    实现客户端发送消息/上下线操作，由服务端进行广播给其他客户端
 *
 */
public class MyChatServerHandler extends SimpleChannelInboundHandler<String> {
     // 将链接好的客户端存放在channelGroup
    private static ChannelGroup channelGroup = new DefaultChannelGroup(GlobalEventExecutor.INSTANCE);

     //服务端收到任意客户端发送的消息，都会回调channelRead0
    @Override
    protected void channelRead0(ChannelHandlerContext ctx, String msg) throws Exception {
        Channel channel = ctx.channel();

        channelGroup.forEach(ch ->{
            if(channel !=ch){
                ch.writeAndFlush(ch.remoteAddress()+" 发送的消息： "+msg + "\n");
            }else {
                ch.writeAndFlush("[自己]" + msg + "\n");
            }
        });
    }

    //客户端和服务端建立好链接
    @Override
    public void handlerAdded(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[服务器] - "+channel.remoteAddress() + " 加入\n"); //广播消息到消息组
        channelGroup.add(channel);
    }

    @Override
    public void exceptionCaught(ChannelHandlerContext ctx, Throwable cause) throws Exception {
        cause.printStackTrace();
        ctx.close();
    }

    //链接断开
    @Override
    public void handlerRemoved(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        channelGroup.writeAndFlush("[服务器] - "+channel.remoteAddress() + " 离开\n");
        //channelGroup.remove(channel);  无需手动调用删除channel
    }

    //链接处于活动状态， 即上线
    @Override
    public void channelActive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + " 上线");
    }

    //链接处于不活动状态，即下线
    @Override
    public void channelInactive(ChannelHandlerContext ctx) throws Exception {
        Channel channel = ctx.channel();
        System.out.println(channel.remoteAddress() + "下线");
    }
}

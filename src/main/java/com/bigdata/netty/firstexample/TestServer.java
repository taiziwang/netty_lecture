package com.bigdata.netty.firstexample;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

public class TestServer {

    public static void main(String[] args) throws InterruptedException {
        //定义两个事件循环组  就是一个死循环
        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();  //bossGroup获取链接，分给workGroup处理

        try {
            ServerBootstrap serverBootstrap = new ServerBootstrap();  //简化服务器启动class
            serverBootstrap.group(bossGroup,workerGroup)
                    .channel(NioServerSocketChannel.class) //
                    .childHandler(new TestServerInitializer());

            ChannelFuture channelfuture = serverBootstrap.bind(8899).sync();
            channelfuture.channel().closeFuture().sync();
        }finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }

    }
}

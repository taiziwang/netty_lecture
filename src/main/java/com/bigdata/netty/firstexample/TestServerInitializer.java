package com.bigdata.netty.firstexample;

import com.bigdata.netty.firstexample.TestHttpServerHandler;
import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpServerCodec;

public class TestServerInitializer extends ChannelInitializer<SocketChannel>{

    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        //HttpServerCodec  = 客户端请求netty解码 + 服务端netty响应编码
        pipeline.addLast("httpServerCodec",new HttpServerCodec());
        pipeline.addLast("testHttpServerHandler",new TestHttpServerHandler());


    }
}

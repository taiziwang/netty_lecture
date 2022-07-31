package com.bigdata.netty.fifthexample;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.stream.ChunkedWriteHandler;

public class WebSocketInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(new HttpServerCodec());
        pipeline.addLast(new ChunkedWriteHandler()); //chunk 块  ；以块的名义去写
        pipeline.addLast(new HttpObjectAggregator(8192));  //netty 聚合一个8192长度的http请求

        pipeline.addLast(new WebSocketServerProtocolHandler("/ws"));  // ws://server:port/context_path===>ws://server:port/ws1
        pipeline.addLast(new TextWebSocketFrameHandler());

    }
}

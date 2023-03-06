package org.example.secondexample;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioSocketChannel;

public class MyClient {
    public static void main(String[] args) throws Exception {
        // 获取链接
        EventLoopGroup eventGroup = new NioEventLoopGroup();
        // 业务处理
        try {
            Bootstrap bootstrap = new Bootstrap();
            bootstrap.group(eventGroup).channel(NioSocketChannel.class)
                    .handler(new MyClientInitializer());
            ChannelFuture sync = bootstrap.connect("localhost", 8888).sync();
            sync.channel().closeFuture().sync();
        } finally {
            eventGroup.shutdownGracefully();
        }

    }
}

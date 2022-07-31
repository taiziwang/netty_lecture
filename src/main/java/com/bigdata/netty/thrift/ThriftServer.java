package com.bigdata.netty.thrift;

import org.apache.thrift.TProcessorFactory;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.server.THsHaServer;
import org.apache.thrift.server.TServer;
import org.apache.thrift.transport.TNonblockingServerSocket;
import org.apache.thrift.transport.layered.TFramedTransport;
import thrift.generated.PersonService;

public class ThriftServer {

    public static void main(String[] args) throws Exception {
        /**
         * Thrift数据传输方式:
         * TScoket  阻塞socket
         * TFramedTransport  以frame为单位进行传输，非阻塞式服务中使用；websocket 也类似用frame传输      ***************************************使用多
         * TFileTransport    以文件形式进行传输
         * TMemoryTransport  将内存用于I/O。Java实现内部实际使用了简单的ByteArrayOutPutStream
         * TZlibTransport    使用zlib进行压缩，与其他传输方式联合使用。当前无Java实现
         */
        TNonblockingServerSocket socket = new TNonblockingServerSocket(8899);


        THsHaServer.Args  arg = new THsHaServer.Args(socket).minWorkerThreads(2).maxWorkerThreads(4);
        PersonService.Processor<PersonServiceImpl> processor = new PersonService.Processor<>(new PersonServiceImpl());
        /**
         * Thrift传输格式
         * TBinaryProtocol 二进制格式
         * TCompactProtocol 压缩格式 效率更高基于二进制压缩    ********************使用多
         * TJsonProtocol  JSON格式
         * TSimpleJSONProtocol  提供JSON只写协议，生成的文件很容易通过脚本语言解析；即缺少 meta信息
         * TDebugProtocol 使用易懂的可读的文件格式，以便于debug
         */
        arg.protocolFactory(new TCompactProtocol.Factory());
        arg.transportFactory(new TFramedTransport.Factory());
        arg.processorFactory(new TProcessorFactory(processor));

            /**
             * Thrift支持的服务模型 ---半同步半异步 需使用TFramedTransport传输方式
             * TSimpleServer 简单的单线程服务模型 常用与测试
             * TThreadPoolServer 多线程服务模型  使用标准的阻塞式IO---利用线程池
             * TNonblockingServer 多线程服务模型 使用非阻塞IO（需使用TFramedTransport数据传输方式）
             * THsHaServer THsHa引入了线程池去处理，其模型把读写任务放到线程池去处理；Half-sync/Half-async的处理方式，Half-aysnc是在      ************************使用多
             * 处理IO事件上（accept/read/write io），Half-sync 用于handler对rpc的同步处理*
             */

        TServer server = new THsHaServer(arg);

        System.out.println("Thrift Server Started!");
        server.serve();
    }
}

package com.bigdata.netty.thrift;

import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.thrift.protocol.TCompactProtocol;
import org.apache.thrift.protocol.TProtocol;
import org.apache.thrift.transport.TSocket;
import org.apache.thrift.transport.TTransport;
import org.apache.thrift.transport.TTransportException;
import org.apache.thrift.transport.layered.TFramedTransport;
import thrift.generated.Person;
import thrift.generated.PersonService;

public class ThriftClient {

    public static void main(String[] args) throws TTransportException {
        /**
         * Thrift数据传输方式:
         * TScoket  阻塞socket
         * TFramedTransport  以frame为单位进行传输，非阻塞式服务中使用；websocket 也类似用frame传输
         * TFileTransport    以文件形式进行传输
         * TMemoryTransport  将内存用于I/O。Java实现内部实际使用了简单的ByteArrayOutPutStream
         * TZlibTransport    使用zlib进行压缩，与其他传输方式联合使用。当前无Java实现
         *
         *
         */
        TTransport transport = new TFramedTransport(new TSocket("127.0.0.1",8899),600);
        /**
         * Thrift传输格式
         * TBinaryProtocol 二进制格式
         * TCompactProtocol 压缩格式 效率更高基于二进制压缩
         * TJsonProtocol  JSON格式
         * TSimpleJSONProtocol  提供JSON只写协议，生成的文件很容易通过脚本语言解析；即缺少 meta信息
         * TDebugProtocol 使用易懂的可读的文件格式，以便于debug
         */
        TProtocol protocol = new TCompactProtocol(transport);
        PersonService.Client client = new PersonService.Client(protocol);

        try{
            transport.open();

            Person person= client.getPersonByUsername("java_zhangsan");
            System.out.println(person.getUsername());
            System.out.println(person.getAge());
            System.out.println(person.isMarried());

            System.out.println("---------");

            Person person2 =  new Person();
            person2.setUsername("java_lisi");
            person2.setAge(30);
            person2.setMarried(true);

            client.savePerson(person2);
        }catch (Exception ex){
            System.out.println(ExceptionUtils.getMessage(ex));
            throw new RuntimeException(ex.getMessage(),ex);
        }finally {
            transport.close();
        }
    }
}

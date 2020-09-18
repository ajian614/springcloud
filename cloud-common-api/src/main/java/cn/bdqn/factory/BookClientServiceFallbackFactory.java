package cn.bdqn.factory;

import cn.bdqn.entity.Book;
import cn.bdqn.service.BookClientService;
import feign.hystrix.FallbackFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * @Classname BookClientServiceFallbackFactory
 * @Description TODO
 * @Date 2020/9/10 16:17
 * @Created by x1c
 */
@Component
public class BookClientServiceFallbackFactory implements FallbackFactory<BookClientService> {
    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @Override
    public BookClientService create(Throwable throwable) {
        return new BookClientService(){
            @Override
            public Book getBook(Integer bookId) {
                return new Book(bookId,"缺省值（无法查询到对应服务所提供的书籍信息，因为监控到对方服务不可用，实行了服务的降级处理）",serverPort,ip);
            }
        };
    }
}

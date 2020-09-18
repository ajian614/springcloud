package cn.bdqn.service.impl;

import cn.bdqn.entity.Book;
import cn.bdqn.mapper.BookMapper;
import cn.bdqn.service.BookService;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

/**
 * @Classname BookServiceImpl
 * @Description TODO
 * @Date 2020/3/6 16:37
 * @Created by x1c
 */
@SuppressWarnings("ALL")
@Service
public class BookServiceImpl implements BookService {
    @Autowired
    private BookMapper bookMapper;

    @Value("${server.port}")
    private String port;

    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @Override
    @HystrixCommand(fallbackMethod = "getBookById_fallback",commandProperties = {
            @HystrixProperty(name = "circuitBreaker.enabled",value = "true"),
            @HystrixProperty(name = "circuitBreaker.requestVolumeThreshold",value = "10"),
            @HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds",value = "10000"),
            @HystrixProperty(name = "circuitBreaker.errorThresholdPercentage",value = "60")
    })
    public Book getBookById(Integer bookId) {
        Book book = bookMapper.getBookById(bookId);
        if(book == null){
            throw new RuntimeException("图书编号【"+bookId+"】查询不到该图书信息！");
        }
        return book;
    }

    public Book getBookById_fallback(Integer bookId) {
        return new Book(bookId,"查询不到该图书信息","",ip+":"+port);
    }


}

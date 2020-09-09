package cn.bdqn.web.controller;

import cn.bdqn.entity.Book;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname BookController
 * @Description TODO
 * @Date 2020/9/3 12:06
 * @Created by x1c
 */
@RestController
@RequestMapping("/book")
public class BookController {
    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @GetMapping("/getBook/{bookId}")
    public Book getBook(@PathVariable("bookId") Integer bookId){
        return new Book(bookId,"西游记",serverPort,ip);
    }
}

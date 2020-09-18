package cn.bdqn.web.controller;

import cn.bdqn.entity.Book;
import cn.bdqn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Classname BookController
 * @Description TODO
 * @Date 2020/9/3 2:12
 * @Created by x1c
 */

@RestController
@RequestMapping("/book")
public class BookController {

    @Value("${server.port}")
    private String serverPort;

    @Value("${spring.cloud.client.ip-address}")
    private String ip;

    @Autowired
    private BookService bookService;

    @RequestMapping("/getBooks/{bookId}")
    public Book getBooks(@PathVariable Integer bookId) {
        Book book = bookService.getBookById(bookId);
        book.setServerPort(serverPort);
        book.setIp(ip);
        return book;
    }

    @RequestMapping("/getTests/{bookId}")
    public String getTests(@PathVariable Integer bookId) {
        return ip+":"+serverPort;
    }
}
package cn.bdqn.web.controller;

import cn.bdqn.entity.Book;
import cn.bdqn.service.BookClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

/**
 * @Classname OrderController
 * @Description TODO
 * @Date 2020/9/4 9:02
 * @Created by x1c
 */


@SuppressWarnings("ALL")
@RestController
@RequestMapping("/order2")
public class OrderOpenFeignController {
    @Autowired
    private BookClientService service;

    @GetMapping("/downOrder/{bookId}")
    public String downOrder(@PathVariable Integer bookId){
        Book book = service.getBook(bookId);
        return "下单成功，购买图书为："+book;
    }

}

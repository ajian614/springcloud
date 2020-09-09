package cn.bdqn.web.controller;

import cn.bdqn.entity.Book;
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

@RestController
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private RestTemplate restTemplate;

    private static String REMOTE_URL="http://cloud-provider-goods";

    @GetMapping("/getBookInfo/{bookId}")
    public String buyBook(@PathVariable Integer bookId){

        // 远程调用模板类
        String respStr = restTemplate.getForObject(REMOTE_URL + "/book/getBook/{"+bookId+"}", String.class);
        return "下单成功，购买图书为："+respStr;
    }

}

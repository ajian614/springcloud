package cn.bdqn.service;

import cn.bdqn.entity.Book;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

/**
 * @Classname BookClientService
 * @Description TODO
 * @Date 2020/9/7 9:45
 * @Created by x1c
 */
// valus:需要调用的远程服务名
@FeignClient(value = "cloud-provider-goods",path = "/book")
//@RequestMapping("/book")
public interface BookClientService {

    // 提供一个借口的定义，便于openfegin在底层利用ribbon+restTemplate生成一个可以支持服务调用和负载均衡的对应接口实现类

    @GetMapping("/getBook/{bookId}") // openfegin支持spring mvc注解
    public Book getBook(@PathVariable("bookId") Integer bookId);  // 注意：如果是用ant风格，@PathVarable必须指定value属性名


    // 底层首先会生成一个bookClientService的代理实现类
    // 这个实现类里面的内容，几乎我们可以认为就是一套RestTeamplate调用http://cloud-provider-goods/book/getBook/{bookId}
    // 并按当前所定义的接口定义方法的返回类型进行获取调用后反回的结果
}

package cn.bdqn.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @Classname Book
 * @Description TODO
 * @Date 2020/9/7 9:08
 * @Created by x1c
 */
@Data   //   set get equas hashcode tostring
@NoArgsConstructor
public class Book {
    private String bookId;
    private String bookName;
    private String serverPort;
    private String ip;
}

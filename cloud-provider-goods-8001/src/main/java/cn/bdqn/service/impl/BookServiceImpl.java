package cn.bdqn.service.impl;

import cn.bdqn.entity.Book;
import cn.bdqn.mapper.BookMapper;
import cn.bdqn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
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

    @Override
    public Book getBookById(Integer bookId) {
        return bookMapper.getBookById(bookId);
    }
}

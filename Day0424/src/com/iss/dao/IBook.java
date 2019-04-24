package com.iss.dao;

import com.iss.po.Books;
import org.apache.ibatis.annotations.Select;

import java.util.List;

/**
 * @Author By gaojiaming1227@gmail.com Employer Gao
 * @date 2019/4/24
 */
public interface IBook {

    @Select("select * from books")
    public List<Books> getAllBook();

}

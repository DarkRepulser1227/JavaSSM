package com.iss.dao;

import com.iss.po.Books;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IBooks {

    @Select("select * from books")
    public List<Books> getAllBook();

    @Select("select * from books LIMIT #{begin},#{rows}")
    public List<Books> getBooksByPage(@Param("begin")int begin,@Param("rows")int rows);

    @Select("select count(*) from books")
    public int getBookCount();
}

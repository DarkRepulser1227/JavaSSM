package com.iss;

import com.iss.po.Books;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface IBooks {

    @Select("select * from books")
    public List<Books> getAllBook();
}

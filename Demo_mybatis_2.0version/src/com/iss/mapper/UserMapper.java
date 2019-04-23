<<<<<<< HEAD
package com.iss.mapper;

import com.iss.po.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from users")
    public List<Users> findAllUser();

    @Insert("insert into users values (#{uname},#{upwd})")
    public int addUser(Users users);

    @Update("update users set upwd=#{upwd} where uname=#{uname}")
    public int editUser(Users users);

    @Delete("delete from  users where uname=#{uname}")
    public int delUser(@Param("uname")String uname);
}
=======
<<<<<<< HEAD
package com.iss.mapper;

import com.iss.po.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from users")
    public List<Users> findAllUser();

    @Insert("insert into users values (#{uname},#{upwd})")
    public int addUser(Users users);

    @Update("update users set upwd=#{upwd} where uname=#{uname}")
    public int editUser(Users users);

    @Delete("delete from  users where uname=#{uname}")
    public int delUser(@Param("uname")String uname);
}
=======
package com.iss.mapper;

import com.iss.po.Users;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {
    @Select("select * from users")
    public List<Users> findAllUser();

    @Insert("insert into users values (#{uname},#{upwd})")
    public int addUser(Users users);

    @Update("update users set upwd=#{upwd} where uname=#{uname}")
    public int editUser(Users users);

    @Delete("delete from  users where uname=#{uname}")
    public int delUser(@Param("uname")String uname);
}
>>>>>>> the initial edition
>>>>>>> the initial edition

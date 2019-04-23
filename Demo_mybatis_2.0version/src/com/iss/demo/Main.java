<<<<<<< HEAD
package com.iss.demo;

import com.iss.mapper.UserMapper;
import com.iss.po.Users;
import com.iss.util.DBUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            SqlSession sqlSession=DBUtil.getSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

            List<Users> list=userMapper.findAllUser();

            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
=======
<<<<<<< HEAD
package com.iss.demo;

import com.iss.mapper.UserMapper;
import com.iss.po.Users;
import com.iss.util.DBUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            SqlSession sqlSession=DBUtil.getSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

            List<Users> list=userMapper.findAllUser();

            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
=======
package com.iss.demo;

import com.iss.mapper.UserMapper;
import com.iss.po.Users;
import com.iss.util.DBUtil;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import java.io.InputStream;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        try {
            SqlSession sqlSession=DBUtil.getSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

            List<Users> list=userMapper.findAllUser();

            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
>>>>>>> the initial edition
>>>>>>> the initial edition

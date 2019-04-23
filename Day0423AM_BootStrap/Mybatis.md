# Mybatis（DAO）

## 1.Mybatis的前身叫ibatis

## 2.补充XML

## 3.加载jar包

## 4.添加一个mybatis的配置文件（一般在src的根目录下）

```xml
AppConfig.xml
<!DOCTYPE configuration
        PUBLIC "-//mybatis.org//DTD Config 3.0//EN"
        "http://mybatis.org/dtd/mybatis-3-config.dtd">
<configuration>

    <properties resource="Appcon.Properties"></properties>

    <typeAliases>
        <package name="com.iss.po"/>
    </typeAliases>

    <!--数据库的配置环境 -->
    <environments default="localhost">
        <environment id="localhost">
            <!--配置JDBC事务管理， 由mybatis进行管理-->
            <transactionManager type="JDBC"></transactionManager>
            <!--配置数据源，采用mytatis的连接池 -->
            <dataSource type="POOLED">
                <property name="url" value="${url}"></property>
                <property name="driver" value="${drvier}"></property>
                <property name="username" value="${username}"></property>
                <property name="password" value="${password}"></property>
            </dataSource>
        </environment>
    </environments>

    <mappers>
       <package name="com.iss.mapper"/>
    </mappers>

</configuration>



```

## 5.新建一个层mapper(dao)

### 5.1里面存放2个文件，一个是接口文件，另一个是xml文件，其中xml中存放的是映射文件，接口文件和xml文件中对应的同名方法。

### 5.2里面存放一个文件（通过注解的形式）只有一个接口文件@select，这种写法去掉了xml文件

## 6.调用SqlSessionFactory，生成SqlSession(封装为DBUtil)

```java
public class DBUtil {

    private static SqlSessionFactory sqlSessionFactory;

    static {
        try {
            String resource="AppConfig.xml";
            InputStream inputStream=Resources.getResourceAsStream(resource);
            sqlSessionFactory=new SqlSessionFactoryBuilder().build(inputStream);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static SqlSession getSession(){
        return sqlSessionFactory.openSession();
    }
}
```

## 7.进行调用

```java
try {
            SqlSession sqlSession=DBUtil.getSession();
            UserMapper userMapper=sqlSession.getMapper(UserMapper.class);

            List<Users> list=userMapper.findAllUser();

            System.out.println(list);

        } catch (Exception e) {
            e.printStackTrace();
        }
```


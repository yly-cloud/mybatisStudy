package com.yly;

import com.yly.mapper.UserMapper;
import com.yly.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;
/*
* mybatis 代理开发
* */
public class Mybatis2 {
    public static void main(String[] args) throws IOException {
//        加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        获取SqlSession对象，用它来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        执行SQL
//        List<User> users = sqlSession.selectList("test.selectAll");     //硬编码

//        获取UserMapper接口的代理对象       解决硬编码
        UserMapper userMapper = sqlSession.getMapper(UserMapper.class);
        List<User> users = userMapper.selectAll();

        System.out.println(users);

//        释放资源
        sqlSession.close();
    }
}

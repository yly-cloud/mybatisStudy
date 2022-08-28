package com.yly;

import com.yly.pojo.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class Mybatis {
    public static void main(String[] args) throws IOException {
//        加载mybatis的核心配置文件，获取SqlSessionFactory
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);

//        获取SqlSession对象，用它来执行SQL
        SqlSession sqlSession = sqlSessionFactory.openSession();

//        执行SQL
        List<User> users = sqlSession.selectList("test.selectAll");     //硬编码

        System.out.println(users);

//        释放资源
        sqlSession.close();
    }
}

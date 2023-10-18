package com.xaana.mybatisdemo;

import com.xaana.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class TestMybatis {
    @Test
    public void findAll() throws IOException {
//        1. 读取mybatis的核心配置文件（mybatis-config.xml）
        InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
//        2. 获取一个SqlSessionFactory工厂对象，工厂对象根据核心配置文件工作
        //工厂对象factory负责读取配置信息in,然后根据配置信息创建一个产品,就是封装了
        //jdbc的sqlSession对象
        SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
//        3. 通过工厂对象获取一个SqlSession对象
        //session对象是工厂根据核心配置信息生成的,所以可以直接连接数据库,
        //并且可以定位到mapper文件,可以执行sql
        //openSession不给参数,默认false,需要手动提交,true表示自动提交
        SqlSession session = factory.openSession(true);
//        4. 通过namespace+id的值定位到具体的sql，并执行sql语句
        List<Emp> list = session.selectList("EmpMapper.findAll");
//        5. 输出结果
        for (Emp emp : list){
            System.out.println(emp);
        }
    }
}

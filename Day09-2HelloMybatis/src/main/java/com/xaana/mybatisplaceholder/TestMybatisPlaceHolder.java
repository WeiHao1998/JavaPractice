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

import static org.apache.ibatis.io.Resources.getResourceAsStream;

public class TestMybatis02 {

    private static SqlSession session = null;

    static {
        try {
            InputStream in = Resources.getResourceAsStream("mybatis-config.xml");
            SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(in);
            session = factory.openSession(true);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void findAll() throws IOException {
        List<Emp> list = session.selectList("EmpMapper.findAll");
//        5. 输出结果
        for (Emp emp : list) {
            System.out.println(emp);
        }
    }

    @Test
    public void insert() {
        int rows = session.update("EmpMapper.insert");
        System.out.println("新增了" + rows + "条");
//        session.commit(); 手动提交
    }

    @Test
    public void update(){
        int rows = session.update("EmpMapper.update");
        System.out.println("新增了" + rows + "条");
    }
}

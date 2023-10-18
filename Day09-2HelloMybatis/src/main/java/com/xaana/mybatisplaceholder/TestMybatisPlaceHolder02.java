package com.xaana.mybatisplaceholder;

import com.xaana.pojo.Emp;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;
import java.util.List;

public class TestMybatisPlaceHolder {

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
//  查询指定的员工的id信息
    @Test
    public void findById(){
        int id = 6;
        Emp one = session.selectOne("EmpMapper.findById", id);
        System.out.println(one);
    }

    @Test
    public void insert(){
        String name = "Alex";
        String job = "Software Engineer";
        Double salary = 100000.0;
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("job", job);
        map.put("salary", salary);
        int rows = session.update("EmpMapper.insertEmp", map);
        System.out.println("New " + rows + " data");
    }

    @Test
    public void insert2(){
        Emp emp = new Emp();
        emp.setName("xian");
        emp.setJob("Python developer");
        emp.setSalary(20000.0);
        int rows = session.update("EmpMapper.insertEmp", emp);
        System.out.println("New " + rows + " data");
    }

    @Test
    public void update(){
        int id = 1;
        String name = "Jimmy";
        String job = "Software Engineer";
        Double salary = 100200.0;
        HashMap<Object, Object> map = new HashMap<>();
        map.put("name", name);
        map.put("job", job);
        map.put("salary", salary);
        map.put("id", id);
        int rows = session.update("EmpMapper.modifyById", map);
    }
}

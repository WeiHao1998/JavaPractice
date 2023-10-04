package com.xaana.jdbc;


import com.xaana.utils.JDBCutils;
import org.junit.Test;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author 老安
 * @data 2022/2/10 22:06
 * JDBC增删改查案例
 */
public class TestJDBC3 {
    //main方法上不能抛异常
    public static void main(String[] args) {
        //声明conn,stat,rs三个变量
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            //由JDBC标准提供的
            //1.注册数据库驱动
            Class.forName("com.mysql.jdbc.Driver");
            //2.获取数据库连接
            String url = "jdbc:mysql://localhost:3306/cgbvn2111?characterEncoding=utf-8";
            String username = "root";//用户名
            String password = "root";//密码
            conn = DriverManager.getConnection(url, username, password);
            //3.获取传输器Statement
            stat = conn.createStatement();
            //4.发送sql到服务器并执行sql,返回结果
            String sql = "select * from account";
            rs = stat.executeQuery(sql);
            //5.处理结果
            while (rs.next()) {//每循环一次,可以获取一行记录
                //获取遍历的当前行数据的id列的值,类型是int
                int id = rs.getInt("id");
                //获取遍历的当前行数据的name列的值,类型是name
                String name = rs.getString("name");
                double money = rs.getDouble("money");
                System.out.println("id:" + id + ",name:" + name + ",money:" + money);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //6.释放资源,不论什么情况,都必须要被执行的
            if (rs != null) {
                try {
                    rs.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //能走到这步的代码,说明rs一定关不了,所以手动置为null,变为游离对象,会由垃圾回收机制自动销毁
                    rs = null;
                }
            }
            if (stat != null) {
                try {
                    stat.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //能走到这步的代码,说明rs一定关不了,所以手动置为null,变为游离对象,会由垃圾回收机制自动销毁
                    stat = null;
                }
            }
            if (conn != null) {
                try {
                    conn.close();
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {
                    //能走到这步的代码,说明rs一定关不了,所以手动置为null,变为游离对象,会由垃圾回收机制自动销毁
                    conn = null;
                }
            }
        }
    }

    /*
    单元测试方法,使用Junit测试,可以直接运行一个方法中的代码,
    脱离main方法,但是这个方法需要注意以下几点:
    1.必须要在方法上加一个@Test注解
    2.方法必须要是公有的public
    3.方法必须返回值为void
    4.方法必须没有参数
     */
    @Test
    public void testAdd() {
        //新增:往account表中新增一条记录name=徐坤,money=10000
        Connection conn = null;
        Statement stat = null;
        ResultSet rs = null;
        try {
            //JDBC前五步
            conn = JDBCutils.getconnection();
            stat = conn.createStatement();
            String sql = "insert into account values(null,'徐坤',10000)";
            //executeUpdate 执行修改的sql 返回的是修改的记录数
            int rows = stat.executeUpdate(sql);
            System.out.println("修改了" + rows + "条");
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            //JDBC第六步
            JDBCutils.close(conn, stat, rs);
        }
    }
    //删除以及修改自己写 删除name=徐坤的记录 修改id=3的money=20000
}

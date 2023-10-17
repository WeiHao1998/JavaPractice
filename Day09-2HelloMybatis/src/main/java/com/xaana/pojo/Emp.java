package com.xaana.pojo;

/**
 * 和数据库的Emp表进行映射的类
 */
public class Emp {
    /*声明属性,需要和表中的字段一一映射
     * 属性名和字段名要一一对应
     * 而且必须要声明get和set方法,也要声明toString
     * 属性的类型,最好是包装类型
     *   基本类型:不属于面向对象,默认值0
     *   包装类型:属于面向对象,默认值是null,而int不能接受null
     *   一般情况下:成员变量都是用包装类型,方法中的变量是基本类型
     * */
    private Integer id;
    private String name;
    private String job;
    private Double salary;
    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                ", salary=" + salary +
                '}';
    }
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getJob() {
        return job;
    }

    public void setJob(String job) {
        this.job = job;
    }

    public Double getSalary() {
        return salary;
    }

    public void setSalary(Double salary) {
        this.salary = salary;
    }
}

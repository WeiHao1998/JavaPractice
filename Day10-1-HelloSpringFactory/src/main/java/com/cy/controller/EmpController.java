package com.cy.controller;

import com.cy.service.EmpService;
import com.cy.service.EmpServiceImpl;

//这个是controller控制层
public class EmpController {
    //从数据库查询所有的员工记录
    EmpService service = new EmpServiceImpl();
    public void findController(){
        service.findService();
        System.out.println("EmpController调用service成功");
    }

    public static void main(String[] args) {
        EmpController controller = new EmpController();
        controller.findController();
    }
}

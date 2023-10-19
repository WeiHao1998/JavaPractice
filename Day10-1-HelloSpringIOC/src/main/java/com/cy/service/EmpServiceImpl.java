package com.cy.service;

import com.cy.dao.EmpDao;
import com.cy.dao.EmpDaoImpl;

public class EmpServiceImpl implements EmpService{
    EmpDao dao = new EmpDaoImpl();
    @Override
    public void findService() {
        System.out.println("EmpService调用了dao层的方法");
        dao.findDao();
    }
}

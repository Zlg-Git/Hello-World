package com.zlg.cms.servlet.customer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跳转客户管理页面
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.cms.servlet.customer
 * @USER: 33036
 * @DATE: 2020/11/7
 */
@WebServlet("/customer/list.do")
public class CustomerListPageServlet extends HttpServlet {

    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("进入list页面跳转");
        req.getRequestDispatcher("/WEB-INF/customer/list.html").forward(req, resp);
    }
}

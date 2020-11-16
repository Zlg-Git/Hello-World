package com.zlg.cms.servlet.user;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 跳转到指定页面  重点：跳转到web-inf下的页面  必须使用请求转发、重定向的方式来进行访问
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.cms.servlet.user
 * @USER: 33036
 * @DATE: 2020/11/9
 */
@WebServlet("/user/page.do")
public class UserPageServlet extends HttpServlet {
    @Override
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String service = req.getParameter("service");
        try {
            UserPageServlet.class.getDeclaredMethod(service, HttpServletRequest.class, HttpServletResponse.class).invoke(this, req, resp);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 跳转到首页
    protected void main(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//        System.out.println("进入main跳转servlet");
        request.getRequestDispatcher("/WEB-INF/user/main.html").forward(request, response);
    }

    // 跳转业务员管理页面
    public void list(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        System.out.println("进入list跳转Servlet");
        req.getRequestDispatcher("/WEB-INF/user/list.html").forward(req, res);
    }

    // 跳转修改密码页面
    protected void updatePassword(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/user/updatePwd.html").forward(req, resp);
    }

    // 跳转到修改头像页面
    protected void updateImg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/user/updateImg.html").forward(req, resp);
    }
}

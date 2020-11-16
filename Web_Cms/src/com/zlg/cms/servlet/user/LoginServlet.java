package com.zlg.cms.servlet.user;

import com.zlg.cms.service.UserService;
import com.zlg.cms.service.impl.UserServiceImpl;
import com.zlg.cms.utils.Constant;
import com.zlg.cms.utils.JsonForServlet;
import com.zlg.cms.utils.ResultData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/userLogin.do")
public class LoginServlet extends HttpServlet {
    // 使用service层
    private UserService userService = new UserServiceImpl();

    @Override
    // 根据前端传入的请求的方法名，调用指定的方法
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用Java的反射原理完成 Servlet 请求的跳转
        //        反射:   Class 类 用来描述Java中类的特点 (类名 属性 包名 方法 父类 ...)
        // service : 前端传入的请求的方法名
        String service =req.getParameter("service");
        try {
            // 根据前端传入的请求的方法名，调用对应的方法 getDeclaredMethod:获取指定的方法，一参是方法名，之后的是参数数组 invoke：调用该方法方法
            LoginServlet.class.getDeclaredMethod(service, HttpServletRequest.class, HttpServletResponse.class).invoke(this, req, resp);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 登录
    protected void login(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("进入登录servlet");
        // 获取前端数据
        String userName = req.getParameter("userName");
        String password = req.getParameter("password");
        String checkCode = req.getParameter("checkCode");

        // 调用 Service 登录方法
        ResultData resultData = userService.login(userName,password,checkCode,req);
        // 调用 JsonForServlet 工具类, 将 Java 对象转成 json 字符串
        JsonForServlet.writeJson(resultData, resp);
    }

    // 退出登录
    protected void loginOut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("进入退出登录");
        // 销毁当前数据中的 Session
        req.getSession().invalidate();
        JsonForServlet.writeJson(ResultData.success(Constant.LOGIN_OUT_SUCCESS_MSG),resp);
    }
}

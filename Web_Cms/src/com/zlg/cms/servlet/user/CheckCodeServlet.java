package com.zlg.cms.servlet.user;

import cn.hutool.captcha.CaptchaUtil;
import cn.hutool.captcha.CircleCaptcha;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/checkCode.do")
public class CheckCodeServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 处理验证码请求
        CircleCaptcha circleCaptcha = CaptchaUtil.createCircleCaptcha(200,100,4,20);
        // 将验证码放在session域中
        req.getSession().setAttribute("checkCode",circleCaptcha.getCode());
        // 将图片当成字符流写出到页面中；
        circleCaptcha.write(resp.getOutputStream());
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        this.doGet(req,resp);
    }
}

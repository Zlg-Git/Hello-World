package com.zlg.cms.servlet.user;

import com.zlg.cms.entity.User;
import com.zlg.cms.service.UserService;
import com.zlg.cms.service.impl.UserServiceImpl;
import com.zlg.cms.utils.Constant;
import com.zlg.cms.utils.JsonForServlet;
import com.zlg.cms.utils.PageData;
import com.zlg.cms.utils.ResultData;

import javax.servlet.ServletException;
import javax.servlet.annotation.MultipartConfig;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.Part;
import java.io.File;
import java.io.IOException;

/**
 * 用来处理所有的user下所有的Servlet请求
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.cms.servlet.user
 * @USER: 33036
 * @DATE: 2020/11/9
 */
@WebServlet("/user/user.do")
@MultipartConfig // 开启文件接受
public class UserServlet extends HttpServlet {
    private UserService userService = new UserServiceImpl();

    @Override
    // 根据前端传入的请求的方法名，调用指定的方法
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用Java的反射原理完成 Servlet 请求的跳转
        //        反射:   Class 类 用来描述Java中类的特点 (类名 属性 包名 方法 父类 ...)
        // service : 前端传入的请求的方法名
        String service = req.getParameter("service");
        try {
            // 根据前端传入的请求的方法名，调用对应的方法 getDeclaredMethod:获取指定的方法，一参是方法名，之后的是参数数组 invoke：调用该方法方法
            UserServlet.class.getDeclaredMethod(service, HttpServletRequest.class, HttpServletResponse.class).invoke(this, req, resp);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 用户全查询
    protected void userList(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        System.out.println("进入用户全查servlet");
        // 获取分页的数据，使用分页工具类
        //分页后 获取页面传过来的数据有 page(当前页数) limit(每页几条数据)
        int page = Integer.parseInt(req.getParameter("page"));
        int limit = Integer.parseInt(req.getParameter("limit"));

        // 调用数据库查询方法
        PageData pageData = userService.getPageData(page,limit,req);
        // 转为 JSON 对象输出到浏览器
        JsonForServlet.writeJson(ResultData.successData(Constant.SELECT_SUCCESS_MSG,pageData), res);

    }

    // 用户添加
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建 User 对象存储表单数据
        User user = new User();
        // 获取表单数据并存放
        user.setUserName(req.getParameter("userName"));
        user.setPassword(req.getParameter("password"));
        user.setRealName(req.getParameter("realName"));
        user.setType(Integer.parseInt(req.getParameter("type")));
//        System.out.println(user.toString());

        // 调用 Service 层添加方法
        ResultData resultData = userService.userAdd(user);
        JsonForServlet.writeJson(resultData,resp);
    }

    // 用户删除
    protected void delete(HttpServletRequest req, HttpServletResponse res) throws ServletException, IOException {
//        System.out.println("进入用户删除Servlet");
        // 获取前端传入的字符串
        String data = req.getParameter("ids");
        // 将字符串转成数组
        String[] ids = data.split("&");
//        System.out.println(Arrays.toString(ids));

        // 调用 Service 层删除方法
        ResultData resultData = userService.userDelete(ids);

        JsonForServlet.writeJson(resultData, res);
    }

    // 重置密码
    protected void reset(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取表单传入的 ID
        int id = Integer.parseInt(req.getParameter("id"));

        // 调用 Service 层方法
        ResultData resultData = userService.resetPassword(id);

        JsonForServlet.writeJson(resultData, resp);
    }

    // 修改密码
    protected void updatePwd(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("进入修改密码Servlet");
        // 获取表单属性，与当前登录用户名
        String passowrd = req.getParameter("password");
        String newPassword = req.getParameter("newPassword");
        String userName = ((User)req.getSession().getAttribute("user")).getUserName();

        ResultData resultData = userService.updatePwd(passowrd, newPassword, userName);

        JsonForServlet.writeJson(resultData, resp);
    }

    // 获取头像
    protected void selectImg(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取用户名
        String userName = ((User)req.getSession().getAttribute("user")).getUserName();
        ResultData resultData = userService.selectImg(userName);
        JsonForServlet.writeJson(resultData, resp);
    }

    // 修改头像,将图片保存到本地
    protected void updateImg1(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 获取上传的头像图片
        Part userImg = req.getPart("userImg");
        // 创建文件存储路径
        File file = new File("D:/Web_Cms-Img/userImg");
        // 创建文件夹是否存在
        if (!file.exists() && !file.isDirectory()){
            // 如果不存在，或者不是一个文件夹，则创建
            file.mkdirs();
        }
        // 为了防止用户重复提交，修改图片名，用用户名命名
        // 获取用户名
        String userName = ((User)req.getSession().getAttribute("user")).getUserName();
        // 获取图片名
        String imgName = userImg.getSubmittedFileName();
        // 获取图片名后缀
        String suffix = imgName.substring(imgName.lastIndexOf("."));
        // 拼接图片名
        String nowImgName = file.getAbsolutePath() + file.separatorChar + userName + suffix;
        System.out.println(nowImgName);
        // 写入到系统中
        userImg.write(nowImgName);

        ResultData resultData = userService.updateImg(userName,nowImgName);
        JsonForServlet.writeJson(resultData,resp);
    }

    // 修改头像,将图片保存在项目路径下
    protected void updateImg(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Part part = request.getPart("userImg");  // 获取上传文件
        String user = ((User)request.getSession().getAttribute("user")).getUserName(); // 得到当前登录的用户
        String userImg = request.getServletContext().getRealPath("userImg"); //  通过应用域，获取服务器下的userImg文件的路径  项目路径/userImg

//        System.out.println(userImg);

        File file = new File(userImg);  // 如果没有保存用户头像的文件，则进行创建
        if (!file.exists() || !file.isDirectory()){
            file.mkdirs();
        }
        String submittedFileName = part.getSubmittedFileName();  // 获取上传文件名
        String suffix = submittedFileName.substring(submittedFileName.lastIndexOf(".")); // 获取上传的文件后缀
//        String imgPath = file.getAbsolutePath() + File.separator + part.getSubmittedFileName();
        String imgPath = file.getAbsolutePath() + File.separator + user + suffix;  // 拼接当前文件写入的地址，
        part.write(imgPath);
//      将图片地址保存在数据库中，与当前用户绑定
        ResultData resultData = userService.updateImg(user,"/userImg/"+user+suffix); // 使用 /userImg/文件名 进行保存  （ /  == localhost:8080/xx ）
        JsonForServlet.writeJson(resultData, response);
    }
}

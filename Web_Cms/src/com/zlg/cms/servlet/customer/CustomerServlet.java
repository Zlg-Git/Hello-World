package com.zlg.cms.servlet.customer;

import com.zlg.cms.entity.Customer;
import com.zlg.cms.service.CustomerService;
import com.zlg.cms.service.impl.CustomerServiceImpl;
import com.zlg.cms.servlet.user.UserServlet;
import com.zlg.cms.utils.Constant;
import com.zlg.cms.utils.JsonForServlet;
import com.zlg.cms.utils.PageData;
import com.zlg.cms.utils.ResultData;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * 用来处理所有的 customer 下所有的Servlet请求
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.cms.servlet.customer
 * @USER: 33036
 * @DATE: 2020/11/9
 */
@WebServlet("/customer/customer.do")
public class CustomerServlet extends HttpServlet {
    private CustomerService customerService = new CustomerServiceImpl();

    @Override
    // 根据前端传入的请求的方法名，调用指定的方法
    protected void service(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 使用Java的反射原理完成 Servlet 请求的跳转
        //        反射:   Class 类 用来描述Java中类的特点 (类名 属性 包名 方法 父类 ...)
        // service : 前端传入的请求的方法名
        String service = req.getParameter("service");
        try {
            // 根据前端传入的请求的方法名，调用对应的方法 getDeclaredMethod:获取指定的方法，一参是方法名，之后的是参数数组 invoke：调用该方法方法
            CustomerServlet.class.getDeclaredMethod(service, HttpServletRequest.class, HttpServletResponse.class).invoke(this, req, resp);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    // 客户分页查询
    protected void list(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("进入客户分页全查");
        // 使用分页工具类获取分页数据
        // 分页后 获取页面传过来的数据 page(当前页数) limit(每页几条数据)
        int page = Integer.parseInt(req.getParameter("page"));
        int limit = Integer.parseInt(req.getParameter("limit"));

        // 调用 Service层 的查询方法
        PageData pageData = customerService.getPageData(page, limit,req);

        // 调用工具类转换为 JSON 输出到浏览器
        JsonForServlet.writeJson(ResultData.successData(Constant.SELECT_SUCCESS_MSG,pageData), resp);
    }

    // 客户添加
    protected void add(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // 创建 Customer 对象存储表单数据
        Customer customer = new Customer();
        customer.setCustName(req.getParameter("custName"));
        customer.setCustCompany(req.getParameter("custCompany"));
        customer.setCustPosition(req.getParameter("custPosition"));
        customer.setCustPhone(req.getParameter("custPhone"));
        customer.setCustBirth(req.getParameter("custBirth"));
        customer.setCustSex(Integer.parseInt(req.getParameter("custSex")));
        customer.setCustDesc(req.getParameter("custDesc"));
        customer.setUserId(Integer.parseInt(req.getParameter("userId")));
//        System.out.println(customer.toString());

        //调用 Service 层方法
        ResultData resultData = customerService.customerAdd(customer);
        JsonForServlet.writeJson(resultData, resp);
    }

    // 客户删除
    protected void delete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
//        System.out.println("进入用户删除Servlet");
        // 获取前端传入的字符串
        String data = req.getParameter("ids");
        // 将字符串转换为数组
        String[] ids = data.split("&");
//        System.out.println(Arrays.toString(ids));

        // 调用 Service 层删除方法
        ResultData resultData = customerService.customerDelete(ids);

        JsonForServlet.writeJson(resultData,resp);
    }

}

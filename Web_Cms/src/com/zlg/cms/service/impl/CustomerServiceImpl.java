package com.zlg.cms.service.impl;

import cn.hutool.core.util.StrUtil;
import com.zlg.cms.dao.CustomerDao;
import com.zlg.cms.dao.impl.CustomerDaoImpl;
import com.zlg.cms.entity.Customer;
import com.zlg.cms.service.CustomerService;
import com.zlg.cms.utils.Constant;
import com.zlg.cms.utils.PageData;
import com.zlg.cms.utils.ResultData;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

/**
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.cms.service.impl
 * @USER: 33036
 * @DATE: 2020/11/7
 */
/**
 * 客户模块的业务层  基于dao层
 */
public class CustomerServiceImpl implements CustomerService {
    private CustomerDao customerDao = new CustomerDaoImpl();

    /**
     * 客户分页+条件 查询
     * @param page
     * @param limit
     * @param request
     * @return
     */
    @Override
    public PageData getPageData(int page, int limit, HttpServletRequest request) {
        // 实例化一个 PageData 存放数据
        PageData pageData = new PageData();
        // 补充数据
        pageData.setPage(page);
        pageData.setLimit(limit);

        // 获取条件查询的内容
        // 创建 Customer 对象存储获取的条件
        Customer customer = new Customer();
        // 获取条件查询的参数  如果不为 null 与 "" ，赋值
        if (!StrUtil.isEmpty(request.getParameter("custName"))){
            customer.setCustName(request.getParameter("custName"));
//            System.out.println(request.getParameter("userName"));
        }
        if (!StrUtil.isEmpty(request.getParameter("custPosition"))){
            customer.setCustPosition(request.getParameter("custPosition"));
//            System.out.println(request.getParameter("realName"));
        }
        if (!StrUtil.isEmpty(request.getParameter("custCompany"))){
            customer.setCustCompany(request.getParameter("custCompany"));
//            System.out.println(customer.setCustCompany(request.getParameter("custCompany")));
        }

        // 设置总条数 查询数据库，获取总个数
        int count = customerDao.selectAllCount(customer);
        pageData.setTotalCount(count);
        pageData.setTotalPages();// 设置总页数，工具类中已经自己配置了

        // 获取分页中的数据
        List<Customer> customers = customerDao.selectAllByLimit(pageData, customer);

        // 将数据设置到分页对象中
        pageData.setData(customers);
        return pageData;

    }

    /**
     * 客户删除方法 删除一个或多个
     * @param ids
     * @return
     */
    @Override
    public ResultData customerDelete(String[] ids) {
        int num = customerDao.deleteByIDS(ids);
        if (num != 0){
            // 删除成功
            return ResultData.success(Constant.USER_DELETE_SUCCESS_MSG);
        } else {
            // 删除失败
            return ResultData.fail(Constant.USER_DELETE_FAIL_CODE, Constant.USER_DELETE_FAIL_MSG);
        }
    }

    /**
     * 添加客户
     * @param customer
     * @return
     */
    @Override
    public ResultData customerAdd(Customer customer) {
        // 判断客户名是否存在
        Boolean flag = customerDao.selectAllCustName(customer.getCustName());
        if (!flag){ // 如果不存在则添加
            int num = customerDao.addCustomer(customer);
            if (num != 0){
                // 添加成功
                return ResultData.success(Constant.USER_INSERT_SUCCESS_MSG);
            } else {
                // 添加失败
                return ResultData.fail(Constant.USER_INSERT_FAIL_CODE,Constant.USER_INSERT_FAIL_MSG);
            }
        } else {
            // 用户名已存在
            return ResultData.fail(Constant.USER_INSERT_FAIL_CODE,Constant.USER_EXIST_FAIL_MSG);
        }
    }
}

package com.zlg.cms.dao;

import com.zlg.cms.entity.Customer;
import com.zlg.cms.utils.PageData;

import java.util.List;

/**
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.cms.dao
 * @USER: 33036
 * @DATE: 2020/11/7
 */
public interface CustomerDao {
    // 根据条件获取客户总条数
    int selectAllCount(Customer customer);
    // 使用分页 + 条件 查询获取数据
    List<Customer> selectAllByLimit(PageData pageData, Customer customer);
    // 删除一个或多个客户
    int deleteByIDS(String[] ids);
    // 判断客户名是否存在
    Boolean selectAllCustName(String custName);
    // 添加客户
    int addCustomer(Customer customer);
}

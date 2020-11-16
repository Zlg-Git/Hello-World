package com.zlg.cms.service;

import com.zlg.cms.entity.Customer;
import com.zlg.cms.utils.PageData;
import com.zlg.cms.utils.ResultData;

import javax.servlet.http.HttpServletRequest;

/**
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.cms.service
 * @USER: 33036
 * @DATE: 2020/11/7
 *
 */
public interface CustomerService {
    // 客户分页查询
    PageData getPageData(int page, int limit, HttpServletRequest req);
    // 客户删除方法
    ResultData customerDelete(String[] ids);
    // 添加客户
    ResultData customerAdd(Customer customer);
}

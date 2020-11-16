package com.zlg.cms.service;


import com.zlg.cms.entity.User;
import com.zlg.cms.utils.PageData;
import com.zlg.cms.utils.ResultData;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

public interface UserService {
    // 登录
    ResultData login(String userName, String password, String checkCode, HttpServletRequest request);
    // 分页查询
    PageData getPageData(int page, int limit, ServletRequest request);
    // 根据ID删除一个或者多个
    ResultData userDelete(String[] ids);
    // 添加
    ResultData userAdd(User user);
    // 重置密码
    ResultData resetPassword(int id);
    // 修改密码
    ResultData updatePwd(String password, String nowpassword, String userName);
    // 获取图片
    ResultData selectImg(String userName);
    // 修改图片
    ResultData updateImg(String userName, String nowImgName);
}

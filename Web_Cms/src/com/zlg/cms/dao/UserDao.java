package com.zlg.cms.dao;

import com.zlg.cms.entity.User;
import com.zlg.cms.utils.PageData;

import java.util.List;

public interface UserDao {
    // 登录
    User selectOneByNameAndPassword(String userName, String password);
    // 根据条件获取用户总条数
    int selectAllCount(User user);
    // 使用分页 + 条件查询获取数据
    List<User> selectAllByLimit(PageData pageData, User user);
    // 删除一个或多个
    int deleteByIDS(String[] ids);
    // 添加
    int addByUser(User user);
    // 重置密码
    int updatePasswordByID(int id);
    // 判断用户名是否存在
    Boolean selectByUserName(String userName);
    // 修改密码
    int updatePasswordByUserName(String userName, String nowpassword);
    // 获取头像
    String selectImgByUserName(String userName);
    // 修改头像地址
    int updateImgByUserName(String userName, String nowImgName);
}

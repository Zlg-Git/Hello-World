package com.zlg.cms.service.impl;

import javax.servlet.ServletRequest;
import javax.servlet.http.HttpServletRequest;

import cn.hutool.core.util.StrUtil;
import com.zlg.cms.dao.UserDao;
import com.zlg.cms.dao.impl.UserDaoImpl;
import com.zlg.cms.entity.User;
import com.zlg.cms.service.UserService;
import com.zlg.cms.utils.Constant;
import com.zlg.cms.utils.PageData;
import com.zlg.cms.utils.ResultData;

import java.util.List;

/**
 * 用户模块的业务层  基于dao层
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    /**
     * 登录业务逻辑
     * @param userName
     * @param password
     * @param checkCode
     * @param request
     * @return
     */
    @Override
    public ResultData login(String userName, String password, String checkCode, HttpServletRequest request) {
//        System.out.println("进入登录Service");
        // 判断验证码是否正确
        if (checkCode.equals(request.getSession().getAttribute("checkCode"))){
            // 验证码正确， 验证账号 密码
            User user = userDao.selectOneByNameAndPassword(userName, password);
//            System.out.println(user.toString());
            if (user != null){
                // 把对象放到session作用域中
                request.getSession().setAttribute("user", user);

                // 调用返回值工具类 ResultData 返回查询结果
                return ResultData.success(Constant.LOGIN_SUCCESS_MSG);
            } else {
                return ResultData.fail(Constant.LOGIN_FAIL_CODE, Constant.LOGIN_FAIL_MSG);
            }
        }else {
            return ResultData.fail(Constant.CHACK_FAIL_CODE, Constant.CHACK_FAIL_MSG);
        }
    }

    /**
     * 分页查询 + 条件查询
     * @param page
     * @param limit
     * @return
     */
    @Override
    public PageData getPageData(int page, int limit, ServletRequest request) {
        PageData pageData = new PageData();
        // 将 pageDate 补充完整
        pageData.setPage(page);// 设置当前页数
        pageData.setLimit(limit);// 设置每页条数
//        System.out.println(page+"------"+limit);

        // 获取条件查询的内容
        // 创建 User 对象存储获取的条件
        User user = new User();
        // 获取条件查询的参数  如果不为 null 与 "" ，赋值
        if (!StrUtil.isEmpty(request.getParameter("userName"))){
            user.setUserName(request.getParameter("userName"));
//            System.out.println(request.getParameter("userName"));
        }
        if (!StrUtil.isEmpty(request.getParameter("realName"))){
            user.setRealName(request.getParameter("realName"));
//            System.out.println(request.getParameter("realName"));
        }
        if (!StrUtil.isEmpty(request.getParameter("type"))){
            user.setType(Integer.parseInt(request.getParameter("type").trim()));
//            System.out.println(Integer.parseInt(request.getParameter("type").trim()));
        }

        // 设置总条数  查询数据库，获取总个数
        int count = userDao.selectAllCount(user);
        pageData.setTotalCount(count);
        pageData.setTotalPages();// 设置总页数，工具类中已经自己配置了

        // 获取分页中的数据
        List<User> users = userDao.selectAllByLimit(pageData, user);
        // 将数据设置到分页对象中
        pageData.setData(users);
        return pageData;
    }

    /**
     * 调用删除方法删除一个或多个
     * @param ids
     * @return
     */
    @Override
    public ResultData userDelete(String[] ids) {
        int num = userDao.deleteByIDS(ids);
        if (num != 0){
            // 删除成功
            return ResultData.success(Constant.USER_DELETE_SUCCESS_MSG);
        } else {
            // 删除失败
            return ResultData.fail(Constant.USER_DELETE_FAIL_CODE, Constant.USER_DELETE_FAIL_MSG);
        }
    }

    /**
     * 添加
     * @return
     * @param user
     */
    @Override
    public ResultData userAdd(User user) {
        // 判断用户名是否存在
        Boolean flag = userDao.selectByUserName(user.getUserName());
        if (!flag){ // 如果不存在则添加
            // 调用 dao 层添加方法
            int num = userDao.addByUser(user);
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

    /**
     * 重置密码为123456
     * @param id
     * @return
     */
    @Override
    public ResultData resetPassword(int id) {
        // 调用 dao 层修改密码方法
        int num = userDao.updatePasswordByID(id);
        if (num != 0){
            // 修改成功
            return ResultData.success(Constant.RESET_PASSWORD_SUCCESS_MSG);
        } else {
            // 修改失败
            return ResultData.fail(Constant.RESET_PASSWORD_FAIL_CODE, Constant.RESET_PASSWORD_FAIL_MSG);
        }
    }

    /**
     * 判断原密码是否正确,修改密码
     * @param password
     * @param newPassword
     * @param userName
     * @return
     */
    @Override
    public ResultData updatePwd(String password, String newPassword, String userName) {
//        System.out.println("进入修改密码Service");
        User user = userDao.selectOneByNameAndPassword(userName, password);
        if (user != null){
            int num = userDao.updatePasswordByUserName(userName, newPassword);
            if (num != 0){
                // 修改成功
                return ResultData.success(Constant.UPDATE_PASSWORD_SUCCESS_MSG);
            } else {
                // 修改失败
                return ResultData.fail(Constant.UPDATE_PASSWORD_FAIL_CODE, Constant.UPDATE_PASSWORD_FAIL_MSG);
            }
        } else {
            return ResultData.fail(Constant.UPDATE_PASSWORD_FAIL_CODE, Constant.UPDATE_OLDPASSWORD_FAIL_MSG);
        }
    }

    /**
     * 获取头像
     * @return
     * @param userName
     */
    @Override
    public ResultData selectImg(String userName) {
        String imgSrc = userDao.selectImgByUserName(userName);
        if (!StrUtil.isEmpty(imgSrc)){
            // 获取成功
            return ResultData.successData(Constant.UPDATE_IMG_SUCCESS_MSG, imgSrc);
        } else {
            // 获取失败
            return ResultData.fail(Constant.UPDATE_IMG_FAIL_CODE, Constant.UPDATE_IMG_FAIL_MSG);
        }
    }

    /**
     * 修改头像图片
     * @param userName
     * @param nowImgName
     * @return
     */
    @Override
    public ResultData updateImg(String userName, String nowImgName) {
        int num = userDao.updateImgByUserName(userName,nowImgName);
        if (num != 0){
            // 修改成功
            return ResultData.success(Constant.UPDATE_IMG_SUCCESS_MSG);
        } else {
            // 修改失败
            return ResultData.fail(Constant.UPDATE_IMG_FAIL_CODE, Constant.UPDATE_IMG_FAIL_MSG);
        }
    }

}

package com.zlg.cms.dao.impl;

import cn.hutool.core.util.StrUtil;
import com.zlg.cms.entity.User;
import com.zlg.cms.utils.DBUtil;
import com.zlg.cms.dao.UserDao;
import com.zlg.cms.utils.PageData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * dao层
 */
public class UserDaoImpl implements UserDao {
    ResultSet rs = null;

    /**
     * 用户登录
     * @param userName
     * @param password
     * @return
     */
    @Override
    public User selectOneByNameAndPassword(String userName, String password) {
//        System.out.println("进入登录dao层");
        String sql = "select * from c_user where user_name = ? and password =? and is_del = 1 ";
        Object [] obj = {userName , password};
        rs = DBUtil.select(sql, obj);
        User user = null;
        try {
            if (rs.next()){
                user = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }
        return user;
    }

    /**
     * 根据条件获取用户总个数
     * @return
     */
    @Override
    public int selectAllCount(User user) {
//        System.out.println("进入总数查询dao");
        // 判断是否为空 拼接条件
        String sql = "select count(id) from c_user where 1=1";

        if(!StrUtil.isEmpty(user.getUserName())){
            sql += " and user_name like '%"+ user.getUserName() +"%'";
        }
        if(!StrUtil.isEmpty(user.getRealName())){
            sql += " and real_name like '%"+ user.getRealName() +"%'";
        }
        if(user.getType() != 0){
            sql += " and type = "+ user.getType();
        }
        Object[] obj = null;
        rs = DBUtil.select(sql, obj);
        int count = 0;
        try {
            if (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }finally {
            DBUtil.close();
        }

        return count;
    }

    /**
     * 使用分页查询 + 条件查询
     * @param pageData
     * @param user
     * @return
     */
    @Override
    public List<User> selectAllByLimit(PageData pageData, User user) {
//        System.out.println("进入分页+条件查询dao");
//        System.out.println(user.toString());
        String sql = "select * from c_user where 1=1";
        if(!StrUtil.isEmpty(user.getUserName())){
            sql += " and user_name like '%"+ user.getUserName() +"%'";
        }
        if(!StrUtil.isEmpty(user.getRealName())){
            sql += " and real_name like '%"+ user.getRealName() +"%'";
        }
        if(user.getType() != 0){
            sql += " and type = "+ user.getType();
        }
        // limit 要在最后面
        sql += " limit ?,?";
        //        第一页 从 0~10  limit 0 ,10   (1-1)*10
        //        第二页 从 10,10   (2-1)*10    (3-1)*10
        // 规律为 （当前页数-1）* 每页数量
        // 判断 user 中的内容是否为空，然后进行 sql 语句拼接
        Object[] obj = {(pageData.getPage() - 1) * pageData.getLimit(), pageData.getLimit()};

        rs = DBUtil.select(sql, obj);
        List <User> userList = new ArrayList<>();
        try {
            while (rs.next()){
                User users = new User(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(4),
                        rs.getString(5),rs.getInt(6),rs.getInt(7),rs.getString(8),rs.getString(9));

                userList.add(users);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return userList;
    }

    /**
     * 删除一个或多个
     * @param ids
     * @return
     */
    @Override
    public int deleteByIDS(String[] ids) {
//        System.out.println("进入用户删除Dao");
        String sql = "delete from c_user where id in ( ?";
        for (int i = 1; i < ids.length; i++) {
            sql += ",?";
        }
        sql += ")";
        int num = DBUtil.addDelUpd(sql, ids);
        return num;
    }

    /**
     * 添加用户
     * @param user
     * @return
     */
    @Override
    public int addByUser(User user) {
//        System.out.println("进入用户添加Dao");
        String sql = "insert into `c_user`(user_name,password,real_name,type,is_del,create_time,modify_time) values(?,?,?,?,1,now(),now())";
        Object [] obj = {user.getUserName(),user.getPassword(),user.getRealName(),user.getType()};
        int num = DBUtil.addDelUpd(sql, obj);
        return num;
    }

    /**
     * 重置密码为 123456
     * @param id
     * @return
     */
    @Override
    public int updatePasswordByID(int id) {
//        System.out.println("进入重置密码Dao");
        String sql = "update c_user set password = 123456 where id = ?";
        Object [] obj = {id};
        int num = DBUtil.addDelUpd(sql, obj);
        return num;
    }

    /**
     * 判断用户名是否存在
     * @param userName
     * @return
     */
    @Override
    public Boolean selectByUserName(String userName) {
//        System.out.println("进入判断用户名dao");
        String sql = "select * from c_user where user_name = ?";
        Object[] obj = {userName};
        rs = DBUtil.select(sql, obj);
        boolean flag = false;
        try {
            flag = rs.next();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close();
        }
        return flag;
    }

    /**
     * 修改密码
     * @param userName
     * @param newPassword
     * @return
     */
    @Override
    public int updatePasswordByUserName(String userName, String newPassword) {
//        System.out.println("进入修改密码Dao");
        String sql = "update c_user set password = ? where user_name = ?";
        Object [] obj = {newPassword, userName};
        int num = DBUtil.addDelUpd(sql, obj);
        return num;
    }

    /**
     * 获取用户头像
     * @param userName
     * @return
     */
    @Override
    public String selectImgByUserName(String userName) {
//        System.out.println("进入获取头像Dao");
        String sql = "select img from c_user where user_name = ?" ;
        Object [] objects = {userName};
        ResultSet select = DBUtil.select(sql, objects);
        String img = "";
        try {
            if (select.next()){
                img = select.getString(1);
            }
        }catch (SQLException e){
            e.printStackTrace();
        }
        return img;
    }

    /**
     * 修改头像地址
     * @return
     * @param userName
     * @param nowImgName
     */
    @Override
    public int updateImgByUserName(String userName, String nowImgName) {
//        System.out.println("进入修改头像Dao");
        String sql = "update c_user set img = ? where user_name = ?";
        Object [] obj = {nowImgName, userName};
        int num = DBUtil.addDelUpd(sql, obj);
        return num;
    }

}

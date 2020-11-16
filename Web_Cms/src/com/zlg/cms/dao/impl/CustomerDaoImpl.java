package com.zlg.cms.dao.impl;

import cn.hutool.core.util.StrUtil;
import com.zlg.cms.dao.CustomerDao;
import com.zlg.cms.entity.Customer;
import com.zlg.cms.utils.DBUtil;
import com.zlg.cms.utils.PageData;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.cms.dao.impl
 * @USER: 33036
 * @DATE: 2020/11/7
 */
public class CustomerDaoImpl implements CustomerDao {
    private ResultSet rs = null;

    /**
     * 根据条件查询总个数
     * @param customer
     * @return
     */
    @Override
    public int selectAllCount(Customer customer) {
//        System.out.println("进入总数查询dao");
        // 判断是否为空 拼接条件
        String sql = "select count(id) from c_customer where 1=1";
        if (!StrUtil.isEmpty(customer.getCustName())){
            sql += " and cust_name like '%"+ customer.getCustName() +"%'";
        }
        if (!StrUtil.isEmpty(customer.getCustPosition())){
            sql += " and cust_position like '%"+ customer.getCustPosition() +"%'";
        }
        if (!StrUtil.isEmpty(customer.getCustCompany())){
            sql += " and cust_company like '%"+ customer.getCustCompany() +"%'";
        }

        Object[] obj = null;
        rs = DBUtil.select(sql, obj);
        int count = 0;
        try {
            if (rs.next()){
                count = rs.getInt(1);
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            DBUtil.close();
        }

        return count;
    }

    /**
     * 使用分页 + 条件查询获取数据
     * @param pageData
     * @param customer
     * @return
     */
    @Override
    public List<Customer> selectAllByLimit(PageData pageData, Customer customer) {
//        System.out.println("进入分页+条件查询dao");
//        System.out.println(customer.toString());
        // 判断是否为空 拼接条件
        String sql = "select * from c_customer where 1=1";
        if (!StrUtil.isEmpty(customer.getCustName())){
            sql += " and cust_name like '%"+ customer.getCustName() +"%'";
        }
        if (!StrUtil.isEmpty(customer.getCustPosition())){
            sql += " and cust_position like '%"+ customer.getCustPosition() +"%'";
        }
        if (!StrUtil.isEmpty(customer.getCustCompany())){
            sql += " and cust_company like '%"+ customer.getCustCompany() +"%'";
        }
        sql += " limit ?,?";
        //        第一页 从 0~10  limit 0 ,10   (1-1)*10
        //        第二页 从 10,10   (2-1)*10    (3-1)*10
        // 第一条规律为从 （（当前页数-1）* 每页数量） 开始
        // 判断 user 中的内容是否为空，然后进行 sql 语句拼接
        Object[] obj = {(pageData.getPage() - 1) * pageData.getLimit(), pageData.getLimit()};

        rs = DBUtil.select(sql, obj);
        List<Customer> customers = new ArrayList<>();
        try {
            while (rs.next()){
                Customer customer1 = new Customer(rs.getInt(1),rs.getString(2),rs.getString(3),
                        rs.getString(4),rs.getString(5),rs.getString(6),rs.getInt(7),
                        rs.getString(8),rs.getInt(9),rs.getString(10),rs.getString(11));

                customers.add(customer1);
            }
        } catch (Exception e){
            e.printStackTrace();
        } finally {
            DBUtil.close();
        }

        return customers;
    }

    /**
     * 根据 ID数组 删除一个或多个用户
     * @param ids
     * @return
     */
    @Override
    public int deleteByIDS(String[] ids) {
//        System.out.println("进入客户删除Dao");
        String sql = "delete from c_customer where id in ( ?";
        for (int i = 1; i < ids.length; i++) {
            sql += ",?";
        }
        sql += ")";
        int num = DBUtil.addDelUpd(sql, ids);

        return num;
    }

    /**
     * 判断客户名是否存在
     * @param custName
     * @return
     */
    @Override
    public Boolean selectAllCustName(String custName) {
//        System.out.println("进入判断用户名dao");
        String sql = "select * from c_customer where cust_name = ?";
        Object[] obj = {custName};
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
     * 添加客户
     * @param c
     * @return
     */
    @Override
    public int addCustomer(Customer c) {
//        System.out.println("进入用户添加Dao");
        String sql = "insert into `c_customer` values(0,?,?,?,?,?,?,?,?,now(),now())";
        Object [] obj = {c.getCustName(),c.getCustCompany(),c.getCustPosition(),c.getCustPhone(),c.getCustBirth(),
                        c.getCustSex(),c.getCustDesc(),c.getUserId()};
        int num = DBUtil.addDelUpd(sql, obj);
        return num;
    }
}

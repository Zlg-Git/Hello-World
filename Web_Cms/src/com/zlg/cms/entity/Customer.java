package com.zlg.cms.entity;

/**
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.entity
 * @USER: 33036
 * @DATE: 2020/11/3
 * 客户实体类
 */
public class Customer {
    private int id; //'客户id',
    private String custName; //'客户名称',
    private String custCompany; //'客户所属公司',
    private String custPosition; //'客户职位',
    private String custPhone; //'客户手机号',
    private String custBirth; //'客户生日 yyyy-MM-dd',
    private int custSex; //'客户性别',
    private String custDesc; //'客户介绍',
    private int userId; //'业务员ID',
    private String createTime; //'创建时间 yyyy-MM-dd HH:mm:ss',
    private String modifyTime; //'修改时间 yyyy-MM-dd HH:mm:ss',

    public Customer() {
    }

    public Customer(int id, String custName, String custCompany, String custPosition, String custPhone, String custBirth, int custSex, String custDesc, int userId, String createTime, String modifyTime) {
        this.id = id;
        this.custName = custName;
        this.custCompany = custCompany;
        this.custPosition = custPosition;
        this.custPhone = custPhone;
        this.custBirth = custBirth;
        this.custSex = custSex;
        this.custDesc = custDesc;
        this.userId = userId;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getCustName() {
        return custName;
    }

    public void setCustName(String custName) {
        this.custName = custName;
    }

    public String getCustCompany() {
        return custCompany;
    }

    public void setCustCompany(String custCompany) {
        this.custCompany = custCompany;
    }

    public String getCustPosition() {
        return custPosition;
    }

    public void setCustPosition(String custPosition) {
        this.custPosition = custPosition;
    }

    public String getCustPhone() {
        return custPhone;
    }

    public void setCustPhone(String custPhone) {
        this.custPhone = custPhone;
    }

    public String getCustBirth() {
        return custBirth;
    }

    public void setCustBirth(String custBirth) {
        this.custBirth = custBirth;
    }

    public int getCustSex() {
        return custSex;
    }

    public void setCustSex(int custSex) {
        this.custSex = custSex;
    }

    public String getCustDesc() {
        return custDesc;
    }

    public void setCustDesc(String custDesc) {
        this.custDesc = custDesc;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    public String getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(String modifyTime) {
        this.modifyTime = modifyTime;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "id=" + id +
                ", custName='" + custName + '\'' +
                ", custCompany='" + custCompany + '\'' +
                ", custPosition='" + custPosition + '\'' +
                ", custPhone='" + custPhone + '\'' +
                ", custBirth='" + custBirth + '\'' +
                ", custSex=" + custSex +
                ", custDesc='" + custDesc + '\'' +
                ", userId=" + userId +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}

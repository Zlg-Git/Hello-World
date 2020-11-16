package com.zlg.cms.entity;

/**
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.entity
 * @USER: 33036
 * @DATE: 2020/11/3
 * 业务员实体类
 */
public class User {
    private int id; //'用户ID',
    private String userName; //'用户名',
    private String password; //'用户密码',
    private String realName; //'真实名称',
    private String img; //'用户图像',
    private int type; //'用户类型  1 管理员   2 业务员',
    private int isDel; //'是否有效  1 有效   2 无效',
    private String createTime; //'创建时间',
    private String modifyTime; //'修改时间',

    public User() {
    }

    public User(int id, String userName, String password, String realName, String img, int type, int isDel, String createTime, String modifyTime) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.realName = realName;
        this.img = img;
        this.type = type;
        this.isDel = isDel;
        this.createTime = createTime;
        this.modifyTime = modifyTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getImg() {
        return img;
    }

    public void setImg(String img) {
        this.img = img;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getIsDel() {
        return isDel;
    }

    public void setIsDel(int isDel) {
        this.isDel = isDel;
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
        return "User{" +
                "id=" + id +
                ", userName='" + userName + '\'' +
                ", password='" + password + '\'' +
                ", realName='" + realName + '\'' +
                ", img='" + img + '\'' +
                ", type=" + type +
                ", isDel=" + isDel +
                ", createTime='" + createTime + '\'' +
                ", modifyTime='" + modifyTime + '\'' +
                '}';
    }
}

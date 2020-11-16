package com.zlg.cms.entity;

/**
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.entity
 * @USER: 33036
 * @DATE: 2020/11/3
 * 拜访实体类
 */
public class Visit {
    private int id; //'拜访ID',
    private int userId; //'业务员ID',
    private int custId; //'客户ID',
    private String visitDesc; //'拜访描述',
    private String visitTime; //'拜访时间',
    private String createTime; //'创建时间',

    public Visit() {
    }

    public Visit(int id, int userId, int custId, String visitDesc, String visitTime, String createTime) {
        this.id = id;
        this.userId = userId;
        this.custId = custId;
        this.visitDesc = visitDesc;
        this.visitTime = visitTime;
        this.createTime = createTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getCustId() {
        return custId;
    }

    public void setCustId(int custId) {
        this.custId = custId;
    }

    public String getVisitDesc() {
        return visitDesc;
    }

    public void setVisitDesc(String visitDesc) {
        this.visitDesc = visitDesc;
    }

    public String getVisitTime() {
        return visitTime;
    }

    public void setVisitTime(String visitTime) {
        this.visitTime = visitTime;
    }

    public String getCreateTime() {
        return createTime;
    }

    public void setCreateTime(String createTime) {
        this.createTime = createTime;
    }

    @Override
    public String toString() {
        return "Visit{" +
                "id=" + id +
                ", userId=" + userId +
                ", custId=" + custId +
                ", visitDesc='" + visitDesc + '\'' +
                ", visitTime='" + visitTime + '\'' +
                ", createTime='" + createTime + '\'' +
                '}';
    }
}

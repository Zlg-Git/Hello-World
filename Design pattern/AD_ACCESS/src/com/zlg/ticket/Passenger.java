package com.zlg.ticket;

/**
 * @PROJECT_NAME: AD_ACCESS
 * @PACKAGE_NAME: com.zlg.ticket
 * @USER: 33036
 * @DATE: 2020/10/13
 * 乘客类
 */
public class Passenger {
    private Integer  pid;//乘客编号
    private Train_Ticket train_ticket;//火车票

    //买票
    public void buyTickets (Train_Ticket train_ticket){

    }

    public Passenger(Integer pid) {
        this.pid = pid;
    }

    public Passenger(Integer pid, Train_Ticket train_ticket) {
        this.pid = pid;
        this.train_ticket = train_ticket;
    }

    public Integer getPid() {
        return pid;
    }

    public void setPid(Integer pid) {
        this.pid = pid;
    }

    public Train_Ticket getTrain_ticket() {
        return train_ticket;
    }

    public void setTrain_ticket(Train_Ticket train_ticket) {
        this.train_ticket = train_ticket;
    }
}

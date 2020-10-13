package com.zlg.ticket;

/**
 * @PROJECT_NAME: AD_ACCESS
 * @PACKAGE_NAME: com.zlg
 * @USER: 33036
 * @DATE: 2020/10/13
 * 火车票类
 */
public class Train_Ticket {
    private Integer tid;//车票编号
    private String trainNumber;//车次
    private Integer numberOfTrainTickets;//车票列数
    private Integer numberOfSeats;//座位数
    private String boardingTime;//上车时间

    public Train_Ticket() {
    }

    public Train_Ticket(Integer tid, String trainNumber, Integer numberOfTrainTickets, Integer numberOfSeats, String boardingTime) {
        this.tid = tid;
        this.trainNumber = trainNumber;
        this.numberOfTrainTickets = numberOfTrainTickets;
        this.numberOfSeats = numberOfSeats;
        this.boardingTime = boardingTime;
    }

    public Integer getTid() {
        return tid;
    }

    public void setTid(Integer tid) {
        this.tid = tid;
    }

    public String getTrainNumber() {
        return trainNumber;
    }

    public void setTrainNumber(String trainNumber) {
        this.trainNumber = trainNumber;
    }

    public Integer getNumberOfTrainTickets() {
        return numberOfTrainTickets;
    }

    public void setNumberOfTrainTickets(Integer numberOfTrainTickets) {
        this.numberOfTrainTickets = numberOfTrainTickets;
    }

    public Integer getNumberOfSeats() {
        return numberOfSeats;
    }

    public void setNumberOfSeats(Integer numberOfSeats) {
        this.numberOfSeats = numberOfSeats;
    }

    public String getBoardingTime() {
        return boardingTime;
    }

    public void setBoardingTime(String boardingTime) {
        this.boardingTime = boardingTime;
    }

    @Override
    public String toString() {
        return "Train_Ticket{" +
                "tid=" + tid +
                ", trainNumber='" + trainNumber + '\'' +
                ", numberOfTrainTickets=" + numberOfTrainTickets +
                ", numberOfSeats=" + numberOfSeats +
                ", boardingTime='" + boardingTime + '\'' +
                '}';
    }
}

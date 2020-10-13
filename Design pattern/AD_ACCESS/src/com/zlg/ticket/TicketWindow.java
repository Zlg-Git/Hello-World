package com.zlg.ticket;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @PROJECT_NAME: AD_ACCESS
 * @PACKAGE_NAME: com.zlg.ticket
 * @USER: 33036
 * @DATE: 2020/10/13
 * 购票窗口类
 */
public class TicketWindow implements Runnable {
    private static String trainNumber = "K21";//车次
    private static Integer numberOfTrainTickets = 3;//车票列数
    private static Integer numberOfSeats = 10;//座位数
    private static volatile Integer numberOfTickets = numberOfTrainTickets * numberOfSeats;//车票数
    private static List<Train_Ticket> train = Collections.synchronizedList(new ArrayList<>(240));

    //卖票方法
    public static void sell_​​tickets(){
        int a = 0;
        for (int i = 1; i <= numberOfTrainTickets ;i++){
            for (int j = 1; j <= numberOfSeats; j++) {
                Train_Ticket train_ticket = new Train_Ticket(++a, trainNumber, i, j,
                        new SimpleDateFormat("YYYY-MM-DD  HH:mm:ss").format(new Date()));

                train.add(train_ticket);
            }
        }
    }

    @Override
    public void run() {
        //runFor();
        runWhile();
    }

    private static volatile int count = numberOfTickets;

    //for循环
    //i，count,numberOfTickets需要为静态变量且添加volatile关键字，使变量在值发生改变时尽快地让其他线程知道
    private static volatile int i = 0;
    private void runFor(){
        sell_​​tickets();
        //for循环 需要使用volatile关键字使i，count与同步代码块一起执行
        for (i = 1; i < count; i++) {
            //使线程睡眠10ms，让其他线程优先执行
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (TicketWindow.class){
                Passenger passenger = new Passenger(i);
                passenger.buyTickets(train.get(i-1));
                System.out.println(Thread.currentThread().getName() + " 卖了一张 " + train.get(i-1).getTrainNumber() +
                        " 车次的票,购票时间为 " + train.get(i-1).getBoardingTime() + " 还剩余 " + --numberOfTickets + " 张");
            }
        }
    }

    //while循环
    //count,numberOfTickets需要为静态变量且添加volatile关键字，使变量在值发生改变时尽快地让其他线程知道
    private void runWhile(){
        sell_​​tickets();
        while (true){
            try {
                Thread.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            synchronized (TicketWindow.class){
                if (numberOfTickets >0){
                    int id = count - numberOfTickets +1;
                    Passenger passenger = new Passenger(id);
                    passenger.buyTickets(train.get(id-1));
                    System.out.println(Thread.currentThread().getName() + " 卖了一张 " + train.get(id-1).getTrainNumber() +
                            " 车次的票,购票时间为 " + train.get(id-1).getBoardingTime() + " 还剩余 " + --numberOfTickets + " 张");
                } else {
                    break;
                }
            }
        }
    }
}

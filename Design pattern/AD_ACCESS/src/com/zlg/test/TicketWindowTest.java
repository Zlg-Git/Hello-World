package com.zlg.test;

import com.zlg.ticket.TicketWindow;

/**
 * @PROJECT_NAME: AD_ACCESS
 * @PACKAGE_NAME: com.zlg.test
 * @USER: 33036
 * @DATE: 2020/10/13
 */
public class TicketWindowTest {
    public static void main(String[] args) {
        Thread thread1 = new Thread(new TicketWindow(), "窗口1");
        Thread thread2 = new Thread(new TicketWindow(), "窗口2");

        thread1.start();
        thread2.start();


    }
}

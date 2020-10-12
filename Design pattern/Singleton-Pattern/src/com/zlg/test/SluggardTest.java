package com.zlg.test;

import com.zlg.sluggard.Sluggard;

/**
 * @PROJECT_NAME: Singleton-Pattern
 * @PACKAGE_NAME: com.zlg.test
 * @USER: 33036
 * @DATE: 2020/10/12
 *
 */
public class SluggardTest {
    public static void main(String[] args) {
        //非单例模式：每次调用都会创建一个新的对象
        /*Sluggard sluggard1 = new Sluggard();
        Sluggard sluggard2 = new Sluggard();
        if (Sluggard1 != Sluggard2){
            System.out.println("非单例模式");
        }*/
        //单例模式
        Sluggard sluggard = Sluggard.getSluggard();
        Sluggard sluggard1 = Sluggard.getSluggard();
        if (sluggard == sluggard1){
            System.out.println("单例模式");
        }
    }
}

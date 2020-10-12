package com.zlg.hungryman;

/**
 * @PROJECT_NAME: Singleton-Pattern
 * @PACKAGE_NAME: com.zlg.sluggard
 * @USER: 33036
 * @DATE: 2020/10/12
 * 单例模式很简单，就是在构造函数中多了加一个构造函数，访问权限是private 的就可以了，这个模式是简单
 * 单例模式之饿汉式：不用担心线程安全问题，但是不管是否调用都会创建实例化对象，容易资源浪费
 */
public class HungryMan {
    private static HungryMan HUNGRYMAN = new HungryMan();

    private HungryMan(){}

    public static HungryMan getSluggard(){
        return HUNGRYMAN;
    }
}

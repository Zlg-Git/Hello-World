package com.zlg.sluggard;

/**
 * @PROJECT_NAME: Singleton-Pattern
 * @PACKAGE_NAME: com.zlg.sluggard
 * @USER: 33036
 * @DATE: 2020/10/12
 * 单例模式很简单，就是在构造函数中多了加一个构造函数，访问权限是private 的就可以了，这个模式是简单
 * 单例模式之懒汉式：存在线程安全问题，延迟加载，不存在资源浪费
 */
public class Sluggard {
    private static volatile Sluggard SLOGGARD;

    private Sluggard(){}

    public static Sluggard getSluggard(){
        if (SLOGGARD == null){//Double-checked lock     双重检查锁
            synchronized (Sluggard.class){//synchronized    同步代码块
                if (SLOGGARD == null) {
                    SLOGGARD = new Sluggard();
                }
            }
        }
        return SLOGGARD;
    }
}

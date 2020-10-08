package com.zlg.factory;

/**
 * @PROJECT_NAME: Factory
 * @PACKAGE_NAME: com.zlg.factory
 * @USER: 33036
 * @DATE: 2020/10/8
 */
public abstract class Phone {
    private String name;//手机型号
    private float price;//价格

    public abstract void model(String condition);
}

package com.zlg.factory;

/**
 * @PROJECT_NAME: Factory
 * @PACKAGE_NAME: com.zlg.factory
 * @USER: 33036
 * @DATE: 2020/10/8
 */
public abstract class Car {
    private String name;
    private float price;

    public abstract void model(String claim);
}

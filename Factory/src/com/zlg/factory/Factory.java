package com.zlg.factory;

/**
 * @PROJECT_NAME: Factory
 * @PACKAGE_NAME: com.zlg.factory
 * @USER: 33036
 * @DATE: 2020/10/8
 *
 * 工厂类
 */
public abstract class Factory<T> {

    public abstract T newInstance(String cls);
}

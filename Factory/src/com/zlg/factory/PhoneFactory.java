package com.zlg.factory;

/**
 * @PROJECT_NAME: Factory
 * @PACKAGE_NAME: com.zlg.factory
 * @USER: 33036
 * @DATE: 2020/10/8
 * 手机工厂类
 */
public class PhoneFactory extends Factory<Phone> {
    @Override
    public Phone newInstance(String cls) {
        Phone phone = null;
        try {
            Class<?> aClass = Class.forName(cls);
            phone = (Phone) aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return phone;
    }
}

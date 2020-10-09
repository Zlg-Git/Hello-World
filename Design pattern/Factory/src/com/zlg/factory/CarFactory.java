package com.zlg.factory;

/**
 * @PROJECT_NAME: Factory
 * @PACKAGE_NAME: com.zlg.factory
 * @USER: 33036
 * @DATE: 2020/10/8
 */
public class CarFactory extends Factory<Car> {
    @Override
    public Car newInstance(String cls) {
        Car car = null;
        try {
            Class<?> aClass = Class.forName(cls);
            car = (Car) aClass.newInstance();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return car;
    }
}

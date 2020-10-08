package com.zlg.test;

import com.zlg.factory.Car;
import com.zlg.factory.CarFactory;
import com.zlg.factory.Phone;
import com.zlg.factory.PhoneFactory;

/**
 * @PROJECT_NAME: Factory
 * @PACKAGE_NAME: com.zlg.test
 * @USER: 33036
 * @DATE: 2020/10/8
 */
public class FactoryTest {
    public static void main(String[] args) {
        //创建一个手机工厂
        PhoneFactory phoneFactory = new PhoneFactory();
        //调用手机工厂的创建对象方法
        Phone phone = phoneFactory.newInstance("com.zlg.factory.HuaWei");
        phone.model("国产");

        Phone phones = phoneFactory.newInstance("com.zlg.factory.XiaoMi");
        phones.model("发烧");

        //创建一个汽车工厂
        CarFactory CarFactory = new CarFactory();
        //调用汽车工厂的创建对象方法
        Car car = CarFactory.newInstance("com.zlg.factory.BMW");
        car.model("国产");

        Car cars = CarFactory.newInstance("com.zlg.factory.Porsche");
        cars.model("发烧");

    }
}

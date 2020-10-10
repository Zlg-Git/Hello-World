package com.zlg.test;

import com.zlg.takeaway.MeiTuan;
import com.zlg.takeaway.PastaTakeaway;
import com.zlg.takeaway.RiceTakeaway;

/**
 * @PROJECT_NAME: Take-Out
 * @PACKAGE_NAME: com.zlg.test
 * @USER: 33036
 * @DATE: 2020/10/10
 */
public class Test {
    public static void main(String[] args) {
        RiceTakeaway fastFood = new RiceTakeaway();
        PastaTakeaway friedNoodles = new PastaTakeaway();
        //MeiTuan meiTuan = new MeiTuan(fastFood);
        MeiTuan meiTuan = new MeiTuan(friedNoodles);

        meiTuan.dishName();
        meiTuan.address();


    }
}

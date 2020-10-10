package com.zlg.takeaway;

/**
 * @PROJECT_NAME: Take-Out
 * @PACKAGE_NAME: com.zlg.takeaway
 * @USER: 33036
 * @DATE: 2020/10/10
 */
public class PastaTakeaway implements Takeaway {

    @Override
    public void dishName() {
        System.out.println("面食外卖");
    }

    @Override
    public void address() {
        System.out.println("桃园二319");
    }
}

package com.zlg.takeaway;

/**
 * @PROJECT_NAME: Take-Out
 * @PACKAGE_NAME: com.zlg.takeaway
 * @USER: 33036
 * @DATE: 2020/10/10
 */
public class MeiTuan implements Takeaway {
    private Takeaway takeaway;
    public MeiTuan(Takeaway takeaway){
        this.takeaway = takeaway;
    }

    @Override
    public void dishName() {
        takeaway.dishName();
    }

    @Override
    public void address() {
        takeaway.address();
    }
}

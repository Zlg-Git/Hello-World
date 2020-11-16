package com.zlg.cms.utils;


/**
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.utils
 * @USER: 33036
 * @DATE: 2020/11/4
 * 返回结果集数据
 */
public class ResultData {
    private int code; // 返回结果集状态码
    private String msg; // 结果集的说明信息
    private Object data; // 返回的数据

    // 设置状态码信息数据
    public ResultData(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }
    // 设置成功信息，不返回数据
    public static ResultData success(String msg){
        return new ResultData(Constant.LOGIN_SUCCESS_CODE, msg, null);
    }
    // 设置成功信息，返回数据
    public static ResultData successData(String msg, Object data){
        return new ResultData(Constant.LOGIN_SUCCESS_CODE, msg, data);
    }
    // 设置失败信息
    public static ResultData fail(int code, String msg){
        return new ResultData(code, msg, null);
    }

    @Override
    public String toString() {
        return "ResultData{" +
                "code=" + code +
                ", msg='" + msg + '\'' +
                ", data=" + data +
                '}';
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}

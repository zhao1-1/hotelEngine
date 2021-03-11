package com.ruyuan.little.project.rocketmq.api.order.enums;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:订单系统业务code码
 **/
public enum OrderBusinessErrorCodeEnum {

    /**
     * 创建订单失败
     */
    CREATE_ORDER_FAIL(581, "创建订单失败"),

    /**
     * 创建订单商品失败
     */
    CREATE_ORDER_ITEM_FAIL(582, "创建订单商品失败"),

    /**
     * 订单不存在
     */
    ORDER_NO_EXIST(583, "订单不存在"),
    ;

    private int code;

    private String msg;

    OrderBusinessErrorCodeEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
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
}
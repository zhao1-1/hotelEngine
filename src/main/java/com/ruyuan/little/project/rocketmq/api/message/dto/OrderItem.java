package com.ruyuan.little.project.rocketmq.api.message.dto;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:订单商品条目
 **/
public class OrderItem {

    /**
     * 房间名称
     */
    private String title;

    /**
     * 订购数量
     */
    private Integer total;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }
}
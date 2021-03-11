package com.ruyuan.little.project.rocketmq.api.order.dto;

import java.math.BigDecimal;

/**
 * @author <a href="mailto:little@163.com">little</a>
 * version: 1.0
 * Description:订单商品信息
 **/
public class OrderItemDTO {

    /**
     * thumb,
     * beid,
     * orderid,
     * goodsId,
     * title,
     * price,
     * total,
     * order_dates,
     * description
     */
    /**
     * 房间图片地址
     */
    private String thumb;

    /**
     * 小程序店铺id
     */
    private Integer beid;

    /**
     * 订单id
     */
    private Integer orderId;

    /**
     * 房间id
     */
    private Integer roomId;

    /**
     * 房间名称
     */
    private String title;

    /**
     * 订购数量
     */
    private Integer total;

    /**
     * 预定天数
     */
    private String orderDates;

    /**
     * 房间的描述信息
     */
    private String description;

    /**
     * 房间价格
     */
    private BigDecimal price;

    public String getThumb() {
        return thumb;
    }

    public void setThumb(String thumb) {
        this.thumb = thumb;
    }

    public Integer getBeid() {
        return beid;
    }

    public void setBeid(Integer beid) {
        this.beid = beid;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getRoomId() {
        return roomId;
    }

    public void setRoomId(Integer roomId) {
        this.roomId = roomId;
    }

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

    public String getOrderDates() {
        return orderDates;
    }

    public void setOrderDates(String orderDates) {
        this.orderDates = orderDates;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }
}
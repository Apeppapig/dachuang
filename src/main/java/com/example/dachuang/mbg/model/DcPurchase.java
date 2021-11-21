package com.example.dachuang.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class DcPurchase implements Serializable {
    private Long id;

    @ApiModelProperty(value = "购买的礼物id")
    private Byte giftId;

    @ApiModelProperty(value = "所属购买订单")
    private Integer orderId;

    @ApiModelProperty(value = "购买数量")
    private Integer num;

    private static final long serialVersionUID = 1L;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Byte getGiftId() {
        return giftId;
    }

    public void setGiftId(Byte giftId) {
        this.giftId = giftId;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", giftId=").append(giftId);
        sb.append(", orderId=").append(orderId);
        sb.append(", num=").append(num);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
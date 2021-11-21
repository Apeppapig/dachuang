package com.example.dachuang.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class DcPayment implements Serializable {
    private Byte id;

    @ApiModelProperty(value = "支付方式: 0->微信 1->支付宝")
    private Byte method;

    private static final long serialVersionUID = 1L;

    public Byte getId() {
        return id;
    }

    public void setId(Byte id) {
        this.id = id;
    }

    public Byte getMethod() {
        return method;
    }

    public void setMethod(Byte method) {
        this.method = method;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", method=").append(method);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
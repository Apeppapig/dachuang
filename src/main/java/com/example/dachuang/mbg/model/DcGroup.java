package com.example.dachuang.mbg.model;

import io.swagger.annotations.ApiModelProperty;
import java.io.Serializable;

public class DcGroup implements Serializable {
    private Integer id;

    @ApiModelProperty(value = "小组所属直播间")
    private Integer classroomId;

    @ApiModelProperty(value = "小组在直播间的序号")
    private Byte orderNum;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getClassroomId() {
        return classroomId;
    }

    public void setClassroomId(Integer classroomId) {
        this.classroomId = classroomId;
    }

    public Byte getOrderNum() {
        return orderNum;
    }

    public void setOrderNum(Byte orderNum) {
        this.orderNum = orderNum;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", classroomId=").append(classroomId);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}
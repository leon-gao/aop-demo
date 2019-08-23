package com.gaolong.working.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

@Data
public class ConferenceEmployeeVO implements Serializable {

    @ApiModelProperty(value = "员工ID")
    private Integer userId;

    @ApiModelProperty(value = "员工姓名")
    private String name;

    @ApiModelProperty(value = "主部门ID")
    private Integer departmentId;

    @ApiModelProperty(value = "主部门姓名")
    private String departmentName;

    @ApiModelProperty(value = "员工工号")
    private String workNum;

    @ApiModelProperty(value = "头像url")
    private String headPic;

    @ApiModelProperty(value = "用户dingId")
    private String dingId;
}

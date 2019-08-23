package com.gaolong.working.vo;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * @Author zl
 * @Date 2019-03-05
 * @Des ${todo}
 */

@Data
public class ReserveConferenceInfoVO implements Serializable {


    @ApiModelProperty(value = "预定的会议室Id")
    private Long conferenceId; // 预定的会议室Id

    @ApiModelProperty(value = "会议室信息 西子科技园-1号楼")
    private String conferenceRoom;

    @ApiModelProperty(value = "会议开始时间")
    private String conferenceStartTime; // 会议开始时间

    @ApiModelProperty(value = "会议结束时间")
    private String conferenceEndTime; // 会议结束时间

    @ApiModelProperty(value = "会议标题")
    private String conferenceTitle; // 会议标题

    @ApiModelProperty(value = "会议时长 1小时30分钟")
    private String conferenceDuration;// 会议时长

    @ApiModelProperty(value = "发起人Id")
    private Integer conferenceOriginator; // 发起人Id

    @ApiModelProperty(value = "发起人姓名")
    private String conferenceOriginatorName; // 发起人姓名

    @ApiModelProperty(value = "发起人主部门id")
    private Integer originatorDepartment; // 发起人主部门id

    @ApiModelProperty(value = "发起人主部门名称")
    private String originatorDepartmentName; // 发起人主部门名称

    @ApiModelProperty(value = " 0 未签到 1 已经签到")
    private Short conferenceSignIn; // 0 未签到 1 已经签到

    @ApiModelProperty(value = "0:待审批,1:预订成功,2:会议审批拒绝,3:会议提前结束 4:会议结束 5:取消会议 6: 无人签到自动释放 同时更新结束时间")
    private Short conferenceStatus; // 0:待审批,1:预订成功,2:会议审批拒绝,3:会议提前结

    @ApiModelProperty(value = "拒绝状态拒绝意见")
    private String approveReason;

    @ApiModelProperty(value = "参与人员信息")
    private List<ConferenceEmployeeVO> conferenceEmployeeVOS; // 参与会议人员信息

    @ApiModelProperty(value = "审批人Id")
    private  Integer approverId;

    @ApiModelProperty(value = "审批人姓名")
    private String approverName;

    @ApiModelProperty(value = "审批人头像")
    private String imageUrl;

    @ApiModelProperty(value = "审批人工号")
    private String workNum;

    @ApiModelProperty(value = "参与人员数后台自动设置")
    private Integer conferenceNumber; // 参与会议人数

    @ApiModelProperty(value = "会议内容")
    private String conferenceContent;

    @ApiModelProperty(value = "日期 2019-03-15")
    private String reserveTime;

    @ApiModelProperty(value = "会议室的容量")
    private Integer capacity;


}

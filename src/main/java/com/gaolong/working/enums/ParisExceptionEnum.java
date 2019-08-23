package com.gaolong.working.enums;

/**
 * @Author zl
 * @Date 2019-02-28
 * @Des ${todo}
 */
public enum ParisExceptionEnum {

    SUCCESS(0, "成功"),

    CONFEREECENAME_PARAM_ERROR(111111,"缺少必要参数"),

    DEFAULT_ERROR(9999999, "未知异常"),

    /*********************** 会议室相关异常 100XXX ***************/

    CONFEREECENAME_LENGTH_ERROR(100001,"会议室名称最多20字"),

    CONFEREECENAME_EXITS_ERROR(100002,"会议名称已经存在"),

    CONFEREECENAME_UNEXITS_ERROR(100003,"连接码对应会议室不存在"),

    CONFEREECENAME_DISENABLE_ERROR(100004,"该会议室已被禁用"),

    CONFEREECENAME_CHECKPASSWORD_ERROR(100005,"校验密码失败"),



    /*********************** 预定会议室相关异常 200XXX ***************/
    RESERVE_RULE_UNEXIXT_ERROR(200001,"预定规则配置信息为空！请联系管理员"),

    RESERVE_RULE_TIME_ERROR(200002,"预定时间超出规则时间"),

    RESERVE_RULE_DAYS_ERROR(200003,"提前预定时间超出规定天数"),

    RESERVE_RULE_ROOM_ERROR(200004,"未获取到相关会议室信息"),

    RESERVE_RULE_APPROVE_ERROR(200005,"需要审批,请选择审批人"),

    RESERVE_RULE_SPECIAL_ERROR(200006,"此会议室只针对特殊部门,请联系管理员"),

    RESERVE_CONFERENCE_ERROR(200007,"此会议室只针对特殊部门,请联系管理员"),

    RESERVE_CONFLICT_ERROR(200008,"时间段存在冲突,请重新选择时间"),

    RESERVE_LOCK_ERROR(200009,"申请资源失败,请检查时间是否冲突"),

    RESERVE_SIGN_ERROR(200010,"您不是此次会议人员！无法签到"),

    RESERVE_EHRSERVICE_ERROR(200011,"获取EHR审批人员信息异常,请联系管理员"),

    RESERVE_NONECONPEOPLE_ERROR(200011,"您不是此次会议人员！无法查看会议详情"),

    RESERVE_QRCODE_ERROR(200031,"此二维码已失效，请重新获取"),

    RESERVE_AlREADY_SIGN(200032,"您已签到该会议"),

    TERMINATE_CONFERENCE_ERROR(200033,"结束会议失败"),

    CANCEL_CONFERENCE_ERROR(200033,"结束会议失败"),

    RESERVE_TIME_ERROR(200034,"预定时间不可小于当前时间"),

    BATCH_CANCEL_CONFERENCE_ERROR(200035,"批量取消会议失败"),

    NOW_TIME_AFTER_CONFERENCE_START_TIME_ERROR(200036,"当前会议已开始,不可更改参会人员"),

    RESERVE_IN_SUSPEND_ERROR(200008,"所选时间段存在停用时间,请重新选择时间"),



    /*********************** 连接西你想相关异常 300XXX ***************/
    CONNECTION_UNEXITS_ERROR(300001,"未查询到先相关连接信息"),

    TIMESPOT_UNEXITS_ERROR(300002,"未查询到相关时间节点信息"),


    /*********************** 其它异常 400XXX ***************/

    ;
    private int code;

    private String message;

    private ParisExceptionEnum(int code, String message){
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public String getMessage() {
        return message;
    }
}

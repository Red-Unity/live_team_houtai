package com.live.liveteam.common.enums;

/**
 * 结果码枚举类
 * 
 * @author zhangyang
 * @date 2018/10/09
 */
public enum EnumResult {
    // ----------------------模块间预留100000，模块内预留20-----------------------

    // -------------------------基础结果码-------------------------
    /**
     * 成功
     */
    SUCCESS(0, "成功"),

    /**
     * 系统异常
     */
    SYSTEM_EXCEPTION(20, "系统异常"),

    /*
     * 参数为空
     */
    PARAM_NULL(40, "参数为空"),

    DATA_LOSS_OR_ERROR(10010,"数据丢失或错误"),
    SELECT_ERROR(10011, "查询失败"),
    INSERT_ERROR(10012, "添加失败"),
    DELETE_ERROR(10013, "删除失败"),
    UPDATE_ERROR(10014, "修改失败"),
    OPERATION_ERROR(10019, "操作失败"),

    /**
     * 数据为空
     */
    DATA_NULL(60, "数据为空"),


    /**
     * 
     */
    DATA_ABNORMAL(70,"参数异常"),

    // -----------------------用户相关结果码------------------------- 

    /**
     * 校验登录失败
     */
    USER_CHECK_LOGIN_ERROR(100000, "校验登录失败"),

    /**
     * 用户未登录
     */

    USER_NOT_LOGIN(100001, "用户未授权"),

    USER_TOKEN_NULL(100002,"token为空"),
    USER_TOKEN_LOSE(100003,"token已失效"),


    USER_NICKNAME_IS_EX(100004,"用户已经注册"),
    /**
     * 校验访问权限异常
     */
    USER_CHECK_ACCES_PERMISSION_ERROR(100009, "校验访问权限异常"),
    
    /**
     * 无访问权限
     */
    USER_NO_ACCESS_PERMISSION(100010, "无访问权限"),

    /**
     * 密码错误
     */
    USER_LOGIN_PASSWORD_ERROR(100020, "密码错误"),

    /**
     * 账号已锁
     */
    USER_LOGIN_ACCOUNT_LOCKED(100040, "账号已锁"),

    /**
     * 账号不存在
     */
    USER_DATA_NULL(100060, "账号不存在"),

    /**
     * 账号非开通状态
     */
    USER_ISTATUS_NOT_OK(100070, "账号非开通状态"),

    /**
     * 两次输入密码不一致
     */
    USER_CHANGE_PASSWORD_DIFF(100080, "两次输入密码不一致"),


    /**
     * 用户数字签名校验失败
     */
    WEACHAT_USER_SIGNATURE(10020,"签名校验失败"),

    /**
     * 用户旧密码错误
     */
    USER_CHANGE_PASSWORD_OLD_ERROR(100100, "用户旧密码错误"),
    
    /**
     * 查找公告失败无此公告
     */
    WITHOUT_THIS_ANNOUNCEMENT(100102, "查找公告失败无此公告"),
	UPLOAD_ERROR(1001001,"图片上传失败"),
	CANNOT_MOVE(1001004,"已是最底层"),
	TOPMOST_MOVE(1001005,"已是最顶层"),

    // -------------------- 订单相关----------------
    THE_CURRENT_STATE_CANNOT_PERFORM_THIS_OPERATION(1003001, "当前状态无法执行此操作"),

	/**
	 * 未查询到物流信息
	 */
	LOGISTIC_INFO_NOT_FOUND(1009001,"未查询到物流信息"),

    // 订单收货地址
    NO_RECEIVING_ADDRESS_EXISTS(1003011,"不存在收货地址"),
    ;
	
    private Integer code;
    private String msg;

    private EnumResult() {}

    private EnumResult(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
	public static String getMsg(Integer code) {
        if (code == null) {
            return null;
        }
        for (EnumResult r : EnumResult.values()) {
            if (code.equals(r.getCode())) {
                return r.getMsg();
            }
        }
        return null;
    }

}

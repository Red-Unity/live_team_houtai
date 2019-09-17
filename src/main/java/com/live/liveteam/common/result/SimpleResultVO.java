package com.live.liveteam.common.result;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 
 * @author Administrator
 * @date 2018/10/08
 */
@ApiModel("SimpleResultVO(结果说明)")
public class SimpleResultVO {

    /**
     * 结果码
     */
    @ApiModelProperty(value = "结果码", required = true)
    private Integer code;

    /**
     * 消息
     */
    @ApiModelProperty(value = "消息")
    private String msg;


    public static SimpleResultVO ok() {
        SimpleResultVO r = new SimpleResultVO();
        r.setCode(0);
        r.setMsg("操作成功");
        return r;
    }

    public static SimpleResultVO error() {
        SimpleResultVO r = new SimpleResultVO();
        r.setCode(-1);
        r.setMsg("操作失败");
        return r;
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
}

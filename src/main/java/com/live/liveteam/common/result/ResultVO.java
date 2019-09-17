package com.live.liveteam.common.result;

import com.live.liveteam.common.enums.EnumResult;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

import javax.xml.transform.Result;
import java.util.Map;

/**
 * 
 * @author Administrator
 * @date 2018/09/30
 */
@ApiModel("ResultVO(返回结果)")
public class ResultVO<T> {

    /**
     * 结果码
     */
    @ApiModelProperty(value = "状态码：0-成功，其它失败", required = true)
    private Integer code;

    /**
     * 消息
     */
    @ApiModelProperty(value = "消息", required = true)
    private String msg;

    /**
     * 
     */
    @ApiModelProperty(value = "数据")
    private T data;

    public ResultVO() {
        super();
    }

    public ResultVO(Integer code, String msg) {
        super();
        this.code = code;
        this.msg = msg;
    }

    public ResultVO(Integer code, String msg, T data) {
        super();
        this.code = code;
        this.msg = msg;
        this.data = data;
    }


    public static ResultVO ok(Object obj) {
        ResultVO r = new ResultVO();
        r.setCode(EnumResult.SUCCESS.getCode());
        r.setMsg(EnumResult.SUCCESS.getMsg());
        r.setData(obj);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

}

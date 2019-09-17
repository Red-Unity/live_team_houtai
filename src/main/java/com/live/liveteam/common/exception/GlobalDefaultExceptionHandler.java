package com.live.liveteam.common.exception;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletResponse;

import com.live.liveteam.common.enums.EnumResult;
import com.live.liveteam.common.result.SimpleResultVO;
import org.apache.shiro.authz.AuthorizationException;
import org.apache.shiro.authz.UnauthorizedException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSONObject;

/**
 * 默认全局异常处理类
 * 
 * @author zhangyang
 * @date 2018/10/18
 */
    @ControllerAdvice
    @ResponseBody
    public class GlobalDefaultExceptionHandler {

        private Logger logger = LoggerFactory.getLogger(GlobalDefaultExceptionHandler.class);

    /**
     * 校验访问权限异常
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(value = AuthorizationException.class)
    public void handAuthorizationException(AuthorizationException e, HttpServletResponse response) {
        logger.error("校验访问权限异常：", e);
        SimpleResultVO result = new SimpleResultVO();
        result.setCode(EnumResult.USER_CHECK_ACCES_PERMISSION_ERROR.getCode());
        result.setMsg(EnumResult.USER_CHECK_ACCES_PERMISSION_ERROR.getMsg());
        writeJson(result, response);
    }

    /**
     * 无访问权限
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(value = UnauthorizedException.class)
    public void handUnauthorizedException(UnauthorizedException e, HttpServletResponse response) {
        SimpleResultVO result = new SimpleResultVO();
        result.setCode(EnumResult.USER_NO_ACCESS_PERMISSION.getCode());
        result.setMsg(EnumResult.USER_NO_ACCESS_PERMISSION.getMsg());
        writeJson(result, response);
    }

    /**
     * 业务异常
     * 
     * @param e
     * @return
     */
    @ExceptionHandler(value = BizException.class)
    public void handBizException(BizException e, HttpServletResponse response) {
        SimpleResultVO result = new SimpleResultVO();
        result.setCode(e.getCode());
        result.setMsg(e.getMsg());
        writeJson(result, response);
    }

//    /**
//     * 其它异常
//     *
//     * @param e
//     * @return
//     */
//    @ExceptionHandler(value = Exception.class)
//    public void handException(Exception e, HttpServletResponse response) {
//        logger.error("系统异常：", e);
//        SimpleResultVO result = new SimpleResultVO();
//        result.setCode(EnumResult.SYSTEM_EXCEPTION.getCode());
//        result.setMsg(EnumResult.SYSTEM_EXCEPTION.getMsg());
//        writeJson(result, response);
//    }

    private void writeJson(SimpleResultVO result, HttpServletResponse response) {
        PrintWriter out = null;
        try {
            response.setCharacterEncoding("UTF-8");
            response.setContentType("application/json; charset=utf-8");
            out = response.getWriter();
            out.write(JSONObject.toJSONString(result));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (out != null) {
                out.close();
            }
        }
    }
}

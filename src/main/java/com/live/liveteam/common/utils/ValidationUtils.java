package com.live.liveteam.common.utils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ClassName: ValidationUtils
 * Function:  参数校验工具
 * Date:      2018-11-19 14:40
 * author     linyuanbao
 * version    V1.0
 */
public class ValidationUtils {

    /**
     * @Function 判断是否是手机号
     * @author   likaixuan
     * @Date     2018-11-19 14:41
     * @param
     * @return   boolean
     */
    public static boolean isPhone(String phone) {

        Pattern pattern = Pattern.compile("^(1[3-9])\\d{9}$");
        Matcher matcher = pattern.matcher(phone);
        if (matcher.matches()) {
            return true;
        }
        return false;
    }
}

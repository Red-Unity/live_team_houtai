package com.live.liveteam.common.utils;

import java.math.BigDecimal;
import java.text.DecimalFormat;

public class BigDecimalUtil {
    // 小数保留数量
    private static final int RESERVED_QUANTITY = 2;

    /**
     * 舍入规则
     * BigDecimal.ROUND_DOWN 直接删除多余小数;
     * BigDecimal.ROUND_UP 直接进位处理(3.11110001 = 3.1112; 3.11119999 = 3.1112);
     * BigDecimal.ROUND_HALF_UP 四舍五入;
     * BigDecimal.ROUND_HALF_DOWN 四舍五弃六入;
     */
    private static final int ROUNDING_RULES = BigDecimal.ROUND_HALF_UP;
    private static final int ROUNDING_RULES_UP = BigDecimal.ROUND_UP;
    private static final int ROUND_DOWN = BigDecimal.ROUND_DOWN;

    public static void main(String[] args) {
        /*System.err.println(new BigDecimal(3.156).toString());
        System.err.println(new BigDecimal("3.156").toString());
        System.err.println(new BigDecimal(Double.valueOf(3.156)).toString());
        System.err.println(new BigDecimal(Double.toString(3.156)).toString());*/
    }

    /**
     * 四舍五入
     *
     * @param value
     * @return
     */
    public static Double Rounding(double value) {
        BigDecimal bd = new BigDecimal(Double.toString(value));
        return bd.setScale(RESERVED_QUANTITY, ROUNDING_RULES).doubleValue();
    }

    /**
     * 加法
     *
     * @param value1
     * @param value2
     * @return
     */
    public static Double add(double value1, double value2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(value1));
        BigDecimal bd2 = new BigDecimal(Double.toString(value2));
        return bd1.add(bd2).setScale(RESERVED_QUANTITY, ROUNDING_RULES).doubleValue();
    }

    /**
     * 减法
     *
     * @param value1
     * @param value2
     * @return
     */
    public static Double subtract(double value1, double value2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(value1));
        BigDecimal bd2 = new BigDecimal(Double.toString(value2));
        return bd1.subtract(bd2).setScale(RESERVED_QUANTITY, ROUNDING_RULES).doubleValue();
    }

    /**
     * 乘法 2位小数 四舍五入
     *
     * @param value1
     * @param value2
     * @return
     */
    public static Double multiply(double value1, double value2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(value1));
        BigDecimal bd2 = new BigDecimal(Double.toString(value2));
        return bd1.multiply(bd2).setScale(RESERVED_QUANTITY, ROUNDING_RULES).doubleValue();
    }

    /**
     * 除法
     *
     * @param value1
     * @param value2
     * @return
     */
    public static Double divide(double value1, double value2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(value1));
        BigDecimal bd2 = new BigDecimal(Double.toString(value2));
        return bd1.divide(bd2, RESERVED_QUANTITY, ROUNDING_RULES).doubleValue();
    }

    /**
     * 保留2位小数
     * @param d
     * @param l
     * @return
     */
    public static String formatDecimal(Double d, int l) {
        DecimalFormat df = new DecimalFormat("#.00");
        return df.format(d);
    }

    /**
     * 乘法 2位小数 进位
     *
     * @param value1
     * @param value2
     * @return
     */
    public static Double multiply_up(double value1, double value2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(value1));
        BigDecimal bd2 = new BigDecimal(Double.toString(value2));
        return bd1.multiply(bd2).setScale(RESERVED_QUANTITY, ROUNDING_RULES_UP).doubleValue();
    }

    /**
     * 除法  2位小数 进位
     *
     * @param value1
     * @param value2
     * @return
     */
    public static Double divide_up(double value1, double value2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(value1));
        BigDecimal bd2 = new BigDecimal(Double.toString(value2));
        return bd1.divide(bd2, RESERVED_QUANTITY, ROUNDING_RULES_UP).doubleValue();
    }

    /**
     * 乘法 2位小数 舍去后位
     *
     * @param value1
     * @param value2
     * @return
     */
    public static Double multiply_down(double value1, double value2) {
        BigDecimal bd1 = new BigDecimal(Double.toString(value1));
        BigDecimal bd2 = new BigDecimal(Double.toString(value2));
        return bd1.multiply(bd2).setScale(RESERVED_QUANTITY, ROUND_DOWN).doubleValue();
    }
}

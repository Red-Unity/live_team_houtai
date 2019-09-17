package com.live.liveteam.common.utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.BeanUtils;
import org.springframework.util.CollectionUtils;

/**
 * 集合工具类
 * 
 * @author linyuanbao
 * @date 2018/10/09
 */
public class LiveCollectionUtil {

    /**
     * 复制List对象
     * 
     * @param poList
     * @param voClass
     * @return
     */
    public static List copyList(List<? extends Object> poList, Class voClass) {

        List<Object> voList = new ArrayList<>();

        Object voObj = null;
        for (Object poObj : poList) {
            try {
                voObj = voClass.newInstance();
            } catch (InstantiationException | IllegalAccessException e) {
                e.printStackTrace();
            }
            BeanUtils.copyProperties(poObj, voObj);
            voList.add(voObj);
        }
        return voList;
    }

    /**
     * 创建hasMap
     * 
     * @return
     */
    public static Map<String, Object> createHashMap() {
        return new HashMap<String, Object>();
    }

    /**
     * 数组转化为特定格式分隔的字符串
     * 
     * @param list
     * @param regex
     * @return
     */
    public static String getStringOfInteger(List<Integer> list, String regex) {
        StringBuffer sb = new StringBuffer();
        for (Integer i : list) {
            sb.append(i).append(regex);
        }
        if (sb.lastIndexOf(regex) != -1) {
            sb.deleteCharAt(sb.lastIndexOf(regex));
        }
        return sb.toString();
    }

    /**
     * 数组转化为特定格式分隔的字符串
     * 
     * @param list
     * @param regex
     * @return
     */
    public static String getStringOfString(List<String> list, String regex) {
    	if(CollectionUtils.isEmpty(list)) {
    		return null;
    	}
        StringBuffer sb = new StringBuffer();
        for (String s : list) {
            sb.append(s).append(regex);
        }
        if (sb.lastIndexOf(regex) != -1) {
            sb.deleteCharAt(sb.lastIndexOf(regex));
        }
        return sb.toString();
    }
    }

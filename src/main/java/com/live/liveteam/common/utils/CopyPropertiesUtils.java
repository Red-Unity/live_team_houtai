package com.live.liveteam.common.utils;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;

import java.util.ArrayList;
import java.util.List;

/**
 * 使用spring提供的BeanUtils.copyProperties()
 * 进行转换pojo类型实体类
 */
public class CopyPropertiesUtils {

//    protected static final Logger log = LoggerFactory.getLogger(CopyPropertiesUtils.class);
    /**
     * 数据转换
     *
     * @param listT
     * @return
     */
    public static<P, D> List<D> dataConversion(List<P> listT, Class<D> classD) {
        List<D> listD = new ArrayList<>();
        try{
            D d = null;
            for (int i = 0; i < listT.size(); i++) {
                d = classD.newInstance();
                BeanUtils.copyProperties(listT.get(i),d);
                listD.add(d);
            }
        }catch (Exception e){
//            log.error("pojo类型转换失败{}",e.getMessage());
        }
        return listD;
    }

}

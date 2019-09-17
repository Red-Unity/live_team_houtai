package com.live.liveteam.service.impl;

import com.live.liveteam.common.enums.EnumResult;
import com.live.liveteam.common.exception.BizException;
import com.live.liveteam.common.result.ResultVO;
import com.live.liveteam.common.result.SimpleResultVO;
import com.live.liveteam.entity.Administrator;
import com.live.liveteam.mapper.AdministratorMapper;
import com.live.liveteam.service.AdministratorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Component
@Service
public class AdministratorServiceImpl implements AdministratorService {

    @Autowired
    private AdministratorMapper administratorMapper;
    /**
     * 获得管理员ID
     */

    public Administrator getProductById(@PathVariable("adminId") Integer adminId){
        System.out.println(administratorMapper.selectByPrimaryKey(adminId));
        return administratorMapper.selectByPrimaryKey(adminId);
    }
    /**
     * 删除管理员ID
     */

    public String delAdministrator(@PathVariable Integer adminId){
        int i = administratorMapper.deleteByPrimaryKey(adminId);
        ResultVO<Object> objectResultVO = new ResultVO<>();
//        objectResultVO.
        return null;
    }


    /**
     *
     * @param adminNickname
     * @param adminPassword
     * @param adminRealName
     * @param adminIdCard
     * @param adminPower
     * @param adminPhone
     * @param adminSex
     * @param adminAge
     * @param adminId
     * @param adminStatus
     * @return
     */
    @Override
    public SimpleResultVO selectAdministrator(String adminNickname, String adminPassword, String adminRealName, String adminIdCard, String adminPower, String adminPhone, String adminSex, String adminAge, int adminId, int adminStatus) {
        /**
//         * 查询管理员ID
//         */
//        Administrator administrator = administratorMapper.selectByPrimaryKey(adminId);
////            System.out.println(administratorMapper.selectByPrimaryKey(adminId));
////            return administratorMapper.selectByPrimaryKey(adminId);
        SimpleResultVO result =new SimpleResultVO();
        Administrator administrator1 = administratorMapper.selectByNickName(adminNickname);
        if (administrator1!=null){
            throw new BizException(EnumResult.USER_NICKNAME_IS_EX);
        }

        Administrator administrator = new Administrator();
        administrator.setAdminAge(adminAge);

        int insert = administratorMapper.insert(administrator);


        result.setCode(EnumResult.SUCCESS.getCode());
        result.setMsg(EnumResult.SUCCESS.getMsg());

        return result;
    }


}

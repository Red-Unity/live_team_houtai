package com.live.liveteam.controller;
import com.live.liveteam.common.result.ResultVO;
import com.live.liveteam.common.result.SimpleResultVO;
import com.live.liveteam.entity.Administrator;
import com.live.liveteam.service.AdministratorService;
import com.live.liveteam.vo.UploadVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RequestMapping("Administrator")
@RestController
public class AdministratorController {

    @Autowired
    private AdministratorService administratorService;

    @GetMapping("queryaddress")
    public SimpleResultVO queryAddress(String adminNickname, String adminPassword, String adminRealName, String adminIdCard,
                                       String adminPower, String adminPhone, String adminSex, String adminAge, int adminId, int adminStatus){
        return administratorService.selectAdministrator(adminNickname,adminPassword,adminRealName,adminIdCard,adminPower,adminPhone,
                adminSex,adminAge,adminId,adminStatus);
    }


}

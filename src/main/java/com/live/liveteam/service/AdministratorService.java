package com.live.liveteam.service;
import com.live.liveteam.common.result.ResultVO;
import com.live.liveteam.common.result.SimpleResultVO;
import com.live.liveteam.entity.Administrator;

import java.util.List;

public interface AdministratorService {
        SimpleResultVO selectAdministrator(String adminNickname, String adminPassword, String adminRealName, String adminIdCard, String adminPower,
                                           String adminPhone, String adminSex, String adminAge, int adminId, int adminStatus);


}

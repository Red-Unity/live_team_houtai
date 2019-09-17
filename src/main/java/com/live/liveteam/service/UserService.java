package com.live.liveteam.service;

import com.live.liveteam.common.result.SimpleResultVO;
import com.live.liveteam.entity.User;
import com.live.liveteam.req.UpdateUserReq;

public interface UserService {
    User selectUser();

    SimpleResultVO updateUserInfo(UpdateUserReq req, String token);
}

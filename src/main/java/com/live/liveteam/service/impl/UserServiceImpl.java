package com.live.liveteam.service.impl;


import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.live.liveteam.common.enums.EnumResult;
import com.live.liveteam.common.result.SimpleResultVO;
import com.live.liveteam.common.utils.RedisUtil;
import com.live.liveteam.entity.User;
import com.live.liveteam.entity.UserExample;
import com.live.liveteam.mapper.UserMapper;
import com.live.liveteam.req.UpdateUserReq;
import com.live.liveteam.service.UserService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * 作者：木木豹
 * 时间2019-09-02 21:06
 * 描述：
 */
@Service
public class UserServiceImpl implements UserService {
    //    private  static  final Logger logger = LoggerFactory.getLogger(UserServiceImpl.class);
    @Autowired
    private UserMapper userMapper;

    @Autowired
    private RedisUtil redisUtil;

    @Override
    public User selectUser() {
        UserExample userExample = new UserExample();
//        logger.info("123213");
        UserExample.Criteria criteria = userExample.createCriteria();
        List<User> users = userMapper.selectByExample(userExample);
        System.out.println(users.toString());
        return null;
    }

    /**
     * 修改用户个人信息
     *
     * @param req
     * @return
     */
        @Override
        public SimpleResultVO updateUserInfo(UpdateUserReq req, String token) {
            SimpleResultVO result = new SimpleResultVO();
            User user = new User();
            if (req != null) {
                BeanUtils.copyProperties(user, req);
            }
            Object userInfo = redisUtil.get(token);
            String info = JSON.toJSONString(userInfo);
            User user2 = JSONObject.parseObject(info, User.class);
            user.setOpenId(user2.getOpenId());
            //想数据库更新userinfo具体值
            int count = userMapper.updateByPrimaryKeySelective(user);

        //修改redis缓存中的值
        if (count > 0) {
            BeanUtils.copyProperties(user2, user);
            redisUtil.set(RedisUtil.LOGIN_USER_STRING + token, user2);
        }
        result.setCode(EnumResult.SUCCESS.getCode());
        result.setMsg(EnumResult.SUCCESS.getMsg());
        return result;
    }
}

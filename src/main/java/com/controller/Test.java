package com.controller;
import com.auto.dao.UserMapper;
import com.auto.entity.User;
import com.util.IdUtil;
import com.util.RedisUtils;
import org.redisson.api.RLock;
import org.redisson.api.RedissonClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.script.DigestUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Date;
import java.util.UUID;

@Controller
public class Test {
    private static Logger logger = LoggerFactory.getLogger(Test.class);
    @Autowired
    private RedisUtils redisUtils;
    @Autowired
    private IdUtil idUtil;

    @Autowired
    private RedissonClient redissonClient;
    @Autowired
    private UserMapper userMapper;

    @GetMapping("test")
    @ResponseBody
    public Object test(){

        try {
/*            User user = new User();
            user.setId(idUtil.getNextId());
            user.setAccount("123456");
            user.setUpdateAt(new Date());
            user.setSalt(UUID.randomUUID().toString());
            user.setPwd(DigestUtils.sha1DigestAsHex(user.getSalt()+"123456"));
            userMapper.insertSelective(user);*/
        }catch (Exception e){
            e.printStackTrace();
        }
        return "success";
    }
}

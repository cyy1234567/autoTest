package com.util;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class IdUtil {
    @Autowired
    private RedisTemplate redisTemplate;
    public Long getNextId(){
        Long nextId=System.currentTimeMillis()/1000;
        String key = Long.toString(nextId);
        Long nowId=redisTemplate.opsForValue().increment(key).longValue();
        if(nowId<2) {
            redisTemplate.expire(key, 3, TimeUnit.SECONDS);
        }
        Long nowTempId=nowId.longValue();
        int count=0;
        while (((int)(nowTempId/10))>0){
            count++;
            nowTempId=nowTempId/10;
        }
        count++;
        for(int i=1;i<=count;i++){
            nextId=nextId*10;
        }
        nextId=nextId+nowId;
        return nextId;
    }
}

package com;


import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RBucket;
import org.redisson.api.RMap;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.concurrent.TimeUnit;

@RunWith(SpringRunner.class)
@ActiveProfiles("dev")
@SpringBootTest
public class AppTest {
    @Autowired
    private RedissonClient redissonClient;
    //@Test
    public void test(){
        RBucket<String> key =
        redissonClient.getBucket("0001");
        key.set("value 0002",60*10, TimeUnit.SECONDS);
    }
}

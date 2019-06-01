package com.util;

import com.google.gson.Gson;
import com.google.gson.JsonSyntaxException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.util.StringUtils;
import java.lang.reflect.Type;
import java.util.concurrent.TimeUnit;

public class StringRedisUtils {
    private static Logger logger= LoggerFactory.getLogger(StringRedisUtils.class);

    /**
     * 获取并转换成List对象
     * @param stringRedisTemplate
     * @param key
     * @param typeOfT , e.g. new TypeToken<List<Resume>>(){}.getType()
     * @param <T>
     * @return
     */
    public static <T> T fetchForList(StringRedisTemplate stringRedisTemplate, String key, Type typeOfT){
        String value = fetch(stringRedisTemplate, key);
        if(StringUtils.isEmpty(value)){
            return null;
        }
        try{
            return new Gson().fromJson(stringRedisTemplate.opsForValue().get(key), typeOfT);
        }catch (JsonSyntaxException e){
            logger.error("json conversion for list error",e);
            return null;
        }
    }

    /**
     * 获取并转换成指定对象
     * @param stringRedisTemplate
     * @param key
     * @param clazz
     * @param <T>
     * @return
     */
    public static <T> T fetchForEntity(StringRedisTemplate stringRedisTemplate, String key, Class<T> clazz){
        String value = fetch(stringRedisTemplate, key);
        if(StringUtils.isEmpty(value)){
            return null;
        }
        try{
            return new Gson().fromJson(stringRedisTemplate.opsForValue().get(key), clazz);
        }catch (JsonSyntaxException e){
            logger.error("json conversion for entity error",e);
            return null;
        }
    }

    public static void set(StringRedisTemplate stringRedisTemplate, String key, Object obj){
        stringRedisTemplate.opsForValue().set(key, new Gson().toJson(obj));
    }

    public static void setWithTimeoutSecond(StringRedisTemplate stringRedisTemplate, String key, Object obj, final long timeout){
        stringRedisTemplate.opsForValue().set(key, new Gson().toJson(obj), timeout, TimeUnit.SECONDS);
    }

    private static String fetch(StringRedisTemplate stringRedisTemplate, String key){
        return stringRedisTemplate.opsForValue().get(key);
    }
}


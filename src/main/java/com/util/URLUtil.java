package com.util;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashSet;
import java.util.Properties;
import java.util.Set;

public class URLUtil {

    private static Set<String> AnonymousURLSet = new HashSet<>();

    private static Set<String> CommonURLSet = new HashSet<>();
    static{
        Properties p = new Properties();
        InputStream inputStream = Object.class.getResourceAsStream("/anonymousURL.properties");
        try {
            p.load(inputStream);
            String urls = p.getProperty("anonymousURL");
            if(urls!=null&&urls.trim().length()>0){
                String [] strs = urls.split(",");
                if(strs!=null&&strs.length>0){
                    for(String str : strs){
                        AnonymousURLSet.add(str.trim());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static{
        Properties p = new Properties();
        InputStream inputStream = Object.class.getResourceAsStream("/commonURL.properties");
        try {
            p.load(inputStream);
            String urls = p.getProperty("commonURL");
            if(urls!=null&&urls.trim().length()>0){
                String [] strs = urls.split(",");
                if(strs!=null&&strs.length>0){
                    for(String str : strs){
                        CommonURLSet.add(str.trim());
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static boolean isAnonymousURL(String url){
        if(url!=null){
            return AnonymousURLSet.contains(url);
        }
        return false;
    }

    public static boolean isCommonURL(String url){
        if(url!=null) {
            return CommonURLSet.contains(url);
        }
        return false;
    }
}

package com.anonymous.controllers;

import com.util.CommonRsaUtil;
import com.util.ResponseUtils;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * 公开接口，不需要登录即可访问
 */
@Controller
@RequestMapping(value="anonymous")
public class AnonymousController {
    @GetMapping(value = "publicKey")
    @ResponseBody
    public ResponseUtils getPublicKey(){
        String result = CommonRsaUtil.getPublicKey();
        return ResponseUtils.success(result);
    }

}

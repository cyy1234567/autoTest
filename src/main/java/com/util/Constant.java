package com.util;

public class Constant {
    //公开访问地址，无需身份认证即可访问,以 anonymous 为前缀
    public static final String AnonymousURL_Prefix = "/anonymous";
    //公共访问地址，身份认证通过无需分配权限即可访问,以common为前缀
    public static final String commonURL_Prefix = "/common";
    //需要登录,需要授权
    public static final String autoURL_Prefix = "/auto";
}

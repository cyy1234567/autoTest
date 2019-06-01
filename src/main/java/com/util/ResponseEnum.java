package com.util;

public enum ResponseEnum {

    //操作成功
    SUCCESS(0, "\u64cd\u4f5c\u6210\u529f"),

    //参数错误
    PARAMETER_ERROR(10000, "\u53c2\u6570\u9519\u8bef"),

    //未登录
    NOT_LOGGED_IN(20001, "\u672a\u767b\u5f55"),

    //"帐号信息错误:帐号不存在"
    ACCOUNT_NOT_EXIST_ERROR(20002, "\u5E10\u53F7\u4FE1\u606F\u9519\u8BEF:\u5E10\u53F7\u4E0D\u5B58\u5728"),

    //帐号信息错误:帐号被冻结
    ACCOUNT_FREEZE_ERROR(20003, "\u5E10\u53F7\u4FE1\u606F\u9519\u8BEF:\u5E10\u53F7\u88AB\u51BB\u7ED3"),

    //帐号信息错误:该帐号没有权限
    ACCOUNT_NO_AUTH_ERROR(20004, "\u5E10\u53F7\u4FE1\u606F\u9519\u8BEF:\u8BE5\u5E10\u53F7\u6CA1\u6709\u6743\u9650"),

    //新增数据失败
    INSERT_ERROR(30002, "\u65b0\u589e\u6570\u636e\u5931\u8d25"),

    //更新失败
    UPDATE_ERROR(30005, "\u66f4\u65b0\u5931\u8d25"),

    //操作失败!
    OPERATE_ERROR(30006, "\u64CD\u4F5C\u5931\u8D25!"),

    //业务异常:{0}
    BUSSINESS_ERROR(30001, "\u4E1A\u52A1\u5F02\u5E38:{0}"),

    AUTH_ERROR(40001, "\u6743\u9650\u4e0d\u8db3"),

    ACCOUNT_EXCEPTION(30007, "\u5e10\u53f7\u5f02\u5e38"),

    //信息不存在
    NOT_EXIST(30008, "\u4E0D\u5B58\u5728"),

    SERVER_ERROR(50000, "\u9ebb\u9ebb\u5440\uff0c\u670d\u52a1\u5668\u6682\u65f6\u8dd1\u4e22\u4e86\uff5e");

    private int value;
    private String name;

    private ResponseEnum(int value, String name) {
        this.value = value;
        this.name = name;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

}


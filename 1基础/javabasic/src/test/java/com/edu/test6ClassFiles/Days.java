package com.edu.test6ClassFiles;

public enum Days {
    //这里的字段就是每一个实例！
    MONDAY("星期一"),
    TUESDAY("星期二"),
    WEDNESDAY("星期三"),
    THURSDAY("星期四"),
    FRIDAY("星期五"),
    SATURDAY("星期六"),
    SUNDAY("星期日");

    private final String chineseName;

    // 构造函数，用于初始化每个枚举常量的中文名
    Days (String chineseName) {
        this.chineseName = chineseName;
    }
    // 获取中文名的方法
    public String getChineseName() {
        return chineseName;
    }
}
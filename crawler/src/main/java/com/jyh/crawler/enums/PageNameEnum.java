package com.jyh.crawler.enums;

public enum PageNameEnum {

    T_MALL_HOME_PAGE("天猫主页"),
    T_MALL_MERCHANT_JORDAN_HOME_PAGE("天猫乔丹主页"),
    T_MALL_MERCHANT_JORDAN_MAN("天猫乔丹男子页面"),
    T_MALL_MERCHANT_JORDAN_MAN_SHOES("天猫男子鞋类页面");


    String desc;
    PageNameEnum(String desc){
        this.desc = desc;
    }
}

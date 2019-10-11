package com.jyh.crawler.domain;

import java.util.Map;

public abstract class Page {

    private String name;

    private String url;

    private String title;

    private String handle;

    private Map<String, Page> subPageMap;

    public Page(String name){
        this.name = name;
    }

    public abstract String gotoSubPage(String name, BrowerContext browerContext);

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}

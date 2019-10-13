package com.jyh.crawler.domain;

import java.util.Map;

public abstract class Page {

    private String name;

    private String url;

    private String title;

    private String handle;

    private Map<String, Page> subPageMap;

    private Page parentPage;

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getHandle() {
        return handle;
    }

    public void setHandle(String handle) {
        this.handle = handle;
    }

    public Map<String, Page> getSubPageMap() {
        return subPageMap;
    }

    public void setSubPageMap(Map<String, Page> subPageMap) {
        this.subPageMap = subPageMap;
    }

    public Page getParentPage() {
        return parentPage;
    }

    public void setParentPage(Page parentPage) {
        this.parentPage = parentPage;
    }
}

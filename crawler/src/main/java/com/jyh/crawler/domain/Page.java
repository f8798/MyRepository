package com.jyh.crawler.domain;

import com.jyh.crawler.enums.PageNameEnum;

import java.util.HashMap;
import java.util.Map;

public abstract class Page {

    private PageNameEnum name;

    private String url;

    private String title;

    private String handle;

    private Map<String, Page> subPageMap = new HashMap<>();

    private Page parentPage;

    public Page(PageNameEnum name){
        this.name = name;
    }

    public abstract String openSubPage(PageNameEnum name, BrowerContext browerContext);

    public abstract String openCurrentPage(BrowerContext browerContext);

    public void parentOf(Page page){
        this.subPageMap.put(page.getName().name(), page);
        page.setParentPage(this);
    }

    public PageNameEnum getName() {
        return name;
    }

    public void setName(PageNameEnum name) {
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

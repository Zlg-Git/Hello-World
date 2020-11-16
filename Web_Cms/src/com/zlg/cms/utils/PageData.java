package com.zlg.cms.utils;

import java.util.List;

/**
 * @PROJECT_NAME: Web_Cms
 * @PACKAGE_NAME: com.zlg.cms.utils
 * @USER: 33036
 * @DATE: 2020/11/4
 * 分页工具类
 */
public class PageData {
    private int page;// 当前页数
    private int totalCount;// 总条数
    private int limit;// 每页条数
    private int totalPages;// 总页数
    private List<?> data;// 每页显示的数据

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getLimit() {
        return limit;
    }

    public void setLimit(int limit) {
        this.limit = limit;
    }

    public int getTotalPages() {
        return totalPages;
    }
    // 在设置完总条数以及每页条数之后，直接可以获取
    public void setTotalPages() {
        // 总页数有两种情况，一种是刚刚好，一种是多出几条，多出的要占用一页
        if (totalCount%limit == 0){
            // 刚刚好用满
            totalPages = totalCount/limit;
        } else {
            // 多出几条
            totalPages = totalCount/limit + 1;
        }
    }

    public List<?> getData() {
        return data;
    }

    public void setData(List<?> data) {
        this.data = data;
    }
}

package com.live.liveteam.common.utils;

import com.live.liveteam.common.constant.BizConstant;

import java.io.Serializable;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


/**
 * 分页对象
 * 
 * @author linyuanbao
 * @date 2018/10/09
 */
public class Page<T> implements Serializable {
    /**
     *
     */
    private static final long serialVersionUID = 2419534039106656123L;

    private int pageSize = BizConstant.PAGE_SIZE_20;// 每页显示记录数默认为15

    private int currentPage = 1;// 当前页码

    private int totalCount = 0;// 总记录数

    private List<T> data;// 查询结果

    private Map<String, Object> paramMap = new HashMap<String, Object>();

    public Page() {}

    public Page(int currentPage) {
        this.currentPage = currentPage;
    }

    public Page(int currentPage, int pageSize) {
        this.currentPage = currentPage;
        this.pageSize = pageSize;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
        int totalPage = getTotalPage();
        if (currentPage < 0 || totalPage == 0) {
            currentPage = 1;
        } else if (currentPage > totalPage) {
            currentPage = totalPage;
        }
    }

    public int getTotalPage() {
        int totalPage = 0;
        if (this.totalCount == 0) {
            return totalPage;
        }
        totalPage = this.totalCount / pageSize;
        if (totalPage == 0 || totalCount % pageSize != 0) {
            totalPage = totalPage + 1;
        }
        return totalPage;
    }

    public int getStartIndex() {
        if (currentPage > 0) {
            return pageSize * (currentPage - 1);
        } else {
            return 0;
        }
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public Map<String, Object> getParamMap() {
        return paramMap;
    }

    public void setParamMap(Map<String, Object> paramMap) {
        this.paramMap = paramMap;
    }

    public void put(String key, Object value) {
        this.paramMap.put(key, value);
    }

    public Object get(String key) {
        return this.paramMap.get(key);
    }

}

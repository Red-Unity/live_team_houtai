package com.live.liveteam.common.result;

import java.util.List;


import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.live.liveteam.common.constant.BizConstant;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/**
 * 分页对象
 * 
 * @author linyuanbao
 *
 */
@ApiModel(value = "PageVO(分页对象)")
public class PageVO<T> {

    @ApiModelProperty(value = "每页数量", required = true)
    private Integer pageSize = BizConstant.PAGE_SIZE_20;// 每页显示记录数

    @ApiModelProperty(value = "当前页", required = true)
    private Integer currentPage = 1;// 当前页码

    @ApiModelProperty(value = "总记录数", required = true)
    private long totalCount = 0;// 总记录数

    @ApiModelProperty(value = "当前页的数量", required = true)
    private Integer size = BizConstant.PAGE_SIZE_20;//

    @ApiModelProperty(value = "总页数",required = true)
    private Integer pages ;

    @ApiModelProperty(value = "数据", required = true)
    private List<T> data;// 查询结果




    public  void savePageinfo(PageInfo<T> pageinfo){
        this.pageSize=pageinfo.getPageSize();//设置每页数量
        this.currentPage=pageinfo.getPageNum();//设置当前页
        this.totalCount=pageinfo.getTotal();     //设置总记录数
        this.size=pageinfo.getSize();//当前页数量
        this.pages=pageinfo.getPages();
    }

    public PageVO() {}

    public PageVO(Integer currentPage) {
        this.currentPage = currentPage;
    }

    public PageVO(Integer currentPage, Integer pageSize) {
        if (currentPage != null) {
            this.currentPage = currentPage;
        }
        if (pageSize != null) {
            this.pageSize = pageSize;
        }
    }


    public void setPageInfo(PageInfo<T> pageinfo){


    }

    public Integer getPages() {
        return pages;
    }

    public void setPages(Integer pages) {
        this.pages = pages;
    }

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        this.totalCount = totalCount;
    }

    public Integer getSize() {
        return size;
    }

    public void setSize(Integer size) {
        this.size = size;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public Integer getCurrentPage() {
        return currentPage;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public void setCurrentPage(Integer currentPage) {
        this.currentPage = currentPage;
    }
}

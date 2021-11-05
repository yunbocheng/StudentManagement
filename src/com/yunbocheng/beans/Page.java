package com.yunbocheng.beans;

import java.io.Serializable;
import java.util.List;

/**
 * page是分页的模型
 * <T> 是具体的模块的JavaBean类
 * @param <T>
 */
public class Page<T> implements Serializable {

    // 声明一个每页显示的数据条数的常量
    public static final int PAGE_SIZE = 5;

    // 当前页面
    private Integer pageNo;

    // 总页数
    private Integer pageTotal;

    // 当前页显示数量
    private Integer getPageSize = PAGE_SIZE;

    // 总记录条数
    private Integer pageTotalCount;

    // 当前页数据
    private List<T> items;

    public Page(Integer pageNo, Integer pageTotal, Integer getPageSize, Integer pageTotalCount, List<T> items) {
        this.pageNo = pageNo;
        this.pageTotal = pageTotal;
        this.getPageSize = getPageSize;
        this.pageTotalCount = pageTotalCount;
        this.items = items;
    }

    public Page() {
    }

    public Integer getPageNo() {
        return pageNo;
    }

    public void setPageNo(Integer pageNo) {
        this.pageNo = pageNo;
    }

    public Integer getPageTotal() {
        return pageTotal;
    }

    public void setPageTotal(Integer pageTotal) {
        this.pageTotal = pageTotal;
    }

    public Integer getPageSize() {
        return getPageSize;
    }

    public void setPageSize(Integer getPageSize) {
        this.getPageSize = getPageSize;
    }

    public Integer getPageTotalCount() {
        return pageTotalCount;
    }

    public void setPageTotalCount(Integer pageTotalCount) {
        this.pageTotalCount = pageTotalCount;
    }

    public List<T> getItems() {
        return items;
    }

    public void setItems(List<T> items) {
        this.items = items;
    }

    @Override
    public String toString() {
        return "Page{" +
                "pageNo=" + pageNo +
                ", pageTotal=" + pageTotal +
                ", getPageSize=" + getPageSize +
                ", pageTotalCount=" + pageTotalCount +
                ", items=" + items +
                '}';
    }
}

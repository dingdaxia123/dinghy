package com.dinghy.domain.util;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author:xgchen
 * @Date:2015-02-15 15:12
 * @Version: V0.0.1
 */
public class Pagination {
    private long totalCount = 0;
    private int pageSize = 10;
    private int pageNO = 1;
    private List<?> list = new ArrayList<Object>(0);
    private int totalPage = 0;
    private String totalAmount;

    public long getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(long totalCount) {
        if (totalCount == 0) {
            this.pageNO = 0;
            this.totalPage = 0;
        } else {
            this.totalPage = (((Long) totalCount).intValue() - 1) / pageSize + 1;
        }
        this.totalCount = totalCount;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getPageNO() {
        return pageNO;
    }

    public void setPageNO(int pageNO) {
        if (pageNO <= 0) pageNO = 1;
        this.pageNO = pageNO;
    }

    public List getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    /**
     * 总共几页
     */
    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    /**
     * 是否第一页
     */
    public boolean isFirstPage() {
        return pageNO <= 1;
    }

    /**
     * 是否最后一页
     */
    public boolean isLastPage() {
        return pageNO >= getTotalPage();
    }

    /**
     * 下一页页码
     */
    public int getNextPage() {
        if (isLastPage()) {
            return pageNO;
        } else {
            return pageNO + 1;
        }
    }

    /**
     * 上一页页码
     */
    public int getPrePage() {
        if (isFirstPage()) {
            return pageNO;
        } else {
            return pageNO - 1;
        }
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }
}

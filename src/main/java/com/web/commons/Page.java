package com.web.commons;

import java.io.Serializable;
import java.util.List;

/**
 * 用于封装分页数据的对象
 * @author WJUN
 * @create 2018/10/28 17:58
 */
public class Page implements Serializable {
    private int currentPageNum;//当前页
    private int pageSize = 5;//每页显示的条数
    private int totalRecords;//总记录条数
    private int startIndex;//查询的开始记录索引
    private int tatolPageNum;//总页数
    private int prePageNum;//上一页
    private int nextPageNum;//下一页
    private List records;//分好页的结果集

    /**
     * 要想使用此类，必须使用两个参数
     * @param currentPageNum 当前页
     * @param totalRecords 总记录条数
     */
    public Page(int currentPageNum, int totalRecords) {
        this.currentPageNum = currentPageNum;
        this.totalRecords = totalRecords;
        //计算开始记录的索引
        startIndex = (currentPageNum-1)*pageSize;
        //计算总页数
        tatolPageNum = totalRecords % pageSize == 0 ? totalRecords / pageSize : (totalRecords/pageSize + 1);
    }

    public int getPrePageNum() {
        //计算上一页
        if (currentPageNum == 1){
            prePageNum = currentPageNum;
        }else {
            prePageNum = currentPageNum - 1;
        }
        return prePageNum;
    }

    public int getNextPageNum() {
        //计算下一页
        nextPageNum = currentPageNum + 1;
        if (nextPageNum > tatolPageNum){
            nextPageNum = tatolPageNum;
        }
        return nextPageNum;
    }

    public int getCurrentPageNum() {
        return currentPageNum;
    }

    public void setCurrentPageNum(int currentPageNum) {
        this.currentPageNum = currentPageNum;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalRecords() {
        return totalRecords;
    }

    public void setTotalRecords(int totalRecords) {
        this.totalRecords = totalRecords;
    }

    public int getStartIndex() {
        return startIndex;
    }

    public void setStartIndex(int startIndex) {
        this.startIndex = startIndex;
    }

    public int getTatolPageNum() {
        return tatolPageNum;
    }

    public void setTatolPageNum(int tatolPageNum) {
        this.tatolPageNum = tatolPageNum;
    }

    public void setPrePageNum(int prePageNum) {
        this.prePageNum = prePageNum;
    }

    public void setNextPageNum(int nextPageNum) {
        this.nextPageNum = nextPageNum;
    }

    public List getRecords() {
        return records;
    }

    public void setRecords(List records) {
        this.records = records;
    }
}

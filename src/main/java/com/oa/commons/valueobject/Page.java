package com.oa.commons.valueobject;

import java.util.ArrayList;
import java.util.List;

public class Page<T> {

    private Integer pagenum;    //当前页码
    private Integer pageStartIndex;  //当前起始页索引
    private Integer pageSize;   //页面大小
    private Integer totalRows;   //总记录数
    private Integer totalPages; //总页码
    private List<T> datas;  //当前页所含的数据

    public Page() {
        this.pagenum = 1;
        this.pageSize = 3;
        datas = new ArrayList<>();
    }

    public Integer getPagenum() {
        return pagenum;
    }

    public void setPagenum(Integer pagenum) {
        this.pagenum = pagenum;
    }

    public Integer getPageStartIndex() {
        return (pagenum - 1) * pageSize;
    }

    public void setPageStartIndex(Integer pageStartIndex) {
        this.pageStartIndex = pageStartIndex;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Integer getTotalRows() {
        return totalRows;
    }

    public void setTotalRows(Integer totalRows) {
        this.totalRows = totalRows;
    }

    public Integer getTotalPages() {
        if(totalRows%pageSize == 0){
            totalPages = totalRows/pageSize;
        } else{
            totalPages = totalRows/pageSize + 1;
        }
        return totalPages;
    }

    public void setTotalPages(Integer totalPages) {
        this.totalPages = totalPages;
    }

    public List<T> getDatas() {
        return datas;
    }

    public void setDatas(List<T> datas) {
        this.datas = datas;
    }
}

package com.bnw.taskcinema.dto.common;

import java.util.ArrayList;
import java.util.List;

import static com.bnw.taskcinema.utils.DefaultValueConst.PAGE_SIZE;

public class ResponseDataDto<T extends IDto> {
    private int page;
    private int pageSize;
    private int size;
    private List<T> data;


    public ResponseDataDto() {
        page = 0;
        pageSize = PAGE_SIZE;
        data = new ArrayList<>();
        resize();
    }

    public void addData(T val) {
        this.data.add(val);
        resize();size = this.data.size();
    }


    public void addData(List<T> val) {
        this.data.addAll(val);
        resize();
    }


    private void resize(){
        size = this.data.size();
    }

    public int getPage() {
        return page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public int getSize() {
        return size;
    }

    public List<T> getData() {
        return data;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public void setData(List<T> data) {
        this.data = data;
        resize();
    }
}

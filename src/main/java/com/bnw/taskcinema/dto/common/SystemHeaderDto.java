package com.bnw.taskcinema.dto.common;

public class SystemHeaderDto {
    private String id;
    private Integer page;
    private Integer pageSize;
    private Long timestamp;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Integer getPage() {
        return page;
    }

    public void setPage(Integer page) {
        this.page = page;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    @Override
    public String toString() {
        return "SystemHeaderDto{" +
                "id='" + id + '\'' +
                ", page=" + page +
                ", pageSize=" + pageSize +
                ", timestamp=" + timestamp +
                '}';
    }
}

package com.bnw.taskcinema.dto.common;

import com.bnw.taskcinema.utils.ResponseCodeConst;

public class ResponseDto<T extends IDto> {

    private String id;
    private Long timestamp = System.currentTimeMillis();
    private String code = ResponseCodeConst.OK;
    private ResponseDataDto<T> data = new ResponseDataDto<>();
    private String error;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(Long timestamp) {
        this.timestamp = timestamp;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public ResponseDataDto<T> getData() {
        return data;
    }

//    public void setData(ResponseDataDto<T> data) {
//        this.data = data;
//    }

    public String getError() {
        return error;
    }

    public void setError(String error) {
        this.error = error;
    }
}

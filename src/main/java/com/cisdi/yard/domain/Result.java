package com.cisdi.yard.domain;

import com.cisdi.yard.consts.AppConsts;
import lombok.Data;

/**
 * @author meisen
 * 2021-05-10
 */
@Data
public class Result<T> {
    private Integer code;
    private String msg;
    private T data;
    private Long total;


    public Result(Integer code, String msg) {
        this(code, msg, null, null);
    }

    public Result(T data) {
        this(AppConsts.SUCCESS, AppConsts.SUCCESS_MSG, data, null);
    }

    public Result(T data, Long total) {
        this(AppConsts.SUCCESS, AppConsts.SUCCESS_MSG, data, total);
    }

    public Result(Integer code, String msg, T data, Long total) {
        this.code = code;
        this.msg = msg;
        this.data = data;
        this.total = total;
    }
}

package com.ppc.ffs.common;

import lombok.Data;

import java.io.Serializable;

@Data
public abstract class AbstractResponse implements Serializable {

    private static final long serialVersionUID = 4494064209636802405L;

    private ResultCode<?> resultCode;
    private Object[] objects;

    public AbstractResponse() {
        this.resultCode = DefaultResultCode.OK;
    }
}

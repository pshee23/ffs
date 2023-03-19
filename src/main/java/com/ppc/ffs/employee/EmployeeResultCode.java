package com.ppc.ffs.employee;

import com.ppc.ffs.common.DefaultResultCode;
import com.ppc.ffs.common.ResultCode;
import lombok.Getter;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.http.HttpStatus;

public enum EmployeeResultCode implements ResultCode<String> {

    OK(DefaultResultCode.OK),
    FAILED(DefaultResultCode.FAILED),
    NOT_EXIST_EMPLOYEE("E001", "직원정보가 존재하지 않습니다.", HttpStatus.NOT_FOUND);

    @Getter
    private String code;

    private String message;

    @Getter
    private HttpStatus status;

    EmployeeResultCode(String code, String message) {
        this.code = code;
        this.message = message;
        this.status = HttpStatus.OK;
    }

    EmployeeResultCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    EmployeeResultCode(ResultCode<String> resultCode) {
        this(resultCode.getCode(), resultCode.getMessage(), resultCode.getStatus());
    }

    public String getMessage() {
        return this.message;
    }

    public String getMessage(Object... variables) {
        return MessageFormatter.arrayFormat(this.message, variables).getMessage();
    }
}

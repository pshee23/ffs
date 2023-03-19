package com.ppc.ffs.lesson;

import com.ppc.ffs.common.DefaultResultCode;
import com.ppc.ffs.common.ResultCode;
import lombok.Getter;
import org.slf4j.helpers.MessageFormatter;
import org.springframework.http.HttpStatus;

public enum LessonResultCode implements ResultCode<String> {

    OK(DefaultResultCode.OK),
    FAILED(DefaultResultCode.FAILED),
    NOT_EXIST_LESSON("L001", "레슨 정보가 존재하지 않습니다.", HttpStatus.NOT_FOUND),
    NOT_EXIST_EMPLOYEE("L002", "직원 정보가 존재하지 않습니다.", HttpStatus.NOT_FOUND),
    NOT_EXIST_MEMBER("L003", "회원 정보가 존재하지 않습니다.", HttpStatus.NOT_FOUND),
    ALREADY_CANCEL_LESSON("L003", "이미 취소된 레슨입니다.", HttpStatus.BAD_REQUEST);

    LessonResultCode(ResultCode<String> resultCode) {
        this(resultCode.getCode(), resultCode.getMessage(), resultCode.getStatus());
    }

    LessonResultCode(String code, String message, HttpStatus status) {
        this.code = code;
        this.message = message;
        this.status = status;
    }

    @Getter
    private final String code;

    private final String message;

    @Getter
    private final HttpStatus status;


    @Override
    public String getMessage() {
        return this.message;
    }

    @Override
    public String getMessage(Object... variables) {
        return MessageFormatter.arrayFormat(this.message, variables).getMessage();
    }
}

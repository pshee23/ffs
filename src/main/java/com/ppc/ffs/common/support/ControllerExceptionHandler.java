package com.ppc.ffs.common.support;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String, String>> handleServiceException(MethodArgumentNotValidException exception) {
		Map<String, String> errors = new HashMap<>();
		// TODO return 방식. front에서는 어떤 형식으로 받아야 처리하기 편한가?
		exception.getBindingResult().getAllErrors()
                .forEach(c -> errors.put(((FieldError) c).getField(), c.getDefaultMessage()));
       
        
		log.error("MethodArgumentNotValidException handling. {}", errors);
		return ResponseEntity.badRequest().body(errors);
	}
}

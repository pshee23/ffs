package com.ppc.ffs.lesson.adapter.in.web.controller;

import com.ppc.ffs.lesson.adapter.in.web.request.LessonResult;
import com.ppc.ffs.lesson.adapter.in.web.request.RegisterLessonRequest;
import com.ppc.ffs.lesson.application.port.in.RegisterLessonUseCase;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.Valid;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RegisterLessonController {

    private final RegisterLessonUseCase registerLessonUseCase;

    @PostMapping("/lesson")
    public ResponseEntity<Object> registerNewLesson(@RequestBody @Valid RegisterLessonRequest registerLessonRequest) {
        LessonResult lessonResult = registerLessonUseCase.registerLesson(registerLessonRequest);

        return new ResponseEntity<>(lessonResult, lessonResult.getResultCode().getStatus());
    }
}

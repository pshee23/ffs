package com.ppc.ffs.lesson.adapter.in.web.controller;

import com.ppc.ffs.lesson.LessonResultCode;
import com.ppc.ffs.lesson.adapter.in.web.request.UpdateLessonRequest;
import com.ppc.ffs.lesson.application.port.in.UpdateLessonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

@Controller
@RequiredArgsConstructor
public class UpdateLessonController {

    private final UpdateLessonUseCase updateLessonUseCase;

    @PutMapping("/lesson/{lessonId}")
    public ResponseEntity<Object> updateLessonStatus(@PathVariable Long lessonId,
                                                     @RequestBody UpdateLessonRequest updateLessonRequest) {

        updateLessonUseCase.updateLessonStatus(lessonId, updateLessonRequest);

        return new ResponseEntity<>(LessonResultCode.OK, LessonResultCode.OK.getStatus());
    }
}

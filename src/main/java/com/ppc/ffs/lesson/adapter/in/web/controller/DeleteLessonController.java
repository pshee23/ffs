package com.ppc.ffs.lesson.adapter.in.web.controller;

import com.ppc.ffs.lesson.LessonResultCode;
import com.ppc.ffs.lesson.application.port.in.DeleteLessonUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;

@Controller
@RequiredArgsConstructor
public class DeleteLessonController {

    private final DeleteLessonUseCase deleteLessonUseCase;

    @DeleteMapping("/lesson/{lessonId}")
    public ResponseEntity<Object> cancelLesson(@PathVariable Long lessonId) {
        deleteLessonUseCase.cancelLesson(lessonId);

        return new ResponseEntity<>(LessonResultCode.OK, LessonResultCode.OK.getStatus());
    }
}

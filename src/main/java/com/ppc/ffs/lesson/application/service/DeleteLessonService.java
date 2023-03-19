package com.ppc.ffs.lesson.application.service;

import com.ppc.ffs.lesson.application.port.in.DeleteLessonUseCase;
import com.ppc.ffs.lesson.application.port.out.DeleteLessonPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class DeleteLessonService implements DeleteLessonUseCase {

    private final DeleteLessonPort deleteLessonPort;

    public void cancelLesson(Long lessonId) {
        deleteLessonPort.deleteLesson(lessonId);
    }
}

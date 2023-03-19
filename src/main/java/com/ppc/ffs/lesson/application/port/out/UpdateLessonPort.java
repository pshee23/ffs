package com.ppc.ffs.lesson.application.port.out;

public interface UpdateLessonPort {

    void updateLessonStatus(Long lessonId, String lessonStatus);
}

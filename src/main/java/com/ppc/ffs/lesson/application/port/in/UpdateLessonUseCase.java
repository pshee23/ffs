package com.ppc.ffs.lesson.application.port.in;

import com.ppc.ffs.lesson.adapter.in.web.request.UpdateLessonRequest;

public interface UpdateLessonUseCase {

    void updateLessonStatus(Long lessonId, UpdateLessonRequest updateLessonRequest);
}

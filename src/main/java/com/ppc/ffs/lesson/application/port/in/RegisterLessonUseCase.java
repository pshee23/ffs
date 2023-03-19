package com.ppc.ffs.lesson.application.port.in;

import com.ppc.ffs.lesson.adapter.in.web.request.LessonResult;
import com.ppc.ffs.lesson.adapter.in.web.request.RegisterLessonRequest;

public interface RegisterLessonUseCase {

    LessonResult registerLesson(RegisterLessonRequest registerLessonRequest);
}

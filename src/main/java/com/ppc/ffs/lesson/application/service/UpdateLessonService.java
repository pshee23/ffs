package com.ppc.ffs.lesson.application.service;

import com.ppc.ffs.common.exception.ServiceResultCodeException;
import com.ppc.ffs.lesson.LessonResultCode;
import com.ppc.ffs.lesson.adapter.in.web.request.UpdateLessonRequest;
import com.ppc.ffs.lesson.application.port.in.UpdateLessonUseCase;
import com.ppc.ffs.lesson.application.port.out.UpdateLessonPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;

@Service
@RequiredArgsConstructor
public class UpdateLessonService implements UpdateLessonUseCase {

    private final UpdateLessonPort updateLessonPort;

    @Override
    public void updateLessonStatus(Long lessonId, UpdateLessonRequest updateLessonRequest) {
        String statusText = updateLessonRequest.getStatus();

        try{
            updateLessonPort.updateLessonStatus(lessonId, statusText);
        } catch (EntityNotFoundException e) {
            throw new ServiceResultCodeException(LessonResultCode.NOT_EXIST_LESSON);
        }

        //TODO 직원 Pay에서 차감해야함 (로직 확인 후 개발)

    }
}

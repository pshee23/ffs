package com.ppc.ffs.lesson.application.service;

import com.ppc.ffs.common.exception.ServiceResultCodeException;
import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.employee.application.port.out.SelectEmployeePort;
import com.ppc.ffs.lesson.LessonResultCode;
import com.ppc.ffs.lesson.adapter.in.web.request.LessonResult;
import com.ppc.ffs.lesson.adapter.in.web.request.RegisterLessonRequest;
import com.ppc.ffs.lesson.application.port.in.RegisterLessonUseCase;
import com.ppc.ffs.lesson.application.port.out.InsertLessonPort;
import com.ppc.ffs.pt.adapter.out.persistence.entity.Pt;
import com.ppc.ffs.pt.application.port.out.SelectPtQuery;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.persistence.Entity;
import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;

@Slf4j
@Service
@Transactional
@RequiredArgsConstructor
public class RegisterLessonService implements RegisterLessonUseCase {

    private final SelectEmployeePort selectEmployeePort;
    private final SelectPtQuery selectPtQuery;
    private final InsertLessonPort insertLessonPort;

    @Override
    public LessonResult registerLesson(RegisterLessonRequest registerLessonRequest) {

        Employee employee;
        Pt pt;

        Long employeeId = registerLessonRequest.getEmployeeId();

        try {
            //-- 직원 정보 가져옴
            employee = selectEmployeePort.selectEmployee(employeeId);
        } catch (EntityNotFoundException e) {
            log.info("Not found employee. employeeId={}", employeeId);
            throw new ServiceResultCodeException(LessonResultCode.NOT_EXIST_EMPLOYEE);
        }

        Long memberId = registerLessonRequest.getMemberId();
        try {
            //-- 회원 PT 가져옴
            pt = selectPtQuery.selectAblePtByMemberIdOrderByRegisterDate(memberId);
        } catch (EntityNotFoundException e) {
            log.info("Not found pt of member. memberId={}", memberId);
            throw new ServiceResultCodeException(LessonResultCode.NOT_EXIST_MEMBER);
        }

        //--Lesson 만듬
        LocalDateTime dateTime = registerLessonRequest.getLessonDateTime();
        Long lessonId = insertLessonPort.insertLesson(employee, pt, dateTime);

        //TODO 직원 pay에 미리 추가해야함 (로직 확인 후 개발)

        return new LessonResult(lessonId);
    }
}

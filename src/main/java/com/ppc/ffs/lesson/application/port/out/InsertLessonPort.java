package com.ppc.ffs.lesson.application.port.out;

import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.pt.adapter.out.persistence.entity.Pt;

import java.time.LocalDateTime;

public interface InsertLessonPort {

    Long insertLesson(Employee employee, Pt pt, LocalDateTime dateTime);
}

package com.ppc.ffs.lesson.adapter.out.persistence.repository;

import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.lesson.adapter.out.persistence.entity.Lesson;
import com.ppc.ffs.lesson.application.port.out.DeleteLessonPort;
import com.ppc.ffs.lesson.application.port.out.InsertLessonPort;
import com.ppc.ffs.lesson.application.port.out.UpdateLessonPort;
import com.ppc.ffs.pt.adapter.out.persistence.entity.Pt;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import javax.persistence.EntityNotFoundException;
import java.time.LocalDateTime;
import java.util.Optional;

@Component
@RequiredArgsConstructor
public class LessonPersistenceAdapter implements
        InsertLessonPort,
        UpdateLessonPort,
        DeleteLessonPort {

    private final LessonRepository lessonRepository;

    @Override
    public Long insertLesson(Employee employee, Pt pt, LocalDateTime dateTime) {
        Lesson lesson = makeLesson(employee, pt, dateTime);
        Lesson newLesson = lessonRepository.save(lesson);

        return newLesson.getLessonId();
    }

    @Override
    public void updateLessonStatus(Long lessonId, String lessonStatus) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        Lesson lesson = lessonOptional.orElseThrow(EntityNotFoundException::new);
        lesson.setStatus(lessonStatus);
    }

    private Lesson makeLesson(Employee employee, Pt pt, LocalDateTime dateTime) {
        Lesson lesson = new Lesson();
        lesson.setEmployee(employee);
        lesson.setPt(pt);
        lesson.setLessonDateTime(dateTime);
        lesson.setStatus(Lesson.Status.RESERVE.getText());

        return lesson;
    }


    @Override
    public void deleteLesson(Long lessonId) {
        Optional<Lesson> lessonOptional = lessonRepository.findById(lessonId);
        Lesson lesson = lessonOptional.orElseThrow(EntityNotFoundException::new);

        lessonRepository.delete(lesson);
    }
}

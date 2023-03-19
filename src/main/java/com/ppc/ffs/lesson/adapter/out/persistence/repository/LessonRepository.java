package com.ppc.ffs.lesson.adapter.out.persistence.repository;

import com.ppc.ffs.lesson.adapter.out.persistence.entity.Lesson;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LessonRepository extends JpaRepository<Lesson, Long> {
}

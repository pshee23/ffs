package com.ppc.ffs.lesson.adapter.out.persistence.entity;

import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.pt.adapter.out.persistence.entity.Pt;
import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "LESSON")
public class Lesson {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public Long lessonId;

    @ManyToOne
    @JoinColumn(name = "PT_ID")
    private Pt pt;

    @ManyToOne
    @JoinColumn(name = "EMPLOYEE_ID")
    private Employee employee;

    @Column(name = "LESSON_TIME")
    private LocalDateTime lessonDateTime;

    @Column(name = "STATUS")
    private String status;

    public void setPt(Pt pt) {
        this.pt = pt;

        if(!pt.getLessonList().contains(this)) {
            pt.addLesson(this);
        }
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;

        if(!employee.getLessonList().contains(this)) {
            employee.addLesson(this);
        }
    }
}

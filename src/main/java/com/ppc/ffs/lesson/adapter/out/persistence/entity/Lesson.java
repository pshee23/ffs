package com.ppc.ffs.lesson.adapter.out.persistence.entity;

import com.ppc.ffs.employee.adapter.out.persistence.entity.Employee;
import com.ppc.ffs.pt.adapter.out.persistence.entity.Pt;
import lombok.Data;
import lombok.Getter;
import lombok.RequiredArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Data
@Entity
@Table(name = "LESSON")
public class Lesson {

    @Getter
    @RequiredArgsConstructor
    public enum Status { // 예약, 완료, 취소, 노쇼
        RESERVE("예약"),
        DONE("완료"),
       // CANCEL("취소"), //취소는 그냥 삭제하면 될 듯
        NO_SHOW("노쇼");

        private final String text;

        public static Lesson.Status getStatusFromText(String text) {
            for(Status status : Lesson.Status.values()) {
                if(status.getText().equals(text)) {
                    return status;
                }
            }

            return null;
        }
    }

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

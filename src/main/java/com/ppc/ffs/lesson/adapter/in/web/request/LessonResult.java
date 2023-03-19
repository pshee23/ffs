package com.ppc.ffs.lesson.adapter.in.web.request;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.ppc.ffs.common.AbstractResponse;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter @Setter
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class LessonResult extends AbstractResponse {

    private Long lessonId;

    public LessonResult(Long lessonId) {
        this.lessonId  = lessonId;
    }
}

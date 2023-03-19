package com.ppc.ffs.lesson.adapter.in.web.request;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDateTime;

@Getter @Setter
@AllArgsConstructor
public class RegisterLessonRequest {

    @NotBlank
    private Long memberId;

    @NotBlank
    private Long employeeId;

    @NotBlank
    @Pattern(regexp = "^\\d{4}-(0?[1-9]|1[0-2])-(0?[1-9]|[1-2][0-9]|3[0-1])\\s([01][0-9]|2[0-3]):([0-5][0-9]):([0-5][0-9])$")
    private LocalDateTime lessonDateTime;
}

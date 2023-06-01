package changwonNationalUniv.soCool.dto.response;

import changwonNationalUniv.soCool.enums.RehabilitationState;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RehabilitationInfoResponse {
    private Long memberId;

    private String memberName;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate memberBirth;

    private Long rehabilitationInfoId;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime rehabilitationStartTime;

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime rehabilitationEndTime;

    private Integer rehabilitationGoalTime;

    private RehabilitationState rehabilitationState;

    private Float rehabilitationActualTime;

    private Float remainingTime;

    private Float travelRange;

    private Float slope;

    private Float speed;

    private Float consumedCalories;
}

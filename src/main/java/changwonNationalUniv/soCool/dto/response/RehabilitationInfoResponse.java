package changwonNationalUniv.soCool.dto.response;

import changwonNationalUniv.soCool.enums.RehabilitationState;
import lombok.*;

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

    private LocalDate memberBirth;

    private Long rehabilitationInfoId;

    private LocalDateTime rehabilitationStartTime;

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

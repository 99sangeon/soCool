package changwonNationalUniv.soCool.dto;


import changwonNationalUniv.soCool.entity.RehabilitationInfo;
import changwonNationalUniv.soCool.enums.RehabilitationState;
import lombok.*;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RehabilitationInfoRequest {

    private Long memberId;

    private Long rehabilitationInfoId;

    private String rehabilitationStartTime;

    private String rehabilitationEndTime;

    private Integer rehabilitationGoalTime;

    private Float rehabilitationActualTime;

    private Float remainingTime;

    private Float travelRange;

    private Float slope;

    private Float speed;

    private Float consumedCalories;

    public RehabilitationInfo toEntity() {
        return RehabilitationInfo
                .builder()
                .rehabilitationGoalTime(rehabilitationGoalTime)
                .rehabilitationState(RehabilitationState.BEFORE)
                .build();
    }

}

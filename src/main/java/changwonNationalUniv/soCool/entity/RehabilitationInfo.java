package changwonNationalUniv.soCool.entity;

import changwonNationalUniv.soCool.enums.RehabilitationState;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class RehabilitationInfo {

    @Id @GeneratedValue
    @Column(name = "rehabilitation_id")
    private Long id;

    private LocalDateTime rehabilitationStartTime;

    private LocalDateTime rehabilitationEndTime;

    private Integer rehabilitationGoalTime;

    private Float rehabilitationActualTime;

    private Float remainingTime;

    private Float travelRange;

    private Float slope;

    private Float speed;

    private Float consumedCalories;

    @Enumerated(EnumType.STRING)
    private RehabilitationState rehabilitationState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;


    public void setRehabilitationStartTime() {
        this.rehabilitationStartTime = LocalDateTime.now();
    }

    public void setRehabilitationEndTime() {
        this.rehabilitationEndTime = LocalDateTime.now();
    }

    public void setRehabilitationActualTime(Float rehabilitationActualTime) {
        this.rehabilitationActualTime = rehabilitationActualTime;
    }

    public void setRemainingTime(Float remainingTime) {
        this.remainingTime = remainingTime;
    }

    public void setTravelRange(Float travelRange) {
        this.travelRange = travelRange;
    }

    public void setSlope(Float slope) {
        this.slope = slope;
    }

    public void setSpeed(Float speed) {
        this.speed = speed;
    }

    public void setConsumedCalories(Float consumedCalories) {
        this.consumedCalories = consumedCalories;
    }

    public void setRehabilitationState(RehabilitationState rehabilitationState) {
        this.rehabilitationState = rehabilitationState;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}

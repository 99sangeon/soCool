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

    private LocalDateTime breakStartTime;

    private LocalDateTime breakEndTime;

    private LocalDateTime rehabilitationEndTime;

    private Integer rehabilitationGoalTime;

    private Integer rehabilitationActualTime;

    private Float travelRange;

    private Float slope;

    private Float speed;

    private Float consumedCalories;

    @Enumerated(EnumType.STRING)
    private RehabilitationState rehabilitationState;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    public void setMember(Member member) {
        this.member = member;
    }

    public void setRehabilitationStartTime() {
        this.rehabilitationStartTime = LocalDateTime.now();
    }

    public void setRehabilitationEndTime() {
        this.rehabilitationEndTime = LocalDateTime.now();
    }

    public void setBreakStartTime() {
        this.breakStartTime = LocalDateTime.now();
    }

    public void setBreakEndTime() {
        this.breakEndTime = LocalDateTime.now();
    }

    public void setRehabilitationState(RehabilitationState rehabilitationState) {
        this.rehabilitationState = rehabilitationState;
    }
}

package changwonNationalUniv.soCool.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@Getter
@Table
public class RehabilitationInfo {

    @Id @GeneratedValue
    @Column(name = "rehabilitation_id")
    private Long id;

    private LocalDateTime startTime;
    private LocalDateTime endTime;

    private float travelRange;
    private float caloriesConsumed;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member_id")
    private Member member;

    @Builder
    public RehabilitationInfo(LocalDateTime startTime, LocalDateTime endTime) {
        this.startTime = startTime;
        this.endTime = endTime;
    }

    public void setMember(Member member) {
        this.member = member;
    }
}

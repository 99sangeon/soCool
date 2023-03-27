package changwonNationalUniv.soCool.entity;

import lombok.Builder;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@NoArgsConstructor
@Setter
public class BiologicalInfo {

    @Id @GeneratedValue
    @Column(name = "biological_id" )
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "rehabilitation_id")
    private RehabilitationInfo rehabilitationInfo;

    private float pulse;                    //맥박
    private float oxygenSaturation;         //산소포화도
    private float temperature;              //체온

    @Builder
    public BiologicalInfo(float pulse, float oxygenSaturation, float temperature) {
        this.pulse = pulse;
        this.oxygenSaturation = oxygenSaturation;
        this.temperature = temperature;
    }


}

package changwonNationalUniv.soCool.socket.dto;

import changwonNationalUniv.soCool.entity.BiologicalInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class BiologicalInfoRequest {

    private float pulse;                    //맥박
    private float oxygenSaturation;         //산소포화도
    private float temperature;              //체온

    private Long rehabilitationInfoId;

    public BiologicalInfo toEntity() {

        return BiologicalInfo.builder()
                .pulse(pulse)
                .oxygenSaturation(oxygenSaturation)
                .temperature(temperature)
                .build();
    }

    @Builder
    public BiologicalInfoRequest(float pulse, float oxygenSaturation, float temperature, Long rehabilitationInfoId) {
        this.pulse = pulse;
        this.oxygenSaturation = oxygenSaturation;
        this.temperature = temperature;
        this.rehabilitationInfoId = rehabilitationInfoId;
    }
}

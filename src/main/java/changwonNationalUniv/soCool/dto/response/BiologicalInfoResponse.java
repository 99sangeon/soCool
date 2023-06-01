package changwonNationalUniv.soCool.dto.response;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDateTime;

@Getter
@Setter
public class BiologicalInfoResponse {

    private float pulse;                    //맥박
    private float oxygenSaturation;         //산소포화도
    private float temperature;              //체온

    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    private LocalDateTime createData;

    public BiologicalInfoResponse(float pulse, float oxygenSaturation, float temperature, LocalDateTime createData) {
        this.pulse = pulse;
        this.oxygenSaturation = oxygenSaturation;
        this.temperature = temperature;
        this.createData = createData;
    }
}

package changwonNationalUniv.soCool.controller.dto;


import changwonNationalUniv.soCool.entity.RehabilitationInfo;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Arrays;

@Getter
@Setter
public class RehabilitationInfoRequest {

    private String startTime;
    private String endTime;

    private Long memberId;

    public RehabilitationInfo toEntity() {

        int[] startTimeSplit = Arrays.stream(startTime.split("-")).mapToInt(Integer::parseInt).toArray();
        int[] endTimeSplit = Arrays.stream(endTime.split("-")).mapToInt(Integer::parseInt).toArray();

        return RehabilitationInfo.builder()
                .startTime(LocalDateTime.of(startTimeSplit[0], startTimeSplit[1], startTimeSplit[2], startTimeSplit[3], startTimeSplit[4]))
                .endTime(LocalDateTime.of(endTimeSplit[0], endTimeSplit[1], endTimeSplit[2], endTimeSplit[3], endTimeSplit[4]))
                .build();
    }

    @Builder
    public RehabilitationInfoRequest(String startTime, String endTime, Long memberId) {
        this.startTime = startTime;
        this.endTime = endTime;
        this.memberId = memberId;
    }
}

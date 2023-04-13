package changwonNationalUniv.soCool.service;

import changwonNationalUniv.soCool.dto.RehabilitationInfoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;

@SpringBootTest
@Transactional
@Rollback
class RehabilitationInfoServiceTest {

    @Autowired
    RehabilitationInfoService rehabilitationInfoService;

    @Test
    public void save() {
        RehabilitationInfoRequest rehabilitationInfoRequest = RehabilitationInfoRequest.builder()
                .startTime("2023-03-27-15-30")
                .endTime("2023-03-27-16-0")
                .memberId(1L)
                .build();

        rehabilitationInfoService.save(rehabilitationInfoRequest);
    }

}
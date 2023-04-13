package changwonNationalUniv.soCool.service;

import changwonNationalUniv.soCool.dto.BiologicalInfoRequest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;


@SpringBootTest
@Transactional
@Rollback
class BiologicalInfoServiceTest {

    @Autowired
    BiologicalInfoService biologicalInfoService;

    @Test
    public void save() {

        for(int i = 0; i < 100; i++) {
            BiologicalInfoRequest biologicalInfoRequest = BiologicalInfoRequest.builder()
                    .rehabilitationInfoId(2L)
                    .oxygenSaturation((float) i)
                    .pulse((float)i)
                    .temperature((float)i)
                    .build();

            biologicalInfoService.save(biologicalInfoRequest);

        }
    }
}
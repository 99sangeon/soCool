package changwonNationalUniv.soCool.service;


import changwonNationalUniv.soCool.dto.BiologicalInfoRequest;
import changwonNationalUniv.soCool.dto.response.BiologicalInfoResponse;

import java.util.List;

public interface BiologicalInfoService {

    void save(BiologicalInfoRequest biologicalInfoRequest);

    List<BiologicalInfoResponse> findBiologicalInfos(Long rehabilitationInfoId);
}

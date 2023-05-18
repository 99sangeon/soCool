package changwonNationalUniv.soCool.service;

import changwonNationalUniv.soCool.dto.RehabilitationInfoRequest;
import changwonNationalUniv.soCool.entity.RehabilitationInfo;


public interface RehabilitationInfoService {
    RehabilitationInfo findRehabilitationInfo(Long id);
    Long save(RehabilitationInfoRequest rehabilitationInfoRequest);

    void rehabilitationStart(Long rehabilitationInfoId);

    void rehabilitationEnd(RehabilitationInfoRequest rehabilitationInfoRequest);


}

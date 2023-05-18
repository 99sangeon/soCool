package changwonNationalUniv.soCool.service;

import changwonNationalUniv.soCool.dto.RehabilitationInfoRequest;
import changwonNationalUniv.soCool.entity.RehabilitationInfo;


public interface RehabilitationInfoService {
    RehabilitationInfo findRehabilitationInfo(Long id);
    Long save(RehabilitationInfoRequest rehabilitationInfoRequest);

    void setRehabilitationStartTime(Long rehabilitationInfoId);

    void setRehabilitationEndTime(Long rehabilitationInfoId);

    void setBreakStartTime(Long rehabilitationInfoId);

    void setBreakEndTime(Long rehabilitationInfoId);
}

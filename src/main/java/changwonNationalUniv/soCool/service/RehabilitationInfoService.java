package changwonNationalUniv.soCool.service;

import changwonNationalUniv.soCool.controller.dto.RehabilitationInfoRequest;
import changwonNationalUniv.soCool.entity.RehabilitationInfo;


public interface RehabilitationInfoService {
    RehabilitationInfo findRehabilitationInfo(Long id);
    Long save(RehabilitationInfoRequest rehabilitationInfoRequest);
}

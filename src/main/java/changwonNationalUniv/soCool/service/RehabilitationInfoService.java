package changwonNationalUniv.soCool.service;

import changwonNationalUniv.soCool.dto.RehabilitationInfoRequest;
import changwonNationalUniv.soCool.dto.response.RehabilitationInfoResponse;

import java.util.List;


public interface RehabilitationInfoService {
    RehabilitationInfoResponse findRehabilitationInfo(Long id);
    Long save(RehabilitationInfoRequest rehabilitationInfoRequest);

    void rehabilitationStart(Long rehabilitationInfoId);

    void rehabilitationEnd(RehabilitationInfoRequest rehabilitationInfoRequest);

    List<RehabilitationInfoResponse> findRehabilitationInfos();
}

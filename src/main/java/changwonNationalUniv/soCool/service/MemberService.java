package changwonNationalUniv.soCool.service;

import changwonNationalUniv.soCool.dto.MemberRequest;
import changwonNationalUniv.soCool.dto.MemberResponse;

import java.util.List;

public interface MemberService {

    void save(MemberRequest form);
    List<MemberResponse> findAll();
}

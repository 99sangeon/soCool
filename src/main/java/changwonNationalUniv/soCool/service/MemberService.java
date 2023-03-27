package changwonNationalUniv.soCool.service;

import changwonNationalUniv.soCool.controller.dto.MemberRequestDto;
import changwonNationalUniv.soCool.entity.Member;

import java.util.List;

public interface MemberService {

    void save(MemberRequestDto form);
    List<Member> findAll();
}

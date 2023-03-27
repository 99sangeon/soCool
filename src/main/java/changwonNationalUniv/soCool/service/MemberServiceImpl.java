package changwonNationalUniv.soCool.service;

import changwonNationalUniv.soCool.controller.dto.MemberRequestDto;
import changwonNationalUniv.soCool.entity.Member;
import changwonNationalUniv.soCool.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public void save(MemberRequestDto form) {
        memberRepository.save(form.toEntity());
    }

    @Override
    public List<Member> findAll() {
        return memberRepository.findAll();
    }

}

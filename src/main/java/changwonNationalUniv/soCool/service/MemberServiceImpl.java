package changwonNationalUniv.soCool.service;

import changwonNationalUniv.soCool.dto.MemberRequest;

import changwonNationalUniv.soCool.dto.MemberResponse;
import changwonNationalUniv.soCool.entity.Member;
import changwonNationalUniv.soCool.repository.MemberRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@Transactional
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService{

    private final MemberRepository memberRepository;

    @Override
    public void save(MemberRequest form) {
        memberRepository.save(form.toEntity());
    }

    @Override
    public List<MemberResponse> findAll() {

        List<MemberResponse> memberResponses = new ArrayList<>();

        for (Member member : memberRepository.findAll()) {
            memberResponses.add(MemberResponse.of(member));
        }

        return memberResponses;
    }

}

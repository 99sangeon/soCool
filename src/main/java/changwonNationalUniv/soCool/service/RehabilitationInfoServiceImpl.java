package changwonNationalUniv.soCool.service;

import changwonNationalUniv.soCool.controller.dto.RehabilitationInfoRequest;
import changwonNationalUniv.soCool.entity.Member;
import changwonNationalUniv.soCool.entity.RehabilitationInfo;
import changwonNationalUniv.soCool.repository.MemberRepository;
import changwonNationalUniv.soCool.repository.RehabilitationInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Optional;


@RequiredArgsConstructor
@Transactional
@Service
@Slf4j
public class RehabilitationInfoServiceImpl implements RehabilitationInfoService{

    private final RehabilitationInfoRepository rehabilitationInfoRepository;
    private final MemberRepository memberRepository;

    @Override
    public RehabilitationInfo findRehabilitationInfo(Long id) {
        Optional<RehabilitationInfo> rehabilitationInfo = rehabilitationInfoRepository.findById(id);
        if(rehabilitationInfo.isEmpty()) {
            new NoSuchFieldException("해당 재활 번호가 생성되지 않았습니다. 관리자 스마트폰으로 재활정보를 입력해주세요.");
        }

        return rehabilitationInfo.get();
    }

    @Override
    public Long save(RehabilitationInfoRequest rehabilitationInfoRequest) {
        Long memberId = rehabilitationInfoRequest.getMemberId();
        Optional<Member> member = memberRepository.findById(memberId);

        if(member.isEmpty()) {
            new NoSuchFieldException("해당 사용자를 찾을 수 없습니다. 다시한번 확인 해 주세요.");
        }

        RehabilitationInfo rehabilitationInfo = rehabilitationInfoRequest.toEntity();
        rehabilitationInfo.setMember(member.get());

        return rehabilitationInfoRepository.save(rehabilitationInfo).getId();
    }
}

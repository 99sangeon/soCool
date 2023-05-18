package changwonNationalUniv.soCool.service;

import changwonNationalUniv.soCool.dto.RehabilitationInfoRequest;
import changwonNationalUniv.soCool.entity.Member;
import changwonNationalUniv.soCool.entity.RehabilitationInfo;
import changwonNationalUniv.soCool.enums.RehabilitationState;
import changwonNationalUniv.soCool.repository.MemberRepository;
import changwonNationalUniv.soCool.repository.RehabilitationInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.NoSuchElementException;
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

        Member member = memberRepository.findById(rehabilitationInfoRequest.getMemberId())
                .orElseThrow(() -> new NoSuchElementException());


        RehabilitationInfo rehabilitationInfo = rehabilitationInfoRequest.toEntity();
        rehabilitationInfo.setMember(member);

        return rehabilitationInfoRepository.save(rehabilitationInfo).getId();
    }

    @Override
    public void setRehabilitationStartTime(Long rehabilitationInfoId) {

        RehabilitationInfo rehabilitationInfo
                = rehabilitationInfoRepository
                .findById(rehabilitationInfoId).orElseThrow(() -> new NoSuchElementException());

        rehabilitationInfo.setRehabilitationStartTime();
        rehabilitationInfo.setRehabilitationState(RehabilitationState.ING);

    }

    @Override
    public void setRehabilitationEndTime(Long rehabilitationInfoId) {
        RehabilitationInfo rehabilitationInfo
                = rehabilitationInfoRepository
                .findById(rehabilitationInfoId).orElseThrow(() -> new NoSuchElementException());

        rehabilitationInfo.setRehabilitationEndTime();
    }

    @Override
    public void setBreakStartTime(Long rehabilitationInfoId) {
        RehabilitationInfo rehabilitationInfo
                = rehabilitationInfoRepository
                .findById(rehabilitationInfoId).orElseThrow(() -> new NoSuchElementException());

        rehabilitationInfo.setBreakStartTime();
    }

    @Override
    public void setBreakEndTime(Long rehabilitationInfoId) {
        RehabilitationInfo rehabilitationInfo
                = rehabilitationInfoRepository
                .findById(rehabilitationInfoId).orElseThrow(() -> new NoSuchElementException());

        rehabilitationInfo.setBreakEndTime();
    }
}

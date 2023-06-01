package changwonNationalUniv.soCool.service;

import changwonNationalUniv.soCool.dto.RehabilitationInfoRequest;
import changwonNationalUniv.soCool.dto.response.RehabilitationInfoResponse;
import changwonNationalUniv.soCool.entity.Member;
import changwonNationalUniv.soCool.entity.RehabilitationInfo;
import changwonNationalUniv.soCool.enums.RehabilitationState;
import changwonNationalUniv.soCool.repository.MemberRepository;
import changwonNationalUniv.soCool.repository.RehabilitationInfoRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
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
    public RehabilitationInfoResponse findRehabilitationInfo(Long rehabilitationInfoId) {

        RehabilitationInfo rehabilitationInfo = rehabilitationInfoRepository.findById(rehabilitationInfoId).orElseThrow(() -> new NoSuchElementException());

        return RehabilitationInfoResponse
                .builder()
                .memberId(rehabilitationInfo.getMember().getId())
                .memberName(rehabilitationInfo.getMember().getName())
                .memberBirth(rehabilitationInfo.getMember().getBirth())
                .rehabilitationInfoId(rehabilitationInfo.getId())
                .rehabilitationStartTime(rehabilitationInfo.getRehabilitationStartTime())
                .rehabilitationEndTime(rehabilitationInfo.getRehabilitationEndTime())
                .rehabilitationGoalTime(rehabilitationInfo.getRehabilitationGoalTime())
                .rehabilitationState(rehabilitationInfo.getRehabilitationState())
                .rehabilitationActualTime(rehabilitationInfo.getRehabilitationActualTime())
                .remainingTime(rehabilitationInfo.getRemainingTime())
                .travelRange(rehabilitationInfo.getTravelRange())
                .slope(rehabilitationInfo.getSlope())
                .speed(rehabilitationInfo.getSpeed())
                .consumedCalories(rehabilitationInfo.getConsumedCalories())
                .build();
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
    public void rehabilitationStart(Long rehabilitationInfoId) {

        RehabilitationInfo rehabilitationInfo
                = rehabilitationInfoRepository
                .findById(rehabilitationInfoId).orElseThrow(() -> new NoSuchElementException());

        rehabilitationInfo.setRehabilitationStartTime();
        rehabilitationInfo.setRehabilitationState(RehabilitationState.ING);

    }

    @Override
    public void rehabilitationEnd(RehabilitationInfoRequest rehabilitationInfoRequest) {

        RehabilitationInfo rehabilitationInfo =
                rehabilitationInfoRepository
                .findById(rehabilitationInfoRequest.getRehabilitationInfoId()).orElseThrow(() -> new NoSuchElementException());

        Member member = rehabilitationInfo.getMember();

        setRehabilitationEndInfo(rehabilitationInfoRequest, rehabilitationInfo, member);
    }


    private void setRehabilitationEndInfo(RehabilitationInfoRequest rehabilitationInfoRequest, RehabilitationInfo rehabilitationInfo, Member member) {

        rehabilitationInfo.setRehabilitationEndTime();
        rehabilitationInfo.setRehabilitationState(RehabilitationState.AFTER);
        rehabilitationInfo.setRemainingTime(rehabilitationInfoRequest.getRemainingTime());
        rehabilitationInfo.setTravelRange(rehabilitationInfoRequest.getTravelRange());
        rehabilitationInfo.setSlope(rehabilitationInfoRequest.getSlope());

        rehabilitationInfo.setRehabilitationActualTime(rehabilitationInfo.getRehabilitationGoalTime() - rehabilitationInfoRequest.getRemainingTime());
        rehabilitationInfo.setSpeed(rehabilitationInfoRequest.getTravelRange()/rehabilitationInfo.getRehabilitationActualTime());
        rehabilitationInfo.setConsumedCalories(
                calculationConsumedCalories(
                        rehabilitationInfo.getSpeed(),
                        rehabilitationInfo.getSlope(),
                        rehabilitationInfo.getRehabilitationActualTime(),
                        member.getWeight()));
    }

    private Float calculationConsumedCalories(Float speed, Float slope, Float rehabilitationActualTime, Float weight) {

        float vo2 = (float) (3.5 + (0.1 * speed) + (1.8 * speed * slope));
        float consumedCalories = (vo2 * weight / 200);

        return consumedCalories;
    }

    @Override
    public List<RehabilitationInfoResponse> findRehabilitationInfos() {

        List<RehabilitationInfo> rehabilitationInfos = rehabilitationInfoRepository.findAllWithMember();
        List<RehabilitationInfoResponse> responses = new ArrayList<>();

        for (RehabilitationInfo rehabilitationInfo: rehabilitationInfos) {

            RehabilitationInfoResponse response = RehabilitationInfoResponse
                    .builder()
                    .rehabilitationInfoId(rehabilitationInfo.getId())
                    .memberId(rehabilitationInfo.getMember().getId())
                    .memberName(rehabilitationInfo.getMember().getName())
                    .memberBirth(rehabilitationInfo.getMember().getBirth())
                    .rehabilitationStartTime(rehabilitationInfo.getRehabilitationStartTime())
                    .rehabilitationState(rehabilitationInfo.getRehabilitationState())
                    .build();

            responses.add(response);
        }

        return responses;
    }
}

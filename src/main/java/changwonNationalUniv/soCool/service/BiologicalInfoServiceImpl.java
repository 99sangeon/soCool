package changwonNationalUniv.soCool.service;

import changwonNationalUniv.soCool.entity.BiologicalInfo;
import changwonNationalUniv.soCool.entity.RehabilitationInfo;
import changwonNationalUniv.soCool.repository.BiologicalInfoRepository;
import changwonNationalUniv.soCool.repository.RehabilitationInfoRepository;
import changwonNationalUniv.soCool.socket.dto.BiologicalInfoRequest;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class BiologicalInfoServiceImpl implements BiologicalInfoService{

    private final BiologicalInfoRepository biologicalInfoRepository;
    private final RehabilitationInfoRepository rehabilitationInfoRepository;

    @Override
    public void save(BiologicalInfoRequest biologicalInfoRequest) {
        Long id = biologicalInfoRequest.getRehabilitationInfoId();
        Optional<RehabilitationInfo> rehabilitationInfo = rehabilitationInfoRepository.findById(id);

        if(rehabilitationInfo.isEmpty()) {
            new NoSuchElementException("재활정보 다시 세팅!");
        }

        BiologicalInfo biologicalInfo = biologicalInfoRequest.toEntity();
        biologicalInfo.setRehabilitationInfo(rehabilitationInfo.get());

        biologicalInfoRepository.save(biologicalInfo);
    }
}

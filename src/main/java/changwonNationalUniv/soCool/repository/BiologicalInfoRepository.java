package changwonNationalUniv.soCool.repository;

import changwonNationalUniv.soCool.dto.response.BiologicalInfoResponse;
import changwonNationalUniv.soCool.entity.BiologicalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface BiologicalInfoRepository extends JpaRepository<BiologicalInfo, Long> {

    @Query("SELECT new changwonNationalUniv.soCool.dto.response.BiologicalInfoResponse(b.pulse, b.oxygenSaturation, b.temperature, b.createDate) " +
            "FROM BiologicalInfo b " +
            "WHERE b.rehabilitationInfo.id=:rehabilitationInfoId " +
            "ORDER BY b.id")
    List<BiologicalInfoResponse> findByRehabilitationInfoId(Long rehabilitationInfoId);
}

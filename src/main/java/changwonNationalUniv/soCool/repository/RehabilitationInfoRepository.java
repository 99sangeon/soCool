package changwonNationalUniv.soCool.repository;

import changwonNationalUniv.soCool.entity.RehabilitationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RehabilitationInfoRepository extends JpaRepository<RehabilitationInfo, Long>{
}

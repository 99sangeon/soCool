package changwonNationalUniv.soCool.repository;

import changwonNationalUniv.soCool.entity.BiologicalInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BiologicalInfoRepository extends JpaRepository<BiologicalInfo, Long> {
}

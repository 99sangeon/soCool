package changwonNationalUniv.soCool.repository;

import changwonNationalUniv.soCool.entity.RehabilitationInfo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RehabilitationInfoRepository extends JpaRepository<RehabilitationInfo, Long>{

    @Query("SELECT r FROM RehabilitationInfo r JOIN FETCH  r.member")
    List<RehabilitationInfo> findAllWithMember();
}

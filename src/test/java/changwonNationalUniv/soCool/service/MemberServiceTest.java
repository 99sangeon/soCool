package changwonNationalUniv.soCool.service;


import changwonNationalUniv.soCool.entity.Gender;
import changwonNationalUniv.soCool.entity.Member;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;

import javax.transaction.Transactional;
import java.time.LocalDate;


@SpringBootTest
@Transactional
@Rollback
class MemberServiceTest {

    @Autowired
    private MemberService memberService;

    @Test
    public void save() {
        Member member = Member.builder()
                .name("전상언")
                .birth(LocalDate.of(1999,10,19))
                .age(25)
                .gender(Gender.MALE)
                .weight((float)178.2)
                .height((float)78.5)
                .build();

        //memberService.save(member);
    }


}
package changwonNationalUniv.soCool.controller.dto;

import changwonNationalUniv.soCool.entity.Gender;
import changwonNationalUniv.soCool.entity.Member;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
public class MemberRequestDto {

    @NotEmpty(message = "이름은 필수항목입니다.")
    @Length(min = 0, max = 30, message = "이름은 30글자 이내로 입력해주세요.")
    private String name;

    @NotNull(message = "나이는 필수항목입니다.")
    private int age;

    @NotNull(message = "생년월일은 필수항목입니다.")
    private String birth;

    @NotNull(message = "키는 필수항목입니다.")
    private float height;

    @NotNull(message = "몸무게는 필수항목입니다.")
    private float weight;

    @NotEmpty(message = "성별은 필수항목입니다.")
    private Gender gender;

    @NotEmpty(message = "전화번호는 필수항목입니다.")
    private String mobile;

    public Member toEntity() {
        String[] bir = birth.split("-");

        return Member.builder()
                .name(name)
                .age(age)
                .birth(LocalDate.of(Integer.valueOf(bir[0]), Integer.valueOf(bir[1]) ,Integer.valueOf(bir[2])))
                .height(height)
                .weight(weight)
                .gender(gender)
                .mobile(mobile)
                .build();
    }

}

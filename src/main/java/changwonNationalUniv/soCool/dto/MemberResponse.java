package changwonNationalUniv.soCool.dto;

import changwonNationalUniv.soCool.entity.Gender;
import changwonNationalUniv.soCool.entity.Member;
import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class MemberResponse {

    private Long id;

    private String name;

    private Integer age;

    private LocalDate birth;

    private Float height;

    private Float weight;

    private Gender gender;

    private String mobile;

    public static MemberResponse of(Member member) {
        return MemberResponse
                .builder()
                .id(member.getId())
                .name(member.getName())
                .age(member.getAge())
                .birth(member.getBirth())
                .height(member.getHeight())
                .weight(member.getWeight())
                .gender(member.getGender())
                .mobile(member.getMobile())
                .build();
    }
}

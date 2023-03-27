package changwonNationalUniv.soCool.entity;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.time.LocalDate;

@Getter
@Setter
@Entity
@NoArgsConstructor
public class Member {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String name;

    private int age;

    private LocalDate birth;

    private float height;

    private float weight;

    private String mobile;

    @Enumerated(EnumType.STRING)
    private Gender gender;

    @Embedded
    private Time time = new Time();

    @Builder
    public Member(String name, int age, LocalDate birth, float height, float weight, Gender gender, String mobile) {
        this.name = name;
        this.age = age;
        this.birth = birth;
        this.height = height;
        this.weight = weight;
        this.gender = gender;
        this.mobile = mobile;
    }
}

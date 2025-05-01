package umc.spring.domain.mapping;

import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Store;
import umc.spring.domain.common.BaseEntity;
import umc.spring.domain.enums.MissionStatus;

@Entity
@Getter
@Builder
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@AllArgsConstructor
public class MemberMission extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private MissionStatus status;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "mission")
    private Mission mission ;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "member")
    private Member member;

    @Override
    public String toString() {
        return "MemberMission{" +
                "id=" + id +
                ", status='" + status + '\'' +
                ", member=" + (member != null ? member.getName() : "null") +
                ", mission=" + (mission != null ? mission.getMissionSpec() : "null") +
                '}';
    }

}

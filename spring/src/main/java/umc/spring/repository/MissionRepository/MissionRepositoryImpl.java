package umc.spring.repository.MissionRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.QMemberMission;
import umc.spring.domain.QMission;
import umc.spring.domain.QStore;

import java.util.List;

@RequiredArgsConstructor
public class MissionRepositoryImpl implements MissionRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QMission mission = QMission.mission;
    private final QStore store = QStore.store;
    private final QMemberMission memberMission = QMemberMission.memberMission;

    @Override
    public List<Mission> findMissionsByStatusAndMember(Long memberId, MissionStatus status, int offset, int limit) {
        return queryFactory
                .selectFrom(mission)
                .join(mission.store, store).fetchJoin()
                .join(memberMission).on(memberMission.mission.id.eq(mission.id))
                .where(
                        memberMission.member.id.eq(memberId),
                        memberMission.status.eq(status)
                )
                .offset(offset)
                .limit(limit)
                .fetch();
    }

    @Override
    public List<Mission> findMissionsByRegionBeforeCursor(Long regionId, LocalDateTime cursorTime, int limit) {
        return queryFactory
                .selectFrom(mission)
                .join(mission.store, store).fetchJoin()
                .where(
                        store.region.id.eq(regionId),
                        mission.updatedAt.lt(cursorTime)
                )
                .orderBy(mission.updatedAt.desc())
                .limit(limit)
                .fetch();
    }


}

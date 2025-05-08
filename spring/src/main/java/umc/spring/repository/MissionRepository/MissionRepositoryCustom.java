package umc.spring.repository.MissionRepository;

import java.time.LocalDateTime;
import umc.spring.domain.Mission;

import java.util.List;
import umc.spring.domain.enums.MissionStatus;

public interface MissionRepositoryCustom {
    List<Mission> findMissionsByStatusAndMember(Long memberId, MissionStatus status, int offset, int limit);
    List<Mission> findMissionsByRegionBeforeCursor(Long regionId, LocalDateTime cursorTime, int limit);


}


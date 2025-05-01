package umc.spring.service.MissionService;

import java.time.LocalDateTime;
import umc.spring.domain.Mission;

import java.util.List;
import umc.spring.domain.enums.MissionStatus;

public interface MissionQueryService {
    List<Mission> getMissionsByStatusAndMember(Long memberId, MissionStatus status, int offset, int limit);
    List<Mission> getMissionsByRegionBeforeCursor(Long regionId, LocalDateTime cursorTime, int limit);

}


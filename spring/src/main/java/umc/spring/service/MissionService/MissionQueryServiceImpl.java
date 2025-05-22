package umc.spring.service.MissionService;

import java.time.LocalDateTime;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.apiPayload.code.status.ErrorStatus;
import umc.spring.apiPayload.exception.handler.MemberHandler;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.repository.MissionRepository.MissionRepository;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class MissionQueryServiceImpl implements MissionQueryService {

    private final MissionRepository missionRepository;

    @Override
    public List<Mission> getMissionsByStatusAndMember(Long memberId, MissionStatus status, int offset, int limit) {
        return missionRepository.findMissionsByStatusAndMember(memberId, status, offset, limit);
    }

    @Override
    public List<Mission> getMissionsByRegionBeforeCursor(Long regionId, LocalDateTime cursorTime, int limit) {
        return missionRepository.findMissionsByRegionBeforeCursor(regionId, cursorTime, limit);
    }


}


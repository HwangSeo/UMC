package umc.spring.service.MissionService;

import java.time.LocalDateTime;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.Mission;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.repository.MissionRepository.MissionRepository;

import java.util.List;

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


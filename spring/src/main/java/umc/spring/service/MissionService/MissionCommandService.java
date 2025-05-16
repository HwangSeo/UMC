package umc.spring.service.MissionService;

import umc.spring.web.dto.MissionRequestDTO.CreateMission;

public interface MissionCommandService {
    void createMission(Long storeId, CreateMission request);
    void challengeMission(Long missionId);
}


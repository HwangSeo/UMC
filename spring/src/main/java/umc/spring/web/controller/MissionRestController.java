package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.MissionService.MissionCommandService;
import umc.spring.validation.annotation.NotAlreadyChallenging;
import umc.spring.web.dto.MissionRequestDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/api/v1/stores")
public class MissionRestController {

    private final MissionCommandService missionCommandService;
    private final MissionCommandService missionChallengeService;


    @PostMapping("/{storeId}/missions")
    public ApiResponse<String> createMission(@PathVariable Long storeId,
                                             @RequestBody @Valid MissionRequestDTO.CreateMission request) {
        missionCommandService.createMission(storeId, request);
        return ApiResponse.onSuccess("미션 등록 완료");
    }

    @PostMapping("/{missionId}/challenge")
    public ApiResponse<String> challengeMission(@PathVariable @NotAlreadyChallenging Long missionId) {
        missionChallengeService.challengeMission(missionId);
        return ApiResponse.onSuccess("미션 도전 완료");
    }
}


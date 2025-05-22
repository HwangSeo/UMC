package umc.spring.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.MemberService.MemberCommandService;
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
    private final MemberCommandService memberCommandService;


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
    @PatchMapping("/{memberId}/missions/{memberMissionId}/complete")
    @Operation(summary = "도전 중인 미션을 완료 처리하는 API")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION_4001", description = "존재하지 않는 미션입니다."),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "MISSION_4002", description = "이미 완료된 미션입니다.")
    })
    public ApiResponse<String> completeMission(
            @PathVariable Long memberId,
            @PathVariable Long memberMissionId) {

        memberCommandService.completeMission(memberId, memberMissionId);
        return ApiResponse.onSuccess("미션 완료 처리 성공");
    }

}


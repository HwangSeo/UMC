package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.StoreService.StoreCommandService;
import umc.spring.web.dto.StoreRequestDTO.CreateStore;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/regions")
public class StoreRestController {

    private final StoreCommandService storeCommandService;

    @PostMapping("/{regionId}/stores")
    public ApiResponse<String> createStore(@PathVariable Long regionId,
                                           @RequestBody @Valid CreateStore request) {
        storeCommandService.createStore(regionId, request);
        return ApiResponse.onSuccess("가게 등록 완료");
    }
}


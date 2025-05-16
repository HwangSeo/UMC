package umc.spring.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import umc.spring.apiPayload.ApiResponse;
import umc.spring.service.ReviewService.ReviewCommandService;
import umc.spring.web.dto.ReviewRequestDTO.CreateReview;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/stores")
public class ReviewRestController {

    private final ReviewCommandService reviewCommandService;

    @PostMapping("/{storeId}/reviews")
    public ApiResponse<String> createReview(@PathVariable Long storeId,
                                            @RequestBody @Valid CreateReview request) {
        reviewCommandService.createReview(storeId, request);
        return ApiResponse.onSuccess("리뷰 등록 완료");
    }
}


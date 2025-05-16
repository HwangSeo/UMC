package umc.spring.service.ReviewService;

import umc.spring.domain.Review;
import umc.spring.web.dto.ReviewRequestDTO.CreateReview;

public interface ReviewCommandService {
    Review createReview(Long storeId, CreateReview request);
}


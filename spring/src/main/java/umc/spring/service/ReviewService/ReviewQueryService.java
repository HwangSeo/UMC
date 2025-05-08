package umc.spring.service.ReviewService;

import umc.spring.domain.Review;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewQueryService {
    List<Review> getReviewsBeforeCursor(Long storeId, LocalDateTime cursorTime, int limit);
}


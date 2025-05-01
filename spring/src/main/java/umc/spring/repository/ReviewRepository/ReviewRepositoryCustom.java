package umc.spring.repository.ReviewRepository;

import umc.spring.domain.Review;

import java.time.LocalDateTime;
import java.util.List;

public interface ReviewRepositoryCustom {
    List<Review> findReviewsByStoreIdBeforeCursor(Long storeId, LocalDateTime cursorTime, int limit);
}

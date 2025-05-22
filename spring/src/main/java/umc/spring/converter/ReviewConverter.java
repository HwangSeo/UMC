package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequestDTO;
import umc.spring.web.dto.StoreResponseDTO;

// ReviewConverter.java
public class ReviewConverter {

    public static Review toReview(ReviewRequestDTO.CreateReview request, Member member, Store store) {
        return Review.builder()
                .score(request.getScore())
                .title(request.getTitle())
                .member(member)
                .store(store)
                .build();
    }
    public static StoreResponseDTO.CreateReviewResultDTO toCreateReviewResultDTO(Review review) {
        return StoreResponseDTO.CreateReviewResultDTO.builder()
                .reviewId(review.getId())
                .title(review.getTitle())
                .score(review.getScore())
                .storeId(review.getStore().getId())
                .memberId(review.getMember().getId())
                .createdAt(review.getCreatedAt())
                .build();
    }

}


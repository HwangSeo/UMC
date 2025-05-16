package umc.spring.converter;

import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.web.dto.ReviewRequestDTO;

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
}


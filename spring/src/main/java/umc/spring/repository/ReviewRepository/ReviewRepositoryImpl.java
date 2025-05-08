package umc.spring.repository.ReviewRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.QMember;
import umc.spring.domain.QReview;
import umc.spring.domain.Review;

import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public class ReviewRepositoryImpl implements ReviewRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QReview review = QReview.review;
    private final QMember member = QMember.member;

    @Override
    public List<Review> findReviewsByStoreIdBeforeCursor(Long storeId, LocalDateTime cursorTime, int limit) {
        return queryFactory
                .selectFrom(review)
                .join(review.member, member).fetchJoin()
                .where(
                        review.store.id.eq(storeId),
                        review.createdAt.lt(cursorTime)
                )
                .orderBy(review.createdAt.desc())
                .limit(limit)
                .fetch();
    }
}

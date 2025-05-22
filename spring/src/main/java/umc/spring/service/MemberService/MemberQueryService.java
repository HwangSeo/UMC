package umc.spring.service.MemberService;

import org.springframework.data.domain.Page;
import umc.spring.domain.Member;

import java.util.Optional;
import umc.spring.domain.Review;

public interface MemberQueryService {
    Optional<Member> getMemberInfo(Long memberId);

    Page<Review> getMyReviews(Long memberId, int page);
}

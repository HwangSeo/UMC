package umc.spring.service.MemberService;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;

public interface MemberQueryService {
    Optional<Member> getMemberInfo(Long memberId);
    Page<Review> getMyReviews(Long memberId, int page);
    List<Mission> getMissionsByRegionBeforeCursor(Long regionId, LocalDateTime cursorTime, int limit);

    Page<MemberMission> getChallengingMissions(Long memberId, int page);

}

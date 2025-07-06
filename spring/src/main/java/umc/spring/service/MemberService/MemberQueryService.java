package umc.spring.service.MemberService;

import jakarta.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Review;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberResponseDTO;

public interface MemberQueryService {
    Optional<Member> getMemberInfo(Long memberId);
    Page<Review> getMyReviews(Long memberId, int page);
    List<Mission> getMissionsByRegionBeforeCursor(Long regionId, LocalDateTime cursorTime, int limit);

    Page<MemberMission> getChallengingMissions(Long memberId, int page);
    MemberResponseDTO.MemberInfoDTO getMemberInfo(HttpServletRequest request);
}

package umc.spring.service.MemberService;

import jakarta.transaction.Transactional;
import umc.spring.domain.Member;
import umc.spring.web.dto.MemberRequestDTO;

public interface MemberCommandService {
    @Transactional
    Member joinMember(MemberRequestDTO.JoinDto request);
}

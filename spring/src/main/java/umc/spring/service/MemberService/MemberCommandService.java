package umc.spring.service.MemberService;

import jakarta.transaction.Transactional;
import umc.spring.domain.Member;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;

public interface MemberCommandService {
    @Transactional
    Member joinMember(MemberRequestDTO.JoinDto request);
    void completeMission(Long memberId, Long memberMissionId);
    MemberResponseDTO.LoginResultDTO loginMember(MemberRequestDTO.LoginRequestDTO request);

}

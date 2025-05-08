package umc.spring.repository.MemberRepository;

import umc.spring.domain.Member;

import java.util.Optional;

public interface MemberRepositoryCustom {
    Optional<Member> findMemberInfo(Long memberId);
}


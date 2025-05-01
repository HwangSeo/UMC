package umc.spring.repository.MemberRepository;

import com.querydsl.jpa.impl.JPAQueryFactory;
import lombok.RequiredArgsConstructor;
import umc.spring.domain.Member;
import umc.spring.domain.QMember;

import java.util.Optional;

@RequiredArgsConstructor
public class MemberRepositoryImpl implements MemberRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private final QMember member = QMember.member;

    @Override
    public Optional<Member> findMemberInfo(Long memberId) {
        return Optional.ofNullable(
                queryFactory
                        .selectFrom(member)
                        .where(member.id.eq(memberId))
                        .fetchOne()
        );
    }
}

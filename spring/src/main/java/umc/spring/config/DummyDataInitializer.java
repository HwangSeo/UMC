package umc.spring.config;

import jakarta.persistence.EntityManager;
import lombok.RequiredArgsConstructor;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.*;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;

@Component
@RequiredArgsConstructor
public class DummyDataInitializer implements CommandLineRunner {

    private final EntityManager em;

    @Override
    @Transactional
    public void run(String... args) throws Exception {
        // ▶ 1. Region 생성
        Region seoul = Region.builder().name("서울").build();
        em.persist(seoul);

        // ▶ 2. Store 생성
        Store store = Store.builder()
                .name("요아정")
                .address("서울시 강남구")
                .score(4.5f)
                .region(seoul)
                .build();
        em.persist(store);

        // ▶ 3. Member 생성
        Member member = Member.builder()
                .name("홍길동")
                .email("hong@example.com")
                .address("서울시 마포구")
                .specAddress("서울시 마포구 백범로 1")
                .point(100)
                .build();
        em.persist(member);

        // ▶ 4. Mission 생성
        Mission mission = Mission.builder()
                .missionSpec("요아정 첫 방문 미션")
                .reward(3000)
                .store(store)
                .build();
        em.persist(mission);

        // ▶ 5. MemberMission 생성
        MemberMission mm = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
        em.persist(mm);

        // ▶ 6. Review 생성
        Review review = Review.builder()
                .title("맛있어요!")
                .score(5.0f)
                .store(store)
                .member(member)
                .build();
        em.persist(review);

        em.flush(); // 변경 사항 강제 반영

        System.out.println("✅ 더미 데이터 삽입 완료");
    }
}


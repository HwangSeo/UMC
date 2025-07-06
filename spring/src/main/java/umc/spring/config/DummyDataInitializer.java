package umc.spring.config;

import jakarta.persistence.EntityManager;
import org.springframework.boot.CommandLineRunner;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import umc.spring.domain.*;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.enums.Role;
import umc.spring.domain.enums.SocialType;
import umc.spring.domain.mapping.MemberMission;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class DummyDataInitializer implements CommandLineRunner {

    private final EntityManager em;
    private final PasswordEncoder passwordEncoder;

    public DummyDataInitializer(EntityManager em, PasswordEncoder passwordEncoder) {
        this.em = em;
        this.passwordEncoder = passwordEncoder;
    }

    @Transactional
    @Override
    public void run(String... args) throws Exception {
        // ✅ 1. Region
        Region seoul = Region.builder().name("서울").build();
        em.persist(seoul);

        // ✅ 2. Store
        Store store = Store.builder()
                .name("요아정")
                .address("서울시 강남구")
                .score(4.5F)
                .region(seoul)
                .build();
        em.persist(store);

        // ✅ 3. Member (비밀번호 포함)
        String encodedPassword = passwordEncoder.encode("abc1234");
        Member member = Member.builder()
                .name("홍길동")
                .email("hong@example.com")
                .address("서울시 마포구")
                .specAddress("서울시 마포구 백범로 1")
                .password(encodedPassword)
                .point(100)
                .role(Role.USER)
                .socialType(SocialType.KAKAO)
                .build();
        em.persist(member);

        // ✅ 4. Mission
        Mission mission = Mission.builder()
                .missionSpec("요아정 첫 방문 미션")
                .reward(3000)
                .store(store)
                .build();
        em.persist(mission);

        // ✅ 5. MemberMission
        MemberMission mm = MemberMission.builder()
                .member(member)
                .mission(mission)
                .status(MissionStatus.CHALLENGING)
                .build();
        em.persist(mm);

        // ✅ 6. Review
        Review review = Review.builder()
                .title("맛있어요!")
                .score(5.0F)
                .store(store)
                .member(member)
                .build();
        em.persist(review);

        // ✅ 7. FoodCategory (중복 방지용 SELECT 먼저 해도 됨)
        List<String> categoryNames = List.of(
                "양식", "일식", "한식", "치킨", "분식",
                "고기/구이", "도시락", "야식(족발, 보쌈)",
                "패스트푸드", "디저트", "아시안푸드"
        );
        List<FoodCategory> categories = categoryNames.stream()
                .map(name -> FoodCategory.builder().name(name).build())
                .collect(Collectors.toList());
        categories.forEach(em::persist);

        em.flush();

        System.out.println("✅ 더미 데이터 + 음식 카테고리 + 암호화된 비밀번호 삽입 완료");
    }
}

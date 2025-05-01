package umc.spring;

import jakarta.persistence.EntityManager;
import java.time.LocalDateTime;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.domain.Member;
import umc.spring.domain.Mission;
import umc.spring.domain.Region;
import umc.spring.domain.Review;
import umc.spring.domain.Store;
import umc.spring.domain.enums.MissionStatus;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.service.MemberService.MemberQueryService;
import umc.spring.service.MissionService.MissionQueryService;
import umc.spring.service.ReviewService.ReviewQueryService;
import umc.spring.service.StoreService.StoreQueryService;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}
	@Bean
	public CommandLineRunner storeQueryTest(ApplicationContext context) {
		return args -> {
			StoreQueryService storeService = context.getBean(StoreQueryService.class);
			String name = "요아정";
			Float score = 4.0f;
			System.out.println("🟢 Store Query: name=" + name + ", score=" + score);
			storeService.findStoresByNameAndScore(name, score)
					.forEach(System.out::println);
		};
	}

	@Bean
	public CommandLineRunner missionQueryTest(ApplicationContext context) {
		return args -> {
			MissionQueryService missionQueryService = context.getBean(MissionQueryService.class);
			Long memberId = 1L;
			MissionStatus status = MissionStatus.CHALLENGING;
			System.out.println("🟢 Mission Query: memberId=" + memberId + ", status=" + status);
			missionQueryService.getMissionsByStatusAndMember(memberId, status, 0, 10)
					.forEach(System.out::println);
		};
	}

	@Bean
	public CommandLineRunner reviewQueryTest(ApplicationContext context) {
		return args -> {
			ReviewQueryService reviewQueryService = context.getBean(ReviewQueryService.class);
			Long storeId = 1L;
			System.out.println("🟢 Review Query: storeId=" + storeId);
			reviewQueryService.getReviewsBeforeCursor(storeId, LocalDateTime.now(), 5)
					.forEach(System.out::println);
		};
	}

	@Bean
	public CommandLineRunner memberQueryTest(ApplicationContext context) {
		return args -> {
			MemberQueryService memberQueryService = context.getBean(MemberQueryService.class);
			Long memberId = 1L;
			System.out.println("🟢 Member Query: memberId=" + memberId);
			memberQueryService.getMemberInfo(memberId)
					.ifPresentOrElse(
							System.out::println,
							() -> System.out.println("❌ Member not found.")
					);
		};
	}

}

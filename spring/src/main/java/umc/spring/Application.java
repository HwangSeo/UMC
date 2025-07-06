package umc.spring;

import java.util.List;
import java.util.stream.Collectors;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import umc.spring.domain.FoodCategory;
import umc.spring.repository.FoodCategoryRepository.FoodCategoryRepository;

@SpringBootApplication
@EnableJpaAuditing
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}


	@Bean
	public CommandLineRunner foodCategoryInitializer(FoodCategoryRepository foodCategoryRepository) {
		return args -> {
			if (foodCategoryRepository.count() == 0) {
				List<String> categoryNames = List.of(
						"양식", "일식", "한식", "치킨", "분식",
						"고기/구이", "도시락", "야식(족발, 보쌈)",
						"패스트푸드", "디저트", "아시안푸드"
				);

				List<FoodCategory> categories = categoryNames.stream()
						.map(name -> FoodCategory.builder().name(name).build())
						.collect(Collectors.toList());

				foodCategoryRepository.saveAll(categories);
				System.out.println("✅ 음식 카테고리 초기 데이터가 삽입되었습니다.");
			} else {
				System.out.println("ℹ️ 음식 카테고리가 이미 존재합니다.");
			}
		};
	}

}

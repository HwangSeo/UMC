package umc.spring.service.FoodCaterotyService;

import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import umc.spring.repository.FoodCategoryRepository.FoodCategoryRepository;

@Service
@RequiredArgsConstructor
public class FoodCategoryService {

    private final FoodCategoryRepository foodCategoryRepository;

    public boolean existAllByIds(List<Integer> ids) {
        return ids.stream().allMatch(foodCategoryRepository::existsById);
    }
}


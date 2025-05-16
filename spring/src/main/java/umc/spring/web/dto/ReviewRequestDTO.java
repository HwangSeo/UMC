package umc.spring.web.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Getter;
import lombok.Setter;

public class ReviewRequestDTO {

    @Getter
    @Setter
    public static class CreateReview {

        @NotNull(message = "평점은 필수입니다.")
        @Min(1) @Max(5)
        private Float score;

        @NotBlank(message = "내용은 비어있을 수 없습니다.")
        private String title;

    }
}


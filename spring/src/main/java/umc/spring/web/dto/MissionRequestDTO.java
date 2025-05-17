package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import java.time.LocalDate;
import lombok.Getter;
import lombok.Setter;

public class MissionRequestDTO {

    @Getter
    @Setter
    public static class CreateMission {

        @NotBlank(message = "미션명은 필수입니다.")
        private String title;

        @NotNull(message = "마감일은 필수입니다.")
        private LocalDate deadLine;

        @NotNull(message = "보상은 필수입니다.")
        private Integer reward;
    }
}

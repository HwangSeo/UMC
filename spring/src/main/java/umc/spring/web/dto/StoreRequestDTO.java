package umc.spring.web.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

public class StoreRequestDTO {

    @Getter
    @Setter
    public static class CreateStore {

        @NotBlank(message = "가게 이름은 필수입니다.")
        private String name;

        @NotBlank(message = "주소는 필수입니다.")
        private String address;
    }
}


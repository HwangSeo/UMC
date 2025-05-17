package umc.spring.apiPayload.exception.handler;


import lombok.Getter;
import umc.spring.apiPayload.code.BaseErrorCode;
import umc.spring.apiPayload.exception.GeneralException;

@Getter
public class FoodCategoryHandler extends GeneralException {


    public FoodCategoryHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}

package umc.spring.validation.validator;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;
import umc.spring.repository.MissionRepository.MemberMissionRepository;
import umc.spring.validation.annotation.NotAlreadyChallenging;

@Component
@RequiredArgsConstructor
public class NotAlreadyChallengingValidator implements ConstraintValidator<NotAlreadyChallenging, Long> {

    private final MemberMissionRepository memberMissionRepository;

    @Override
    public boolean isValid(Long missionId, ConstraintValidatorContext context) {
        Long memberId = 1L; // 하드코딩된 유저
        boolean exists = memberMissionRepository.existsByMember_IdAndMission_Id(memberId, missionId);
        System.out.println("🔥 [Validator] missionId = " + missionId + ", exists = " + exists);
        return !exists;
    }
}


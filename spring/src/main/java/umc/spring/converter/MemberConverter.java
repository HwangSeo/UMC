package umc.spring.converter;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import org.springframework.data.domain.Page;
import umc.spring.domain.Member;
import umc.spring.domain.Review;
import umc.spring.domain.enums.Gender;
import umc.spring.domain.mapping.MemberMission;
import umc.spring.web.dto.MemberRequestDTO;
import umc.spring.web.dto.MemberResponseDTO;
import umc.spring.web.dto.MemberResponseDTO.ChallengingMissionDTO;
import umc.spring.web.dto.MemberResponseDTO.ChallengingMissionListDTO;
import umc.spring.web.dto.MemberResponseDTO.ReviewPreviewDTO;
import umc.spring.web.dto.MemberResponseDTO.ReviewPreviewListDTO;

public class MemberConverter {

    public static MemberResponseDTO.JoinResultDTO toJoinResultDTO(Member member){
        return MemberResponseDTO.JoinResultDTO.builder()
                .memberId(member.getId())
                .createdAt(LocalDateTime.now())
                .build();
    }

    public static Member toMember(MemberRequestDTO.JoinDto request){

        Gender gender = null;

        switch (request.getGender()){
            case 1:
                gender = Gender.MALE;
                break;
            case 2:
                gender = Gender.FEMALE;
                break;
            case 3:
                gender = Gender.NONE;
                break;
        }

        return Member.builder()
                .address(request.getAddress())
                .specAddress(request.getSpecAddress())
                .gender(gender)
                .name(request.getName())
                .memberPreferList(new ArrayList<>())
                .email(request.getEmail())
                .build();
    }

    public static ReviewPreviewDTO toReviewPreviewDTO(Review review) {
        return ReviewPreviewDTO.builder()
                .storeName(review.getStore().getName())
                .body(review.getTitle())
                .score(review.getScore())
                .createdAt(review.getCreatedAt().toLocalDate())
                .build();
    }

    public static ReviewPreviewListDTO toReviewPreviewListDTO(Page<Review> reviews) {
        List<ReviewPreviewDTO> list = reviews.stream()
                .map(MemberConverter::toReviewPreviewDTO)
                .collect(Collectors.toList());

        return ReviewPreviewListDTO.builder()
                .reviewList(list)
                .listSize(list.size())
                .totalPage(reviews.getTotalPages())
                .totalElements(reviews.getTotalElements())
                .isFirst(reviews.isFirst())
                .isLast(reviews.isLast())
                .build();
    }
    public static ChallengingMissionDTO toChallengingMissionDTO(MemberMission mm) {
        return ChallengingMissionDTO.builder()
                .missionSpec(mm.getMission().getMissionSpec())
                .reward(mm.getMission().getReward())
                .deadline(mm.getMission().getDeadline())
                .storeName(mm.getMission().getStore().getName())
                .build();
    }

    public static ChallengingMissionListDTO toChallengingMissionListDTO(Page<MemberMission> missionPage) {
        List<ChallengingMissionDTO> missionList = missionPage.stream()
                .map(MemberConverter::toChallengingMissionDTO)
                .collect(Collectors.toList());

        return ChallengingMissionListDTO.builder()
                .missionList(missionList)
                .listSize(missionList.size())
                .totalPage(missionPage.getTotalPages())
                .totalElements(missionPage.getTotalElements())
                .isFirst(missionPage.isFirst())
                .isLast(missionPage.isLast())
                .build();
    }

}

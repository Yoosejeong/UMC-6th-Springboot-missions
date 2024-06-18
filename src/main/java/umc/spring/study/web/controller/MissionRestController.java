package umc.spring.study.web.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.UserMissionConverter;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.service.UserMissionCommandService;
import umc.spring.study.validation.annotation.ExistMission;
import umc.spring.study.validation.annotation.ExistUser;
import umc.spring.study.web.dto.UserRequestDTO;
import umc.spring.study.web.dto.UserResponseDTO;

@RestController
@Validated
@RequiredArgsConstructor
@RequestMapping("/missions")
public class MissionRestController {

   private final UserMissionCommandService userMissionCommandService;

    @PostMapping("/{userId}")
    public ApiResponse<UserResponseDTO.UserMissionResultDTO> createUserMission(@RequestBody @Valid UserRequestDTO.UserMissionDTO request,
                                                                               @PathVariable (name = "userId") @ExistUser Long userId,
                                                                               @RequestParam(name = "missionId") @ExistMission Long missionId) {
        UserMission userMission = userMissionCommandService.createUserMission(request, userId, missionId);
        return ApiResponse.onSuccess(UserMissionConverter.toUserMissionResultDTO(userMission));
    }
}

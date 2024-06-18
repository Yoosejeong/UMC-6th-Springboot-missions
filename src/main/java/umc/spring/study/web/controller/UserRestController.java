package umc.spring.study.web.controller;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.Parameters;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import umc.spring.study.apiPayload.ApiResponse;
import umc.spring.study.converter.StoreConverter;
import umc.spring.study.converter.UserConverter;
import umc.spring.study.converter.UserMissionConverter;
import umc.spring.study.domain.Review;
import umc.spring.study.domain.User;
import umc.spring.study.domain.mapping.UserMission;
import umc.spring.study.service.UserCommandService;
import umc.spring.study.service.UserMissionQueryService;
import umc.spring.study.service.UserQueryService;
import umc.spring.study.validation.annotation.CheckPage;
import umc.spring.study.validation.annotation.ExistUser;
import umc.spring.study.web.dto.UserRequestDTO;
import umc.spring.study.web.dto.UserResponseDTO;

@RestController
@RequiredArgsConstructor
@Validated
@RequestMapping("/users")
public class UserRestController {

    private final UserCommandService userCommandService;

    private final UserQueryService userQueryService;

    private final UserMissionQueryService userMissionQueryService;

    @PostMapping("/")
    public ApiResponse<UserResponseDTO.JoinResultDTO> join(@RequestBody @Valid UserRequestDTO.JoinDTO request) {
        User user = userCommandService.joinUser(request);
        return ApiResponse.onSuccess(UserConverter.toJoinResultDTO(user));
    }

    @GetMapping("/{userId}/reviews")
    @Operation(summary = "특정 회원의 리뷰 목록 조회 API",description = "특정 회원의 리뷰들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "회원의 아이디, path variable 입니다!")
    })
    public ApiResponse<UserResponseDTO.UserReviewListDTO> getReviewList(@ExistUser @PathVariable(name="userId") Long userId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<Review> reviewList = userQueryService.getReviewList(userId,page-1);;
        return ApiResponse.onSuccess(UserConverter.userReviewListDTO(reviewList));
    }

    @GetMapping("/{userId}/missions/challenging")
    @Operation(summary = "특정 회원의 진행중인 미션 목록 조회 API",description = "특정 회원의 진행중인 미션들의 목록을 조회하는 API이며, 페이징을 포함합니다. query String 으로 page 번호를 주세요")
    @ApiResponses({
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "COMMON200",description = "OK, 성공"),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH003", description = "access 토큰을 주세요!",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH004", description = "acess 토큰 만료",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
            @io.swagger.v3.oas.annotations.responses.ApiResponse(responseCode = "AUTH006", description = "acess 토큰 모양이 이상함",content = @Content(schema = @Schema(implementation = ApiResponse.class))),
    })
    @Parameters({
            @Parameter(name = "userId", description = "회원의 아이디, path variable 입니다!")
    })
    public ApiResponse<UserResponseDTO.UserMissionListDTO> getMissionList(@ExistUser @PathVariable(name="userId") Long userId, @CheckPage @RequestParam(name = "page") Integer page){
        Page<UserMission> missionList = userMissionQueryService.getMissionList(userId,page-1);;
        return ApiResponse.onSuccess(UserMissionConverter.userMissionListDTO(missionList));
    }
}

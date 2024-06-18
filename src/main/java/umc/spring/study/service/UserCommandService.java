package umc.spring.study.service;


import umc.spring.study.domain.User;
import umc.spring.study.web.dto.UserRequestDTO;


public interface UserCommandService {
    User joinUser(UserRequestDTO.JoinDTO request);
}

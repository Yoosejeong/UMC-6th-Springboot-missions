package umc.spring.study.service;

import org.springframework.stereotype.Repository;
import umc.spring.study.domain.User;
import umc.spring.study.web.dto.UserRequestDTO;


public interface UserCommandService {
    User joinUser(UserRequestDTO.JoinDTO request);
}

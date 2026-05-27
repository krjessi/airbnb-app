package com.jm.projects.airBnbApp.service;

import com.jm.projects.airBnbApp.dto.ProfileUpdateRequestDto;
import com.jm.projects.airBnbApp.dto.UserDto;
import com.jm.projects.airBnbApp.entity.User;

public interface UserService {

    User getUserById(Long id);

    void updateProfile(ProfileUpdateRequestDto profileUpdateRequestDto);

    UserDto getMyProfile();
}

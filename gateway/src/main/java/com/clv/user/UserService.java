package com.clv.user;

import com.clv.user.dto.UserDto;

import java.util.List;

public interface UserService {

    List<UserDto> findAllUsers();

    UserDto findUserById(int id);
}

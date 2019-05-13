package com.example.bell.service;

import com.example.bell.view.*;
import com.example.bell.view.User.SaveUserInfo;
import com.example.bell.view.User.UpdateUserInfo;
import com.example.bell.view.User.UserFilter;
import com.example.bell.view.User.UserView;

import java.util.List;

public interface UserService {

    List<UserView> list(UserFilter filter);

    UserView getUserById(Long id);

    ResultView updateUser(UpdateUserInfo info);

    ResultView saveUser(SaveUserInfo info);
}

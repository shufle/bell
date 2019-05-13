package com.example.bell.service.impl;

import com.example.bell.service.UserService;
import com.example.bell.view.*;
import com.example.bell.view.User.SaveUserInfo;
import com.example.bell.view.User.UpdateUserInfo;
import com.example.bell.view.User.UserFilter;
import com.example.bell.view.User.UserView;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Override
    public List<UserView> list(UserFilter filter) {
        return null;
    }

    @Override
    public UserView getUserById(Long id) {
        return null;
    }

    @Override
    public ResultView updateUser(UpdateUserInfo info) {
        return null;
    }

    @Override
    public ResultView saveUser(SaveUserInfo info) {
        return null;
    }


}

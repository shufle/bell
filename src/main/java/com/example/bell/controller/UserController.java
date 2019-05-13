package com.example.bell.controller;

import com.example.bell.service.UserService;
import com.example.bell.view.*;
import com.example.bell.view.User.SaveUserInfo;
import com.example.bell.view.User.UpdateUserInfo;
import com.example.bell.view.User.UserFilter;
import com.example.bell.view.User.UserView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

@RestController
@RequestMapping(value = "api/user", produces = APPLICATION_JSON_VALUE)
public class UserController {

    private UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping(value = {"/list"}, method = RequestMethod.POST)
    public List<UserView> getOfficeByFilter(@RequestBody UserFilter filter) {return userService.list(filter);}

    @RequestMapping(value = "/{id:[\\d]+}", method = RequestMethod.GET)
    public UserView getUser(@PathVariable("id") long orgId) {
        return userService.getUserById(orgId);
    }

    @RequestMapping(value = {"/update"}, method = RequestMethod.POST)
    public ResultView updateUser(@RequestBody UpdateUserInfo info) {return userService.updateUser(info);}

    @RequestMapping(value = {"/save"}, method = RequestMethod.POST)
    public ResultView userOrganization(@RequestBody SaveUserInfo info) {return userService.saveUser(info);}
}

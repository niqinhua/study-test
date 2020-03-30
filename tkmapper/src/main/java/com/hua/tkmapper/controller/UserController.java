package com.hua.tkmapper.controller;

import com.github.pagehelper.PageInfo;
import com.hua.tkmapper.pojo.User;
import com.hua.tkmapper.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author 倪勤华
 * @date 2020-03-04 20:09
 */
@RestController
@RequestMapping("/user")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/page")
    public PageInfo<User> findUserList(int page, int size) {
        return userService.findUserList(page, size);
    }
}

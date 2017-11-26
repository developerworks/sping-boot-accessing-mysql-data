package cn.totorotec.controller;

import cn.totorotec.service.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    @Resource
    private UserService userService;


}

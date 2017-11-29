package cn.totorotec.controller;

import cn.totorotec.service.db.UserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(path = "/user")
public class UserController {
    private UserService userService;
}

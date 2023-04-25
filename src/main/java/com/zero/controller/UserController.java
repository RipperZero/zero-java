package com.zero.controller;

import com.zero.pojo.JsonResult;
import com.zero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @RequestMapping("findAll")
    @ResponseBody
    private JsonResult findAll() {
        return JsonResult.success(this.userService.findAll());
    }
}

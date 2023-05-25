package com.zero.controller;

import com.zero.pojo.JsonResult;
import com.zero.pojo.User;
import com.zero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@CrossOrigin
@RestController
@RequestMapping("/")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("findAllUser")
    @ResponseBody
    private JsonResult findAll() {
        return JsonResult.SUCCESS(this.userService.findAllUsers());
    }


    @GetMapping("findUsersByPager")
    @ResponseBody
    private JsonResult findUsersByPager(@RequestParam int pageNum, @RequestParam int pageSize) {
        return JsonResult.SUCCESS(this.userService.findUsersByPager(pageNum, pageSize));
    }

    @GetMapping("isUserExist")
    @ResponseBody
    private JsonResult isUserExist(@RequestParam String username) {
        return JsonResult.SUCCESS(this.userService.isUserExist(username));
    }

    @PostMapping("registerUser")
    @ResponseBody
    private JsonResult registerUser(@RequestBody User user) {
        return JsonResult.SUCCESS("register success", this.userService.saveUser(user));
    }
}

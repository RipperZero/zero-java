package com.zero.controller;

import com.zero.pojo.JsonResult;
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
        return JsonResult.success(this.userService.findAllUsers());
    }


    @GetMapping("findUsersByPager")
    @ResponseBody
    private JsonResult findUsersByPager(@RequestParam int pageNum, @RequestParam int pageSize) {
        return JsonResult.success(this.userService.findUsersByPager(pageNum, pageSize));
    }

    @GetMapping("isUserExist")
    @ResponseBody
    private JsonResult isUserExist(@RequestParam String username) {
        return JsonResult.success(this.userService.isUserExist(username));
    }
}

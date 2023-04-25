package com.zero.service.impl;

import com.zero.mapper.UserMapper;
import com.zero.pojo.User;
import com.zero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> findAll() {
        return this.userMapper.findAll();
    }
}

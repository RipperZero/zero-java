package com.zero.service.impl;

import com.zero.mapper.UserMapper;
import com.zero.pojo.Pager;
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
    public List<User> findAllUsers() {
        return this.userMapper.findAllUsers();
    }

    @Override
    public Pager<User> findUsersByPager(int pageNum, int pageSize) {
        Pager pager = new Pager();
        pager.setPage(pageNum).setSize(pageSize);

        List<User> userList = this.userMapper.findUsersByPager(pager.getOffset(), pager.getSize());
        int userNum = this.userMapper.countUser();

        pager.setResults(userList).setTotal(userNum);

        return pager;
    }

    @Override
    public Boolean isUserExist(String username) {
        User userInfo = this.userMapper.findUserByName(username);

        return userInfo != null;
    }
}

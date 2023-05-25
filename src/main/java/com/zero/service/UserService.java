package com.zero.service;

import com.zero.pojo.Pager;
import com.zero.pojo.User;

import java.util.List;

public interface UserService {
    List<User> findAllUsers();

    Pager<User> findUsersByPager(int pageNum, int pageSize);

    Boolean isUserExist(String username);

    Integer saveUser(User user);
}

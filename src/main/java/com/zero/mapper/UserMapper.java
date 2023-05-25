package com.zero.mapper;

import com.zero.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.util.List;

@Mapper
public interface UserMapper {
    List<User> findAllUsers();

    int countUser();

    List<User> findUsersByPager(@Param("offset") int offset, @Param("pageSize") int pageSize);

    User findUserByName(String username);

    int saveUser(User user);
}

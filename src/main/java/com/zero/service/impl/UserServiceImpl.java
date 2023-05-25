package com.zero.service.impl;

import cn.hutool.core.util.IdUtil;
import cn.hutool.crypto.digest.Digester;
import com.zero.mapper.UserMapper;
import com.zero.pojo.Pager;
import com.zero.pojo.User;
import com.zero.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
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

    @Override
    public Integer saveUser(User user) {
        String salt = IdUtil.randomUUID();
        String hexPassWordWithSalt = this.convertPassWord(user.getPassword(), salt);

        Date currentTime = new Date();

        user.setPassword(hexPassWordWithSalt).setSalt(salt).setCreatedUser(user.getUsername())
                .setModifiedUser(user.getCreatedUser()).setValid(1).setCreatedTime(currentTime)
                .setModifiedTime(currentTime);

        return this.userMapper.saveUser(user);

//        if (this.userMapper.saveUser(user) > 0) {
//            // 手动添加IdCard以及Mobile
//            String tempIdCard = new StringBuilder().append("610102xxxxxxxx00").append(user.getId()).toString();
//            user.setIdcard(tempIdCard).setMobile("152xxxxxxxx");
//            if (this.userMapper.updateUser(user) > 0) {
//                return 1;
//            }
//        }
//
//        return 0;
    }

    /**
     * @param password
     * @param salt
     * @return hexPassWordWithSalt
     */
    private String convertPassWord(String password, String salt) {
        // 此处使用HuTool
        // 密码加密(本次算法使用md5加密->特点：不可逆，相同内容加密结果一定相同)
        Digester md5Digester = new Digester("MD5");
        // 设置加盐内容
        md5Digester.setSalt(salt.getBytes());
        // 此处需要注意 入库密码为加盐密码 作为后续验证的依据(必须给密码加盐！！！)
        // 默认加密次数为1次
        String hexPassWordWithSalt = md5Digester.digestHex(password);

        return hexPassWordWithSalt;
    }
}

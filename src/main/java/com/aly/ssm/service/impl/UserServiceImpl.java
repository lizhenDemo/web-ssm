package com.aly.ssm.service.impl;

import com.aly.ssm.mapper.UserMapper;
import com.aly.ssm.model.User;
import com.aly.ssm.model.UserDTO;
import com.aly.ssm.service.UserService;
import com.aly.ssm.util.model.commonLog;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by lizhen on 2017/7/6.
 */
@Service
public class UserServiceImpl extends commonLog implements UserService {
    @Autowired
    private UserMapper userMapper;


    public List<UserDTO> find(User user) {
        return userMapper.find(user);
    }

    @Transactional(rollbackFor = {Exception.class, RuntimeException.class})
    public int save(User user) {
        userMapper.save(user);
        return user.getId();
    }

    @Transactional(noRollbackFor = {Exception.class, RuntimeException.class})
    public void createCore(List<User> list) throws Exception {
        userMapper.createCore(list);
        throw new Exception("注释");
    }

    public User findById(Integer id) {
        return userMapper.findById(id);
    }
}

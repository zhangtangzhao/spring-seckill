package com.seckill.service;

import com.seckill.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

@Service("userService")
public class UserServiceImpl implements UserService{

    @Resource
    private UserMapper userMapper;

    @Override
    public String getName(Long id) {
        return userMapper.getName(id);
    }
}

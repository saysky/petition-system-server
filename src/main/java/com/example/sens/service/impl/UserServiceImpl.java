package com.example.sens.service.impl;

import com.baomidou.mybatisplus.plugins.Page;
import com.baomidou.mybatisplus.plugins.pagination.Pagination;
import com.example.sens.mapper.ReportMapper;
import com.example.sens.mapper.UserMapper;
import com.example.sens.entity.User;
import com.example.sens.service.UserService;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.HashMap;
import java.util.Map;

/**
 * <pre>
 *     用户业务逻辑实现类
 * </pre>
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired(required = false)
    private UserMapper userMapper;

    @Autowired
    private ReportMapper reportMapper;

    @Override
    public void saveByUser(User user) {
        if (user != null && user.getId() != null) {
            userMapper.updateById(user);
        } else {
            userMapper.insert(user);
        }
    }

    @Override
    public User findByUserName(String userName) {
        User param = new User();
        param.setName(userName);
        return userMapper.selectOne(param);
    }

    @Override
    public User findByPhone(String phone) {
        User param = new User();
        param.setPhone(phone);
        return userMapper.selectOne(param);
    }

    @Override
    public User findByCard(String card) {
        User param = new User();
        param.setCard(card);
        return userMapper.selectOne(param);
    }

    @Override
    public User findByEmail(String email) {
        User param = new User();
        param.setEmail(email);
        return userMapper.selectOne(param);
    }

    @Override
    public User findByUserId(Long userId) {
        return userMapper.selectById(userId);
    }


    @Override
    @Transactional(rollbackFor = Exception.class)
    public void removeUser(Long userId) {


        userMapper.deleteById(userId);

        Map<String, Object> map = new HashMap<>();
        map.put("user_id", userId);
        reportMapper.deleteByMap(map);
    }

    @Override
    public Page<User> findAll(String keywords, String type, Page<User> page) {
        return page.setRecords(userMapper.findByKeywords(keywords, type, page));
    }

}

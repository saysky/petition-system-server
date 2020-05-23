package com.example.sens.service;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.sens.entity.User;


/**
 * <pre>
 *     用户业务逻辑接口
 * </pre>
 */
public interface UserService {

    /**
     * 新增/修改用户
     *
     * @param user user
     * @return Role
     */
    void saveByUser(User user);

    /**
     * 根据用户名获得用户
     *
     * @param userName 用户名
     * @return 用户
     */
    User findByUserName(String userName);

    User findByPhone(String phone);

    User findByCard(String card);

    User findByEmail(String email);


    /**
     * 根据用户Id获得用户
     *
     * @param userId 用户名
     * @return 用户
     */
    User findByUserId(Long userId);

    /**
     * 删除用户
     *
     * @param userId 用户Id
     */
    void removeUser(Long userId);


    /**
     * 分页获取用户
     *
     * @param page 分页
     * @return 分页数据
     */
    Page<User> findAll(String keywords, String type, Page<User> page);

}

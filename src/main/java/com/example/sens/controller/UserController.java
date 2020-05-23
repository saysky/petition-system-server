package com.example.sens.controller;

import com.baomidou.mybatisplus.plugins.Page;
import com.example.sens.config.annotation.SystemLog;
import com.example.sens.entity.Report;
import com.example.sens.entity.User;
import com.example.sens.enums.LogTypeEnum;
import com.example.sens.enums.UserType;
import com.example.sens.service.UserService;
import com.example.sens.util.Response;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.Date;
import java.util.Objects;

/**
 * @author 言曌
 * @date 2019-05-08 13:10
 */

@RestController
@RequestMapping("/api/user")
public class UserController {


    @Autowired
    private UserService userService;


    @PostMapping(value = "/login", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SystemLog(type = LogTypeEnum.LOGIN)
    public Response login(@RequestBody User user,
                          HttpSession session) {
        User u = userService.findByUserName(user.getName());
        if (u == null || UserType.ADMIN.getValue().equals(u.getType())) {
            return Response.no("用户名不存在！");
        }
        if (!Objects.equals(u.getPassword(), user.getPassword())) {
            return Response.no("密码不正确！");
        }
        session.setAttribute("session_userId", u.getId());
        session.setAttribute("session_username", u.getName());
        session.setAttribute("session_user", u);
        return Response.yes("登录成功", u);
    }

    @PostMapping(value = "/adminLogin", consumes = MediaType.APPLICATION_JSON_UTF8_VALUE)
    @SystemLog(type = LogTypeEnum.ADMIN_LOGIN)
    public Response adminLogin(@RequestBody User user,
                               HttpSession session) {
        User u = userService.findByUserName(user.getName());
        if (u == null || !UserType.ADMIN.getValue().equals(u.getType())) {
            return Response.no("用户名不存在！");
        }
        if (!Objects.equals(u.getPassword(), user.getPassword())) {
            return Response.no("密码不正确！");
        }
        session.setAttribute("session_userId", u.getId());
        session.setAttribute("session_username", u.getName());
        session.setAttribute("session_user", u);
        return Response.yes("登录成功", u);
    }

    @PostMapping("/register")
    @SystemLog(type = LogTypeEnum.REGISTER)
    public Response register(@RequestBody User user) {
        User checkName = userService.findByUserName(user.getName());
        if (checkName != null) {
            return Response.no("用户名已注册！");
        }

        User checkPhone = userService.findByPhone(user.getPhone());
        if (checkPhone != null) {
            return Response.no("手机号已注册！");
        }

        User checkEmail = userService.findByEmail(user.getEmail());
        if (checkEmail != null) {
            return Response.no("电子邮箱已注册！");
        }

        User checkCard = userService.findByCard(user.getCard());
        if (checkCard != null) {
            return Response.no("身份证已注册！");
        }

        user.setId(null);
        user.setCreateTime(new Date());
        user.setType(UserType.USER.getValue());
        userService.saveByUser(user);
        return Response.yes("注册成功", user);
    }


    @GetMapping("/logout")
    public Response logout(HttpSession session) {
        session.removeAttribute("session_user");
        session.removeAttribute("session_userId");
        session.removeAttribute("session_username");
        return Response.yes();
    }

    @GetMapping("/current")
    public Response login(HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return Response.no("用户未登录");
        }
        return Response.yes(user);
    }

    @PostMapping("/profile/save")
    @SystemLog(type = LogTypeEnum.UPDATE_PROFILE)
    public Response addUser(@RequestBody User userParam, HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return Response.no("用户未登录");
        }
        userParam.setId(user.getId());

        User checkName = userService.findByUserName(userParam.getName());
        if (checkName != null && !Objects.equals(checkName.getId(), user.getId())) {
            return Response.no("用户名已注册！");
        }

        User checkPhone = userService.findByPhone(userParam.getPhone());
        if (checkPhone != null && !Objects.equals(checkPhone.getId(), user.getId())) {
            return Response.no("手机号已注册！");
        }

        User checkEmail = userService.findByEmail(userParam.getEmail());
        if (checkEmail != null && !Objects.equals(checkEmail.getId(), user.getId())) {
            return Response.no("电子邮箱已注册！");
        }

        User checkCard = userService.findByCard(userParam.getCard());
        if (checkCard != null && !Objects.equals(checkCard.getId(), user.getId())) {
            return Response.no("身份证已注册！");
        }


        try {
            userService.saveByUser(userParam);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.no();
        }

        session.setAttribute("session_userId", userParam.getId());
        session.setAttribute("session_username", userParam.getName());
        session.setAttribute("session_user", userParam);
        return Response.yes("保存成功", null);
    }

    @PostMapping("/profile/changePass")
    @SystemLog(type = LogTypeEnum.UPDATE_PASSWORD)
    public Response changePass(@RequestBody User userParam, HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return Response.no("用户未登录");
        }
        userParam.setId(user.getId());
        if (StringUtils.isEmpty(userParam.getPassword())) {
            return Response.no("密码不能为空");
        }

        try {
            userService.saveByUser(userParam);
        } catch (Exception e) {
            e.printStackTrace();
            return Response.no();
        }
        return Response.yes("保存成功", null);
    }


    /**
     * 分页列表
     *
     * @param pageNo
     * @param pageSize
     * @return
     */
    @GetMapping("/paging")
    public Response<Page<Report>> paging(@RequestParam(value = "keywords", required = false, defaultValue = "") String keywords,
                                         @RequestParam(value = "type", required = false, defaultValue = "") String type,
                                         @RequestParam(value = "pageNo", required = false, defaultValue = "1") Integer pageNo,
                                         @RequestParam(value = "pageSize", required = false, defaultValue = "10") Integer pageSize,
                                         HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return Response.no("请先登录");
        }
        if (!Objects.equals(user.getType(), UserType.ADMIN.getValue())) {
            return Response.no("没有权限");
        }
        Page pageable = new Page(pageNo, pageSize);
        Page<Report> page = userService.findAll(keywords, type, pageable);
        return Response.yes(page);
    }

    /**
     * 审查用户
     *
     * @param id
     * @return
     */
    @PostMapping("/delete")
    @SystemLog(type = LogTypeEnum.DELETE_USER)
    public Response<Boolean> deleteReport(@RequestParam("id") Long id,
                                          HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return Response.no("请先登录");
        }
        if (!Objects.equals(user.getType(), UserType.ADMIN.getValue())) {
            return Response.no("没有权限");
        }

        User u = userService.findByUserId(id);
        if (u == null) {
            return Response.no("用户不存在");
        }
        if (UserType.ADMIN.getValue().equals(u.getType())) {
            return Response.no("不能删除管理员");
        }

        userService.removeUser(id);
        return Response.yes(true);
    }

    @GetMapping("/details")
    public Response details(@RequestParam("id") Long id, HttpSession session) {
        User user = (User) session.getAttribute("session_user");
        if (user == null) {
            return Response.no("用户未登录");
        }
        if (!Objects.equals(user.getType(), UserType.ADMIN.getValue())) {
            return Response.no("没有权限");
        }
        User u = userService.findByUserId(id);
        return Response.yes(u);
    }

    @PostMapping("/create")
    @SystemLog(type = LogTypeEnum.ADD_USER)
    public Response create(@RequestBody User user) {
        User checkName = userService.findByUserName(user.getName());
        if (checkName != null) {
            return Response.no("用户名已注册！");
        }

        User checkPhone = userService.findByPhone(user.getPhone());
        if (checkPhone != null) {
            return Response.no("手机号已注册！");
        }

        User checkEmail = userService.findByEmail(user.getEmail());
        if (checkEmail != null) {
            return Response.no("电子邮箱已注册！");
        }

        User checkCard = userService.findByCard(user.getCard());
        if (checkCard != null) {
            return Response.no("身份证已注册！");
        }

        user.setId(null);
        user.setCreateTime(new Date());
        userService.saveByUser(user);
        return Response.yes("注册成功", user);
    }

    @PostMapping("/update")
    @SystemLog(type = LogTypeEnum.UPDATE_USER)
    public Response update(@RequestBody User user) {
        if(user.getId() == null) {
            return create(user);
        }

        User checkName = userService.findByUserName(user.getName());
        if (checkName != null && !Objects.equals(user.getId(), checkName.getId())) {
            return Response.no("用户名已注册！");
        }

        User checkPhone = userService.findByPhone(user.getPhone());
        if (checkPhone != null && !Objects.equals(user.getId(), checkPhone.getId())) {
            return Response.no("手机号已注册！");
        }

        User checkEmail = userService.findByEmail(user.getEmail());
        if (checkEmail != null && !Objects.equals(user.getId(), checkEmail.getId())) {
            return Response.no("电子邮箱已注册！");
        }

        User checkCard = userService.findByCard(user.getCard());
        if (checkCard != null && !Objects.equals(user.getId(), checkCard.getId())) {
            return Response.no("身份证已注册！");
        }

        userService.saveByUser(user);
        return Response.yes("更新成功", user);
    }
}

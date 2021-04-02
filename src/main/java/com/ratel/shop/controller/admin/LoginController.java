package com.ratel.shop.controller.admin;

import cn.hutool.core.util.StrUtil;
import com.ratel.shop.common.ServiceResultEnum;
import com.ratel.shop.entity.User;
import com.ratel.shop.service.UserService;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
public class LoginController {

    @Resource
    private UserService userService;

    @GetMapping({"", "/"})
    public String login() {
        return "admin/login";
    }

    @GetMapping({"/index", "/index.html"})
    public String index(HttpServletRequest request) {
        request.setAttribute("path", "index");
        return "admin/index";
    }

    @PostMapping(value = "/login")
    public String login(@RequestParam("userName") String userName,
                        @RequestParam("password") String password,
                        @RequestParam("verifyCode") String verifyCode,
                        HttpSession session) {
        if (StrUtil.isBlank(userName) || StrUtil.isBlank(password)) {
            session.setAttribute("errorMsg", "用户名或密码不能为空");
            return "admin/login";
        }
        if (StrUtil.isBlank(verifyCode)) {
            session.setAttribute("errorMsg", "验证码不能为空");
            return "admin/login";
        }
        String kaptchaCode = session.getAttribute("verifyCode") + "";
        if (StrUtil.isBlank(kaptchaCode) || !verifyCode.equals(kaptchaCode)) {
            session.setAttribute("errorMsg", "验证码错误");
            return "admin/login";
        }
        User user = userService.login(userName, password);
        if (user != null) {
            session.setAttribute("nickName", user.getNickName());
            session.setAttribute("userId", user.getId());
            return "admin/index";
        } else {
            session.setAttribute("errorMsg", "登陆失败，请联系管理员");
            return "admin/login";
        }
    }

    @GetMapping("/profile")
    public String profile(HttpServletRequest request) {
        Long userId = (Long) request.getSession().getAttribute("userId");
        User user = userService.queryUserById(userId);
        if (user == null) {
            return "admin/login";
        }
        request.setAttribute("path", "profile");
        request.setAttribute("userName", user.getUserName());
        request.setAttribute("nickName", user.getNickName());
        return "admin/profile";
    }

    @PostMapping("/profile/password")
    @ResponseBody
    public String passwordUpdate(HttpServletRequest request, @RequestParam("originalPassword") String originalPassword,
                                 @RequestParam("newPassword") String newPassword) {
        if (StrUtil.isBlank(originalPassword) || StrUtil.isBlank(newPassword)) {
            return "参数不能为空";
        }
        Long userId = (Long) request.getSession().getAttribute("userId");
        if (userService.updatePassword(userId, originalPassword, newPassword)) {
            request.getSession().removeAttribute("userId");
            request.getSession().removeAttribute("nickName");
            request.getSession().removeAttribute("errorMsg");
            return ServiceResultEnum.SUCCESS.getResult();
        } else {
            return "修改失败";
        }
    }

    @PostMapping("/profile/name")
    @ResponseBody
    public String nameUpdate(HttpServletRequest request, @RequestParam("userName") String userName,
                             @RequestParam("nickName") String nickName) {
        if (StrUtil.isBlank(userName) || StrUtil.isBlank(nickName)) {
            return "参数不能为空";
        }
        Long userId = (Long) request.getSession().getAttribute("userId");
        if (userService.updateName(userId, userName, nickName)) {
            return ServiceResultEnum.SUCCESS.getResult();
        } else {
            return "修改失败";
        }
    }

    @GetMapping("/logout")
    public String logout(HttpServletRequest request) {
        request.getSession().removeAttribute("userId");
        request.getSession().removeAttribute("nickName");
        request.getSession().removeAttribute("errorMsg");
        return "admin/login";
    }
}

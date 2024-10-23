package com.example.mvcdemo.controllers;

import com.example.mvcdemo.dao.UserDao;
import com.example.mvcdemo.mybeans.User;
import com.example.mvcdemo.myexceptions.InvalidInputException;
import jakarta.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class UserController {
    @RequestMapping("/login.do")
    public String login(Model model) {
        // 设置默认值为空字符串
        model.addAttribute("username", "");
        model.addAttribute("password", "");
        return "login";
    }

    @RequestMapping("/dologin.do")
    public ModelAndView doLogin(User user, HttpSession session) {
        ModelAndView mv = new ModelAndView();
        try {
            //异常处理
            if (user.getUsername().isEmpty() && user.getPassword().isEmpty()) {
                throw new InvalidInputException("用户名与密码不能为空！");
            }
            if (user.getUsername().isEmpty()) {
                throw new InvalidInputException("用户名不能为空！");
            }
            if (user.getPassword().isEmpty()) {
                throw new InvalidInputException("密码不能为空！");
            }
            UserDao login = new UserDao();
            User logined = login.loginUser(user.getUsername());
            if (logined == null || !logined.getPassword().equals(user.getPassword())) {
                throw new InvalidInputException("用户名或密码错误！");
            }
            mv.addObject("user", logined.getUsername());
            session.setAttribute("user", logined.getUsername());
            mv.setViewName("main");
        }
        catch (InvalidInputException e) {
            //显示异常
            mv.addObject("errorMessage", e.getMessage());
            //将用户名和密码填充回输入框
            mv.addObject("username", user.getUsername());
            mv.addObject("password", user.getPassword());
            mv.setViewName("login");
        }
        return mv;
    }


    @RequestMapping("/register.do")
    public String register(Model model){
        // 设置默认值为空字符串
        model.addAttribute("username", "");
        model.addAttribute("password", "");
        return "register";
    }
    @RequestMapping("/doregister.do")
    public ModelAndView doRegister(User user){
        ModelAndView mv = new ModelAndView();
        try {
            //异常处理
            if (user.getUsername().isEmpty() && user.getPassword().isEmpty()) {
                throw new InvalidInputException("用户名与密码不能为空！");
            }
            if (user.getUsername().isEmpty()) {
                throw new InvalidInputException("用户名不能为空！");
            }
            if (user.getPassword().isEmpty()) {
                throw new InvalidInputException("密码不能为空！");
            }
            UserDao register = new UserDao();
            boolean registered = register.registerUser(user.getUsername(),user.getPassword());
            if (registered == false) {
                throw new InvalidInputException("用户名已存在！");
            }
            mv.setViewName("redirect:/login.do");
        }
        catch (InvalidInputException e) {
            //显示异常
            mv.addObject("errorMessage", e.getMessage());
            //填充回输入框
            mv.addObject("username", user.getUsername());
            mv.addObject("password", user.getPassword());
            mv.setViewName("register");
        }
        return mv;
    }

    @RequestMapping("/logout.do")
    public String logout(HttpSession session,Model model){
        session.removeAttribute("user");
        model.addAttribute("username", "");
        model.addAttribute("password", "");
        return "login";
    }

    @RequestMapping("/admin.do")
    public String doAdmin(){
        System.out.println("欢迎你进入系统！");
        return "admin";
    }
}
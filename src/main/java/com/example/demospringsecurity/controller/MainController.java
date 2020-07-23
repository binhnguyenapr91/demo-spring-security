package com.example.demospringsecurity.controller;

import com.example.demospringsecurity.model.Accounts;
import com.example.demospringsecurity.util.WebUtil;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.WebUtils;

import java.security.Principal;

@Controller
public class MainController {
    @GetMapping("/")
    public String getHome(Model model){
        model.addAttribute("title","Welcome");
        model.addAttribute("message","This is welcome page");
        return "home";
    }

    @GetMapping("/admin")
    public String getAdmin(Model model, Principal principal){
        User loggedAccount = (User) ((Authentication)principal).getPrincipal();
        String accountInfo = WebUtil.toString(loggedAccount);
        model.addAttribute("accountInfor",accountInfo);
        return "adminPage";
    }

    @GetMapping("/login")
    public String loginPage(Model model) {
        return "loginPage";
    }

    @GetMapping("/logoutSuccessful")
    public String logoutSuccessfulPage(Model model) {
        model.addAttribute("title", "Logout");
        return "logoutSuccessfulPage";
    }

    @RequestMapping(value = "/accountInfor", method = RequestMethod.GET)
    public String userInfo(Model model, Principal principal) {

        // Sau khi user login thanh cong se co principal
        String userName = principal.getName();

        System.out.println("User Name: " + userName);

        User loginedUser = (User) ((Authentication) principal).getPrincipal();

        String userInfo = WebUtil.toString(loginedUser);
        model.addAttribute("accountInfor", userInfo);

        return "accountInforPage";
    }

    @RequestMapping(value = "/403", method = RequestMethod.GET)
    public String accessDenied(Model model, Principal principal) {

        if (principal != null) {
            User loginedUser = (User) ((Authentication) principal).getPrincipal();

            String userInfo = WebUtil.toString(loginedUser);

            model.addAttribute("accountInfor", userInfo);

            String message = "Hi " + principal.getName() //
                    + "<br> You do not have permission to access this page!";
            model.addAttribute("message", message);

        }

        return "403Page";
    }
}

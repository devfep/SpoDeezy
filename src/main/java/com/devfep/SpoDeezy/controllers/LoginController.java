package com.devfep.SpoDeezy.controllers;

import com.devfep.SpoDeezy.entity.User;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@CrossOrigin(origins = "*")
public class LoginController {

    @RequestMapping(value ="/login",method = { RequestMethod.GET, RequestMethod.POST })
    public String displayLoginPage(@RequestParam(value = "error", required = false) String error,
                                   @RequestParam(value = "register", required = false) String register,
                                   @RequestParam(value = "logout", required = false) String logout, Model model) {
        String errorMessage = null;
        if(error != null) {
            errorMessage = "Username or Password is incorrect";
        } else if(logout != null) {
            errorMessage = "You have been successfully logged out";
        } else if (register != null){
            errorMessage = "Your account was created. Log in with registration credentials";
        }
        model.addAttribute("errorMessage", errorMessage);
        return "login.html";
    }

    @RequestMapping(value="/logout", method = RequestMethod.GET)
    public String logoutPage(HttpServletRequest req, HttpServletResponse res) {
        Authentication auth = SecurityContextHolder.getContext().getAuthentication();
        if (auth != null){
            new SecurityContextLogoutHandler().logout(req, res, auth);
        }
        return "redirect:/login?logout=true";
    }

}

package com.devfep.SpoDeezy.controllers;

import com.devfep.SpoDeezy.entity.User;
import com.devfep.SpoDeezy.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@CrossOrigin(origins = "*")
public class PublicController {
    @Autowired
    UserService userService;

    @RequestMapping("/register")
    public String displayRegisterPage(Model model) {
        model.addAttribute("user", new User());
        return "register.html";
    }

    @RequestMapping(value ="/createUser",method = { RequestMethod.POST})
    public String createUser(@Valid @ModelAttribute("user") User user, Errors errors) {
        if(errors.hasErrors()){
            return "register.html";
        }
        boolean isSaved = userService.createNewUser(user);
        if(isSaved){
            return "redirect:/login?register=true";
        }else {
            return "register.html";
        }
    }
}

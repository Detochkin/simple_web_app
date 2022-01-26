package com.detochkin.portfolio.controllers;

import com.detochkin.portfolio.domain.Role;
import com.detochkin.portfolio.domain.User;
import com.detochkin.portfolio.repos.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import java.util.Collections;
import java.util.Map;

@Controller
public class SignUpController {
    @Autowired
    private UserRepository userRepository;

    @GetMapping("/signup")
    public String signUp(){
        return "signup";
    }

    @PostMapping("/signup")
    public String addUser(User user, Map<String, Object> model){
        User userFromDb = userRepository.findByUsername(user.getUsername());
        if (userFromDb != null){
            model.put("message", "Такой пользователь уже есть");//сделать репо для месседжей
            return ("signup");
        }
        user.setActive(true);
        user.setRoles(Collections.singleton(Role.USER));
        userRepository.save(user);

        return "redirect:/login";
    }
}

package com.spring.boot.example.controller;

import com.spring.boot.example.model.User;
import com.spring.boot.example.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
public class UserController {
    @Autowired // This means to get the bean called userRepository
    // Which is auto-generated by Spring, we will use it to handle the data
    private UserRepository userRepository;

    @GetMapping("/register")
    public String displayRegistrationPage(Model model) {
        return "registration";
    }

    @ModelAttribute("user")
    public User user(){
        return new User();
    }

    @PostMapping("/register")
    public String register(@ModelAttribute("user") User user, Model model) {
        User userObject = new User();
        userObject.setFirstName(user.getFirstName());
        userObject.setLastName(user.getLastName());
        userObject.setBirthday(user.getBirthday());
        userObject.setEmail(user.getEmail());
        userObject.setPassword(user.getPassword());
        userRepository.save(user);


        // This returns a JSON or XML with the users
        //return userRepository.findAll();
        //"redirect:/index"
        model.addAttribute("user", user);
       // return "main";
        return "redirect:/main";

    }

    @GetMapping("/main")
    public String displayAllUsers(@ModelAttribute("user") User user, Model model) {
        Iterable<User> users = userRepository.findAll();
        model.addAttribute("users", users);
        model.addAttribute("user", user);
        return "main";
    }

    @GetMapping("/login")
    public String displayLoginPage(Model model) {
        return "login";
    }

    @PostMapping("/login")
    public String getUser(@RequestParam String email, @RequestParam String password, Model model) {
        System.out.println("getUser email: " + email);
        User user = userRepository.findUserByEmail(email);
        System.out.println("User: " + user);
        model.addAttribute("user", user);
        return "redirect:/main";
    }

    @PostMapping("/logout")
    public String logoutUser() {
        System.out.println("logoutUser");
        //User user = userRepository.findUserByEmail(email);
       // System.out.println("User: " + user);
        //model.addAttribute("user", user);
        return "main";
    }
}

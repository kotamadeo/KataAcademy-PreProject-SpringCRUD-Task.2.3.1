package com.gmail.at.kotamadeo.controllers;

import com.gmail.at.kotamadeo.models.User;
import com.gmail.at.kotamadeo.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@Controller
@RequestMapping("/users")
public class UsersController {
    private final UserService userService;

    @Autowired
    public UsersController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public String showAllUsers(@RequestParam(value = "count", defaultValue = "0") int count, Model model) {
        model.addAttribute("users", userService.showAllUsers(count));
        return "users/show";
    }

    @GetMapping("/{id}")
    public String getUser(@PathVariable("id") long id, Model model) {
        model.addAttribute("user", userService.getUser(id));
        return "users/user";
    }

    @GetMapping("/create")
    public String newPerson(@ModelAttribute("user") User user) {
        return "users/create";
    }

    @PostMapping()
    public String createNewUser(@ModelAttribute("user") @Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "users/create";
        }
        userService.createNewUser(user);
        return "redirect:/users";
    }

    @GetMapping("/{id}/update")
    public String update(Model model, @PathVariable("id") long id) {
        model.addAttribute("user", userService.getUser(id));
        return "users/update";
    }

    @PatchMapping("/{id}")
    public String updateUserById(@ModelAttribute("user") @Valid User user, BindingResult bindingResult,
                                 @PathVariable("id") long id) {
        if (bindingResult.hasErrors()) {
            return "users/update";
        }
        userService.updateUserById(id, user);
        return "redirect:/users";
    }

    @DeleteMapping("/{id}")
    public String deleteUserById(@PathVariable("id") long id) {
        userService.deleteUserById(id);
        return "redirect:/users";
    }
}


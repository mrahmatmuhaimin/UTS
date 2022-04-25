package com.muhaimin.springbootresetpasswordapplication.controller;

import com.muhaimin.springbootresetpasswordapplication.entity.User;
import com.muhaimin.springbootresetpasswordapplication.service.framework.UserService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@AllArgsConstructor
public class IndexController {
    private UserService userService1;

    @GetMapping("/")
    public String index(Model model) {
        model.addAttribute("student", userService1.getAllStudents());
        return "index";
    }

    @GetMapping(value = "/create")
    public String create1(Model model) {
        model.addAttribute("student", new User());
        return "formStudent";
    }

    @PostMapping(value = "/create")
    public String tambahStudent(Model model, User student) {
        model.addAttribute("student", userService1.save(student));
        return "redirect:/";
    }

    @GetMapping(value = "/edit/{id}")
    public String editForm(@PathVariable Long id, Model model) {
        model.addAttribute("student", userService1.findById(id));
        return "formStudent";
    }

    @GetMapping(value = "/hapus/{id}")
    public String hapusStudent(@PathVariable Long id) {
        userService1.deleteById(id);
        return "redirect:/";
    }
}
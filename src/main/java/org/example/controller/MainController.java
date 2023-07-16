package org.example.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainController {

    @GetMapping("/")
    public String sayHello() {
        return "main";
    }

    @GetMapping("/true")
    public String success() {
        return "success";
    }

    @GetMapping("/fail")
    public String failure() {
        return "failure";
    }

}

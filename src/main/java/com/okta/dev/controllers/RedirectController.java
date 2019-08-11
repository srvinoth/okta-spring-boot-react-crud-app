package com.okta.dev.controllers;

import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
@Profile("dev")
public class RedirectController {

    @GetMapping("/private")
    public String redirectToRoot() {
        return "redirect:/";
    }
}
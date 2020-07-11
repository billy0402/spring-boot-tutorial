package edu.ntub.demo.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class SecurityController {

    @GetMapping(path = "/")
    public ModelAndView indexPage() {
        return new ModelAndView("/index");
    }

    @PreAuthorize("hasAuthority('ADMIN')")
    @GetMapping(path = "/admin")
    public ModelAndView adminPage() {
        return new ModelAndView("/admin");
    }

    @PreAuthorize("hasAuthority('USER')")
    @GetMapping(path = "/user")
    public ModelAndView userPage() {
        return new ModelAndView("/user");
    }
}

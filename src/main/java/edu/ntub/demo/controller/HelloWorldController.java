package edu.ntub.demo.controller;

import edu.ntub.demo.bean.HelloWorldBean;
import edu.ntub.demo.service.HelloWorldService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
@RequestMapping(path = "/hello")
public class HelloWorldController {
    private final HelloWorldService helloWorldService;

    @Autowired
    public HelloWorldController(HelloWorldService helloWorldService) {
        this.helloWorldService = helloWorldService;
    }

    @GetMapping(path = "/world", produces = "application/json;charset=UTF-8")
    public ResponseEntity<HelloWorldBean> helloWorld(@RequestParam(name = "name", defaultValue = "小華") String name) {
        HelloWorldBean helloWorldBean = helloWorldService.getScore(name);
        return ResponseEntity.ok(helloWorldBean);
    }
}

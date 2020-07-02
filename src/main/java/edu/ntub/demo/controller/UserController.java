package edu.ntub.demo.controller;

import edu.ntub.demo.bean.UserBean;
import edu.ntub.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.validation.Valid;
import javax.validation.ValidationException;
import java.util.Objects;

@Controller
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }


    @PostMapping(path = "/create")
    public ResponseEntity<UserBean> setUser(@Valid @RequestBody UserBean user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            FieldError fieldError = bindingResult.getFieldError();
            throw new ValidationException(Objects.requireNonNull(fieldError).getDefaultMessage());
        }
//        HttpClient client = HttpClient.newBuilder().version(HttpClient.Version.HTTP_1_1).build();
//        HttpRequest request = HttpRequest.newBuilder().uri(URI.create("https://www.google.com.tw")).GET().build();
//        try {
//            HttpResponse<String> response = client.send(request, HttpResponse.BodyHandlers.ofString());
//            System.out.println("response.body() = " + response.body());
//        } catch (IOException | InterruptedException e) {
//            e.printStackTrace();
//        }
        UserBean userBean = userService.setUser(user);
        return ResponseEntity.ok(userBean);
    }
}

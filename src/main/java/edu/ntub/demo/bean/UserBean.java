package edu.ntub.demo.bean;

import lombok.Data;

import javax.validation.constraints.Positive;
import java.time.LocalDate;

@Data
public class UserBean {
    @Positive(message = "id要大於0")
    private int id;
    private String account;
    private String password;
    private String name;
    private String email;
    private String phone;
    private LocalDate birthday;
}

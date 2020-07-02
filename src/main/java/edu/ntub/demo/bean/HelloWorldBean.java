package edu.ntub.demo.bean;

import lombok.Data;

import java.time.LocalDate;

@Data
public class HelloWorldBean {
    private LocalDate today;
    private int[] scoreArray;
}

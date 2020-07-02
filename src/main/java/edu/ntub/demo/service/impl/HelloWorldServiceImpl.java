package edu.ntub.demo.service.impl;

import edu.ntub.demo.bean.HelloWorldBean;
import edu.ntub.demo.service.HelloWorldService;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class HelloWorldServiceImpl implements HelloWorldService {
    @Override
    public HelloWorldBean getScore(String name) {
        HelloWorldBean result = new HelloWorldBean();
        result.setToday(LocalDate.now());
        switch (name) {
            case "小明":
                result.setScoreArray(new int[]{1, 2, 3});
                break;
            case "小華":
                result.setScoreArray(new int[]{4, 5, 6});
                break;
        }
        return result;
    }
}

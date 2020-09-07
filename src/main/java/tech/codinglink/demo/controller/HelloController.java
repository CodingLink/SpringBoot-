package tech.codinglink.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import tech.codinglink.demo.entity.CustomsInfo;
import tech.codinglink.demo.service.CustomsService;

import java.util.List;

@RestController
public class HelloController {
    @RequestMapping("/hello")
    public String hello(){
        return "hello springboot";
    }
}

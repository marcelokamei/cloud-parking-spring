package pt.mmkamei.parking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HelloController {
    @GetMapping
    public String Hello(){
        return "<h1>Hello Cloud Parking... Devs Dio.me</h1>";
    }
}

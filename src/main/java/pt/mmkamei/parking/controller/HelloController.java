package pt.mmkamei.parking.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import springfox.documentation.annotations.ApiIgnore;

@RestController
@RequestMapping("/")
@ApiIgnore
public class HelloController {
    @GetMapping
    public String Hello(){
        return "<h1>Hello Cloud Parking... Dev MKamei 2022</h1>";
    }
}

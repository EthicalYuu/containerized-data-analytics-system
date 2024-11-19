package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import spring.entity.AuthRequest;
import spring.entity.AuthResponse;

@Controller
public class LoginController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/")
    public String loginPage() {
        return "login-page";
    }


    @PostMapping("/submit")
    public String submitPage(@RequestParam String username, @RequestParam String password){
        AuthResponse response = restTemplate.postForObject("http://authentication-service:8081/authenticate", new AuthRequest(username, password), AuthResponse.class);
        if(response != null && response.isAuthenticated()){
            return "entry-page";
        }
        return "redirect:/login-page";
    }
}

package spring.controller;
import org.springframework.web.bind.annotation.*;
import spring.entity.AuthRequest;
import spring.entity.AuthResponse;

@RestController
public class AuthenticationController {

    @PostMapping("/authenticate")
    public AuthResponse authenticate (@RequestBody AuthRequest authRequest) {
        String username = authRequest.getUsername();
        String password = authRequest.getPassword();
        Boolean isAuthenticated;

        isAuthenticated = username.equals("admin") && password.equals("admin");

        System.out.println(username);

        return new AuthResponse(isAuthenticated);
    }
}

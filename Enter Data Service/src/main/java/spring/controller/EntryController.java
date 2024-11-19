package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import spring.entity.AuthResponse;
import spring.service.TempService;

@Controller
public class EntryController {

    @Autowired
    private RestTemplate restTemplate;

    @Autowired
    private TempService tempService;


    @PostMapping("/submit-entry")
    public String submitEntry(@RequestParam int temperature){
        tempService.addNewTemp(temperature);
        restTemplate.postForObject("http://analytics-service:8083/generate-analytics", new String("A new entry has been added"), AuthResponse.class);
        return "entry-page";
    }
}

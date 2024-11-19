package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;
import spring.entity.Analytics;
import spring.service.TempService;

import java.util.List;


@Controller
public class AnalyticsController {

    @Autowired
    private RestTemplate restTemplate;


    @GetMapping("/get-results")
    public String displayResults(Model model) {

        String url = "http://show-service:8084/analytics-list";
        ResponseEntity<List<Analytics>> response = restTemplate.exchange(
                url,
                HttpMethod.GET,
                null,
                new ParameterizedTypeReference<List<Analytics>>() {}
        );

        List<Analytics> analyticsList = response.getBody();
        for(Analytics analytics: analyticsList){
            System.out.println(analytics.getAvgTemp());
        }
        model.addAttribute("analyticsList", analyticsList);

        return "analytics-view";
    }
}

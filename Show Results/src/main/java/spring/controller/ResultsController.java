package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.AnalyticsRepo;
import spring.entity.Analytics;

import java.util.List;



@RestController
public class ResultsController {
    @Autowired
    private AnalyticsRepo analyticsRepo;

    @GetMapping("/analytics-list")
    public List<Analytics> analyticsList() {

        List<Analytics> analyticsList = analyticsRepo.findAll();

        return analyticsList;
    }
}

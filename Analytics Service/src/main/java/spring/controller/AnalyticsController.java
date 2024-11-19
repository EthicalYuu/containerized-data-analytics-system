package spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import spring.AnalyticsRepo;
import spring.entity.Analytics;
import spring.entity.Temperature;
import spring.service.TempService;

import java.util.List;



@RestController
public class AnalyticsController {

    @Autowired
    private TempService tempService;

    @Autowired
    private AnalyticsRepo analyticsRepo;


    @PostMapping("/generate-analytics")
    public void getTemperatures(){
        int temp;
        int minTemp = Integer.MAX_VALUE;
        int maxTemp = 0;
        int avgTemp;
        int sum = 0;
        List<Temperature> tempList = tempService.getAllTemps();
        for(Temperature temperature: tempList){
            temp = temperature.getTempValue();
            if(temp < minTemp){
                minTemp = temp;
            } else if(temp > maxTemp){
                maxTemp = temp;
            }
            sum += temp;
        }
        avgTemp = sum / tempList.size();
        analyticsRepo.save(new Analytics(minTemp, maxTemp, avgTemp));
        System.out.println("Latest statistics saved!");
    }
}

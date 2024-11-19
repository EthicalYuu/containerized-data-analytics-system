package spring.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import spring.TempRepo;
import spring.entity.Temperature;

import java.util.List;

@Service
public class TempService {

    @Autowired
    TempRepo tempRepo;

    public List<Temperature> getAllTemps(){
        return tempRepo.findAll();
    }
}

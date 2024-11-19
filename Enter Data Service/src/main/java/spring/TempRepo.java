package spring;

import org.springframework.data.jpa.repository.JpaRepository;
import spring.entity.Temperature;

import java.util.List;

public interface TempRepo extends JpaRepository <Temperature, Integer> {
    List<Temperature> findAll();
}

package spring;

import org.springframework.data.mongodb.repository.MongoRepository;
import spring.entity.Analytics;

import java.util.List;

public interface AnalyticsRepo extends MongoRepository<Analytics, String> {
    List<Analytics> findAll();
}

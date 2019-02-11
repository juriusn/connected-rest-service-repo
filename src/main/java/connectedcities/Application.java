package connectedcities;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import connectedcities.exceptionhandler.AppException;
import connectedcities.service.ISearchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.io.ClassPathResource;

import javax.annotation.PostConstruct;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

import static connectedcities.controller.Constants.CITY;
import static connectedcities.controller.Constants.REQUIRED_FILE_NOT_FOUND_ERROR;

@SpringBootApplication
public class Application {

    private static final Logger logger = LoggerFactory.getLogger(Application.class);

    @Autowired
    private ISearchService searchService;

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @PostConstruct
    public void init() throws AppException.InputFileNotFoundExecution {
            searchService.initializeGraph(loadFromCitiesFile());
    }

    private List<String> loadFromCitiesFile() throws AppException.InputFileNotFoundExecution {
        List<String> cities = new ArrayList<>();
        try {
            try (BufferedReader reader = new BufferedReader(new InputStreamReader(new ClassPathResource(CITY).getInputStream())) ) {
                reader.lines().forEach(line -> cities.add(line));
            }
        } catch (IOException e) {
            logger.error(REQUIRED_FILE_NOT_FOUND_ERROR);
            throw new AppException.InputFileNotFoundExecution(REQUIRED_FILE_NOT_FOUND_ERROR);
        }
        return cities;
    }
}
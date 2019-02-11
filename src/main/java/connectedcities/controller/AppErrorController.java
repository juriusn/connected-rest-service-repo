package connectedcities.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.RequestDispatcher;
import javax.servlet.http.HttpServletRequest;

import static connectedcities.controller.Constants.ERROR_PATH;

@RestController
public class AppErrorController implements ErrorController {

    private static final Logger logger = LoggerFactory.getLogger(AppErrorController.class);

    @Override
    public String getErrorPath() {
        return ERROR_PATH;
    }

    @GetMapping(value = ERROR_PATH)
    public String handleRequestError(HttpServletRequest request) {

        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);
        logger.error(System.lineSeparator() + "error request with code: " + Integer.valueOf(status.toString()));

        StringBuilder response = new StringBuilder();
        response.append("<h2>Wrong URL, please try request formatted like that:</h2> http://localhost:8080/connected?origin=Boston&destination=Philadelphia");
        response.append(System.lineSeparator());
        response.append("<h3>See Swagger API UI at URL below:</h3>");
        response.append("<a href='http://localhost:8080/swagger-ui.html#/connected-checker-controller'>Swagger UI</a>");
        return response.toString();
    }
}
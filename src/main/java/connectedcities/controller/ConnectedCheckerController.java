package connectedcities.controller;

import connectedcities.service.ISearchService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import static connectedcities.controller.Constants.NO;
import static connectedcities.controller.Constants.YES;

@Api(value="Connected Cities Application", description="Provides operation for checking connected cities")
@RestController
public class ConnectedCheckerController {

    private static final Logger logger = LoggerFactory.getLogger(ConnectedCheckerController.class);

    @Autowired
    private ISearchService searchService;

    @ApiOperation(value = "Connected: [yes | no]", response = String.class)
    @GetMapping("/connected")
    public String getIsConnected(@ApiParam(value = "Origin city", required = true)
                                 @RequestParam("origin") String origin,
                                 @ApiParam(value = "Destination city", required = true)
                                 @RequestParam("destination") String destination){
        logger.debug(System.lineSeparator() + "origin = %s , destination = %s", origin, destination);
        return searchService.isConnected(origin, destination)?YES:NO;
    }
}
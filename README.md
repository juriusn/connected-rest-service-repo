# Connected rest service

1. Clone the code and open it as a Maven project in your IDE.
2. Start the bootstarp Application class:
  it will read the city.txt file from resources folder and populate the Graph class at the start.
3. Application can be cheked at the URL formatted like: 
   http://localhost:8080/connected?origin=Boston&destination=Newark
 </br>3.1. Wrong URL will lead to a predefined error page.
 </br>3.2. If a city is not present in a graph the response will be 'no'.
4. The Swagger API for the application is at: http://localhost:8080/swagger-ui.html#/connected-checker-controller











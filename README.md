# Connected rest service

<h3>Service goal: find out if 2 cities, provided on the service URL as parameters, are connected.</h3>
<h5>
 Example:

if the city.txt content is:

Boston, New York </br>
Philadelphia, Newark </br>
Newark, Boston </br>
Trenton, Albany </br>

http://localhost:8080/connected?origin=Boston&destination=Newark
Should return yes

http://localhost:8080/connected?origin=Boston&destination=Philadelphia
Should return yes

http://localhost:8080/connected?origin=Philadelphia&destination=Albany
Should return no

</h5>

<h3>Installation and execution instructions</h3>

1. Please clone the code and open it as a Maven project in your IDE.
2. Please start the bootstarp Application class:
  it will read the city.txt file from resources folder and populate the Graph class at the start.
3. Application can be cheked at the URL formatted like: 
   http://localhost:8080/connected?origin=Boston&destination=Newark
 </br>3.1. Wrong URL will lead to a predefined error page.
 </br>3.2. If a city is not present in a graph the response will be 'no'
4. The Swagger API for the application is at: http://localhost:8080/swagger-ui.html#/connected-checker-controller











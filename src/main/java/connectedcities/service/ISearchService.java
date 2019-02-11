package connectedcities.service;

import java.util.List;

public interface ISearchService {
   void initializeGraph(List<String> citiesList);
   boolean isConnected(String origin, String destination);
}

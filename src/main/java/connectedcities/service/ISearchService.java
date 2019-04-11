package connectedcities.service;

import java.util.List;
/**
 * ISearchService - service interface to loosely couple service
 * implementation with a client
 */
public interface ISearchService {
    void initializeGraph(List<String> citiesList);
    boolean isConnected(String origin, String destination);
}

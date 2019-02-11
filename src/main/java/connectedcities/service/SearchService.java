package connectedcities.service;

import connectedcities.Application;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
public class SearchService implements ISearchService {

    private static final Logger logger = LoggerFactory.getLogger(SearchService.class);
    private final Graph graph = new Graph();
    private List<String> possiblePaths;
    private String destination;

    private void depthFirst(Graph graph, LinkedList<String> visitedNodes) {
        LinkedList<String> nodes = graph.adjacentNodes(visitedNodes.getLast());
        // examine adjacent nodes
        for (String node : nodes) {
            if (visitedNodes.contains(node)) {
                continue;
            }
            if (node.equals(destination)) {
                visitedNodes.add(node);
                collectAndPrintPath(visitedNodes);
                visitedNodes.removeLast();
                break;
            }
        }
        for (String node : nodes) {
            if (visitedNodes.contains(node) || node.equals(destination)) {
                continue;
            }
            visitedNodes.addLast(node);
            depthFirst(graph, visitedNodes);
            visitedNodes.removeLast();
        }
    }

    private void collectAndPrintPath(LinkedList<String> visited) {
        StringBuilder path = new StringBuilder();
        visited.stream().forEach(node->path.append(node).append(" "));
        possiblePaths.add(path.toString());
        logger.debug(System.lineSeparator() + " possiblePaths: " + possiblePaths);
    }

    /**
     * An auxiliary public initialization method of SearchService
     * used for initial population of connected cities graph.
     *
     * @param citiesList
     */
    @Override
    public void initializeGraph(List<String> citiesList) {
        citiesList.parallelStream().forEach(cityPairString->
         {
            String[] cityPairArray = cityPairString.split(",");
            graph.addEdge(cityPairArray[0].trim(), cityPairArray[1].trim());
            graph.addEdge(cityPairArray[1].trim(), cityPairArray[0].trim());
         });
    }

    /**
     *  This is a core public method of SearchService
     *  it uses the Depth-First-Search (DFS) algorithm on a #{service.Graph} instance
     *  of connected cities.
     *  Note: it tries to find and collect all possible paths from origin to destination;
     *  if paths collection is not empty the answer is 'yes'.
     *
     *
     * @param origin
     * @param destination
     * @return boolean
     */
    @Override
    public boolean isConnected(String origin, String destination) {
        possiblePaths = new ArrayList<>();

        LinkedList<String> visitedNodes = new LinkedList();
        visitedNodes.add(origin);
        this.destination = destination;
        depthFirst(graph, visitedNodes);

        return possiblePaths.size()>0?true:false;
    }
}
import java.util.*;
import java.util.concurrent.LinkedBlockingDeque;
import java.util.stream.Collectors;

/**
 * 332. Reconstruct Itinerary
 * Medium
 *  https://leetcode.com/problems/reconstruct-itinerary/
 * 788
 *
 * 518
 *
 * Favorite
 *
 * Share
 * Given a list of airline tickets represented by pairs of departure and arrival airports
[from, to], reconstruct the itinerary in order. All of the tickets belong to a man who departs
from JFK. Thus, the itinerary must begin with JFK.
 *
 * Note:
 *
 * If there are multiple valid itineraries, you should return the itinerary that has
the smallest lexical order when read as a single string. For example, the itinerary ["JFK",
"LGA"] has a smaller lexical order than ["JFK", "LGB"].
 * All airports are represented by three capital letters (IATA code).
 * You may assume all tickets form at least one valid itinerary.
 * Example 1:
 *
 * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
 * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]
 * Example 2:
 *
 * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
 * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
 * Explanation: Another possible reconstruction is ["JFK","SFO","ATL","JFK","ATL","SFO"].
 *              But it is larger in lexical order.
 */
public class ReconstructItinerary {

    private Set<Node> visited;
    private Stack<Node> stack;
    private Set<Node> unvisited;
    private int count = 0;
    private Set<String> usedTickets;
    private Set<String> unusedTickets;

    static class Node {
        String airport;
        Set<Node> adjList = new TreeSet<>(Comparator.comparing(a -> a.airport));

        void addEdge(Node adjNode){
            adjList.add(adjNode);
        }

        Node(String airport) {
            this.airport = airport;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            Node node = (Node) o;
            return Objects.equals(airport, node.airport);
        }

        @Override
        public int hashCode() {
            return Objects.hash(airport);
        }
    }

    public List<String> findItinerary(List<List<String>> tickets) {
        //do all of the tickets need to user
        //  looks like yes
        //are they always used
        //  look like yes
        //this problem looks like build graph
        // then find longest path
        //would longest path be best done through a topological sort??
        // ding ding That seems to be the answer
        //How do we do a topological sort
        //  DFS + Stack, when we run into the end of the visitable nodes we add them to the stack
        // i think we neeed to do a recusive dfs

        Map<String, Node> airportsToNode = new HashMap<>();
        for (List<String> itinerary : tickets) {

            String start = itinerary.get(0);
            String dest = itinerary.get(1);

            Node startNode = airportsToNode.getOrDefault(start, new Node(start));
            airportsToNode.put(start, startNode);
            Node destNode = airportsToNode.getOrDefault(dest, new Node(dest));
            airportsToNode.put(dest, destNode);

            startNode.addEdge(destNode);

        }

        visited = new HashSet<>();
        unvisited = new HashSet<>();
        unvisited.addAll(airportsToNode.values());
        //you need an unusedTickets

        stack = new Stack<>();

        Optional<Node> anyNode;
        do {
            anyNode= unvisited.stream().findAny();
            if (anyNode.isPresent()) {
                Node node = anyNode.get();
                topologicalSort(node);
            }
        } while (anyNode.isPresent());

        List<String> itenerary = this.stack.stream().map(n -> n.airport).collect(Collectors.toList());

        Collections.reverse(itenerary);
        return itenerary;
    }

    private void topologicalSort(Node node) {
        if (node == null) {
            return;
        }
        if (this.visited.contains(node)) {
            return;
        }

        this.visited.add(node);
        this.unvisited.remove(node);

        for (Node adjAirport : node.adjList) {
            usedTickets.add(node.airport + ":" + adjAirport);
            topologicalSort(adjAirport);
        }

        this.stack.push(node);
    }
}

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;

public class ReconstructItineraryTest {
//     * Input: [["MUC", "LHR"], ["JFK", "MUC"], ["SFO", "SJC"], ["LHR", "SFO"]]
// * Output: ["JFK", "MUC", "LHR", "SFO", "SJC"]


    @Test
    public void findItineraryOne() {
        List<List<String>> tickets = Arrays.asList(Arrays.asList("MUC", "LHR"), Arrays.asList("JFK", "MUC"), Arrays.asList("SFO", "SJC"), Arrays.asList("LHR", "SFO"));
        List<String> expectItinerary = Arrays.asList("JFK", "MUC", "LHR", "SFO", "SJC");
        List<String> actualItinerary = new ReconstructItinerary().findItinerary(tickets);
        Assert.assertEquals(expectItinerary, actualItinerary);
    }

    // * Example 2:
// *
// * Input: [["JFK","SFO"],["JFK","ATL"],["SFO","ATL"],["ATL","JFK"],["ATL","SFO"]]
// * Output: ["JFK","ATL","JFK","SFO","ATL","SFO"]
    @Test
    public void findItineraryTwo() {
    }
}
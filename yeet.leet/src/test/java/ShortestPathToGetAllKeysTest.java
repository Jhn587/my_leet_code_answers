import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ShortestPathToGetAllKeysTest {

    // * Example 1:
//            * <p>
// * Input: ["@.a.#","###.#","b.A.B"]
//            * Output: 8
    @Test
    public void shortestPathAllKeysExampleOne() {

        String[] grid = new String[]{"@.a.#", "###.#", "b.A.B"};
        ShortestPathToGetAllKeys shortestPathToGetAllKeys = new ShortestPathToGetAllKeys();
        int actualResult = shortestPathToGetAllKeys.shortestPathAllKeys(grid);
        Assert.assertEquals(8, actualResult);
    }

    //            * Example 2:
//            * <p>
// * Input: ["@..aA","..B#.","....b"]
//            * Output: 6
    @Test
    public void shortestPathAllKeysExampleTwo() {
        String[] grid = new String[]{"@..aA", "..B#.", "....b"};
        ShortestPathToGetAllKeys shortestPathToGetAllKeys = new ShortestPathToGetAllKeys();
        int actualResult = shortestPathToGetAllKeys.shortestPathAllKeys(grid);
        Assert.assertEquals(6, actualResult);
    }
}
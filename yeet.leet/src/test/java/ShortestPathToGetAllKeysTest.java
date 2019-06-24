import org.junit.Assert;
import org.junit.Test;

import java.util.concurrent.ExecutionException;

import static org.junit.Assert.*;

public class ShortestPathToGetAllKeysTest {

    // * Example 1:
//            * <p>
// * Input: ["@.a.#","###.#","b.A.B"]
//            * Output: 8
    @Test
    public void shortestPathAllKeysExampleOne()  {

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

    // Example 3: ["Dd#b@",".fE.e","##.B.","#.cA.","aF.#C"]
    @Test
    public void shortestPathAllKeysExampleThree()  {
        String[] grid = new String[]{"Dd#b@", ".fE.e", "##.B.", "#.cA.", "aF.#C"};
        ShortestPathToGetAllKeys shortestPathToGetAllKeys = new ShortestPathToGetAllKeys();
        int actualResult = shortestPathToGetAllKeys.shortestPathAllKeys(grid);
        Assert.assertEquals(14, actualResult);
    }

    // Example 4: ["..#.#.#.##",".#.#....#.","..#.......",".......#..","......#...","#..###a...","..##....#A",".....#.#.#",".#......##","#..@.##.#."]
    @Test
    public void shortestPathAllKeysExampleFour()  {
        String[] grid = new String[]{"..#.#.#.##", ".#.#....#.", "..#.......", ".......#..", "......#...", "#..###a...", "..##....#A", ".....#.#.#", ".#......##", "#..@.##.#."};
        ShortestPathToGetAllKeys shortestPathToGetAllKeys = new ShortestPathToGetAllKeys();
        int actualResult = shortestPathToGetAllKeys.shortestPathAllKeys(grid);
        Assert.assertEquals(7, actualResult);
    }
    // Example 5: ["..#....##.","....d.#.D#","#...#.c...","..##.#..a.","...#....##","#....b....",".#..#.....","..........",".#..##..A.",".B..C.#..@"]
    @Test
    public void shortestPathAllKeysExampleFive()  {
        String[] grid = new String[]{"..#....##.","....d.#.D#","#...#.c...","..##.#..a.","...#....##","#....b....",".#..#.....","..........",".#..##..A.",".B..C.#..@"};
        ShortestPathToGetAllKeys shortestPathToGetAllKeys = new ShortestPathToGetAllKeys();
        int actualResult = shortestPathToGetAllKeys.shortestPathAllKeys(grid);
        Assert.assertEquals(19, actualResult);
    }
}
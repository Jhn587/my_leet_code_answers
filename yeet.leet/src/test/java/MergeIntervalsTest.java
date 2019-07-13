import org.junit.Assert;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class MergeIntervalsTest {
//    Example 1:
//
//    Input:[[1,3],[2,6],[8,10],[15,18]]
//    Output:[[1,6],[8,10],[15,18]]
//    Explanation:
//    Since intervals[1,3]and [2,6]overlaps,
//    merge them
//    into [1,6].

    @Test
    public void mergeOne() {
        int[][] input = new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] output = new int[][]{{1, 6}, {8, 10}, {15, 18}};
        int[][] actual = new MergeIntervals().merge(input);
        Assert.assertTrue(Objects.deepEquals(output, actual));
    }

//    Example 2:

//    Input:[[1,4],[4,5]]
//    Output:[[1,5]]
//    Explanation:Intervals [1,4]and [4,5]
//    are considered
//    overlapping.

    @Test
    public void mergeTwo() {
        int[][] input = new int[][]{{1, 4}, {4, 5}};
        int[][] output = new int[][]{{1, 5}};
        int[][] actual = new MergeIntervals().merge(input);
        Assert.assertTrue(Objects.deepEquals(output, actual));
    }

    @Test
    public void mergeEmpty() {
        int[][] input = new int[][]{};
        int[][] output = new int[][]{};
        int[][] actual = new MergeIntervals().merge(input);
        Assert.assertTrue(Objects.deepEquals(output, actual));
    }

    //    Input
    //[[1,4],[0,4]]
    //    Expected
    //[[0,4]]
    @Test
    public void mergeFour() {
        int[][] input = new int[][]{{1,4},{0,4}};
        int[][] output = new int[][]{{0, 4}};
        int[][] actual = new MergeIntervals().merge(input);
        Assert.assertTrue(Objects.deepEquals(output, actual));
    }
}
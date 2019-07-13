import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Merge Intervals
 * Go to Discuss
 * https://leetcode.com/problems/merge-intervals/
 * Given a collection of intervals, merge all overlapping intervals.
 * <p>
 * Example 1:
 * <p>
 * Input: [[1,3],[2,6],[8,10],[15,18]]
 * Output: [[1,6],[8,10],[15,18]]
 * Explanation: Since intervals [1,3] and [2,6] overlaps, merge them into [1,6].
 * Example 2:
 * <p>
 * Input: [[1,4],[4,5]]
 * Output: [[1,5]]
 * Explanation: Intervals [1,4] and [4,5] are considered overlapping.
 * NOTE: input types have been changed on April 15, 2019. Please reset to default code definition to get new method signature
 */
public class MergeIntervals {
    public int[][] merge(int[][] intervals) {
        if (intervals == null || intervals.length == 0) {
            return new int[0][0];
        }
        Comparator<int[]> comparing = Comparator.comparing(ints -> ints[0]);
        Arrays.sort(intervals, comparing);
        List<int[]> mergedIntervals = new ArrayList<>(intervals.length);
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] current = intervals[i];
            if (prev[1] >= current[0]) {
                prev[1] = Math.max(prev[1], current[1]);
            } else {
                mergedIntervals.add(prev);
                prev = current;
            }
        }
        mergedIntervals.add(prev);
        return mergedIntervals.toArray(new int[0][0]);
    }
}

import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * 78. Subsets
 * Medium
 * https://leetcode.com/problems/subsets/
 * 2115
 * <p>
 * 53
 * <p>
 * Favorite
 * <p>
 * Share
 * Given a set of distinct integers, nums, return all possible subsets (the power set).
 * <p>
 * Note: The solution set must not contain duplicate subsets.
 * <p>
 * Example:
 * <p>
 * Input: nums = [1,2,3]
 * Output:
 * [
 * [3],
 * [1],
 * [2],
 * [1,2,3],
 * [1,3],
 * [2,3],
 * [1,2],
 * []
 * ]
 */

public class Subsets {
    public List<List<Integer>> subsets(int[] nums) {
        Set<List<Integer>> subsets = generateSubsets(nums, 0);
        return new LinkedList<>(subsets);
    }

    private Set<List<Integer>> generateSubsets(int[] nums, int i) {
        if (i >= nums.length) {
            HashSet<List<Integer>> baseCaseList = new HashSet<>();
            baseCaseList.add(new LinkedList<>());
            return baseCaseList;
        }
        Set<List<Integer>> toReturn = new HashSet<>();
        Set<List<Integer>> lists = generateSubsets(nums, i + 1);

        //Excluding current
        for (List<Integer> list : lists) {
            toReturn.add(new LinkedList<>(list));
        }


        //including current
        for (List<Integer> list : lists) {
            LinkedList<Integer> l = new LinkedList<>(list);
            l.addFirst(nums[i]);
            toReturn.add(l);
        }
        return toReturn;
    }
}

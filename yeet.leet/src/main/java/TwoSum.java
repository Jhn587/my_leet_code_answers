import java.util.HashMap;
import java.util.Map;

/**
 * https://leetcode.com/problems/two-sum/
 * 1. Two Sum
 * Easy
 *
 * 11124
 *
 * 380
 *
 * Favorite
 *
 * Share
 * Given an array of integers, return indices of the two numbers such that they add up to a specific target.
 *
 * You may assume that each input would have exactly one solution, and you may not use the same element twice.
 *
 * Example:
 *
 * Given nums = [2, 7, 11, 15], target = 9,
 *
 * Because nums[0] + nums[1] = 2 + 7 = 9,
 * return [0, 1].
 */
public class TwoSum {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> differenceMap = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int currentNumber = nums[i];
            int difference = target - currentNumber;
            if (differenceMap.containsKey(difference)) {
                Integer prevIndex = differenceMap.get(difference);
                return new int[]{prevIndex, i};
            } else {
                differenceMap.put(currentNumber, i);
            }
        }
        return null;
    }
}

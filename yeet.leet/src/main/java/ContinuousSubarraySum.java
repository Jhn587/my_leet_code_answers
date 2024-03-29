/*
  523. Continuous Subarray Sum
  https://leetcode.com/problems/continuous-subarray-sum/
  Given a list of non-negative numbers and a target integer k, write a function
  to check if the array has a continuous subarray of size at least 2 that sums up to
  a multiple of k, that is, sums up to n*k where n is also an integer.
  <p>
  <p>
  <p>
  Example 1:
  <p>
  Input: [23, 2, 4, 6, 7],  k=6
  Output: True
  Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to
  6.
  Example 2:
  <p>
  Input: [23, 2, 6, 4, 7],  k=6
  Output: True
  Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and
  sums up to 42.
  <p>
  <p>
  Note:
  <p>
  The length of the array won't exceed 10,000.
  You may assume the sum of all the numbers is in the range of a signed 32-bit integer.
 */

/**
 * 23, 2, 4, 6, 7
 * 23 23, 25
 * 2  00, 02 06
 * 4
 * 6
 * 7
 */

public class ContinuousSubarraySum {
    public boolean checkSubarraySum(int[] nums, int k) {
        if (nums.length == 1) {
            return false;
        }

        for (int i = 0; i < nums.length; i++) {
            int sum = nums[i];
            for (int j = i + 1; j < nums.length; j++) {
                sum += nums[j];
                if (checkSumForDivisibility(sum, k)) {
                    return true;
                }
            }
        }

        return false;
    }

    private boolean checkSumForDivisibility(int sum, int k) {
        return sum == k || (k != 0 && sum % k == 0);
    }
}

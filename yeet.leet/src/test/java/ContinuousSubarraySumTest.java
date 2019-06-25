import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContinuousSubarraySumTest {

    /*Input: [23, 2, 4, 6, 7],  k=6
 * Output: True
 * Explanation: Because [2, 4] is a continuous subarray of size 2 and sums up to
6.
 * Example 2:
 *
 * Input: [23, 2, 6, 4, 7],  k=6
 * Output: True
 * Explanation: Because [23, 2, 6, 4, 7] is an continuous subarray of size 5 and
sums up to 42.
*/
    @Test
    public void checkSubarraySumOne() {
        int[] nums = new int[]{23, 2, 4, 6, 7};
        int k = 6;
        boolean expectedResult = true;
        boolean actualResult = new ContinuousSubarraySum().checkSubarraySum(nums, k);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkSubarraySumTwo() {
        int[] nums = new int[]{23, 2, 4, 6, 7};
        int k = 6;
        boolean expectedResult = true;
        boolean actualResult = new ContinuousSubarraySum().checkSubarraySum(nums, k);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkSubarraySumThree() {
        int[] nums = new int[]{23,2,6,4,7};
        int k = 0;
        boolean expectedResult = false;
        boolean actualResult = new ContinuousSubarraySum().checkSubarraySum(nums, k);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkSubarraySumFour() {
        int[] nums = new int[]{0,0};
        int k = 0;
        boolean expectedResult = true;
        boolean actualResult = new ContinuousSubarraySum().checkSubarraySum(nums, k);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkSubarraySumFive() {
        int[] nums = new int[]{0};
        int k = 0;
        boolean expectedResult = false;
        boolean actualResult = new ContinuousSubarraySum().checkSubarraySum(nums, k);
        Assert.assertEquals(expectedResult, actualResult);
    }

    @Test
    public void checkSubarraySumSix() {
        int[] nums = new int[]{0,1,0};
        int k = 0;
        boolean expectedResult = false;
        boolean actualResult = new ContinuousSubarraySum().checkSubarraySum(nums, k);
        Assert.assertEquals(expectedResult, actualResult);
    }
}
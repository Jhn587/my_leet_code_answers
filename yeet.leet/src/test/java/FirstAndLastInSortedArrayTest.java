import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class FirstAndLastInSortedArrayTest {

    @Test
    public void searchRangeOne() {
        int[] nums = new int[] {5,7,7,8,8,10};
        int target = 8;
        int[] ints = new FirstAndLastInSortedArray().searchRange(nums, target);
        Assert.assertEquals(3, ints[0]);
        Assert.assertEquals(4, ints[1]);
    }

//    Input: nums = [5,7,7,8,8,10], target = 6
//            * Output: [-1,-1]

    @Test
    public void searchRangeTwoNonPresent() {
        int[] nums = new int[] {5,7,7,8,8,10};
        int target = 6;
        int[] ints = new FirstAndLastInSortedArray().searchRange(nums, target);
        Assert.assertEquals(-1, ints[0]);
        Assert.assertEquals(-1, ints[1]);
    }
    @Test
    public void searchRangeTwoOnlyNumber() {
        int[] nums = new int[] {2,2};
        int target = 2;
        int[] ints = new FirstAndLastInSortedArray().searchRange(nums, target);
        Assert.assertEquals(0, ints[0]);
        Assert.assertEquals(1, ints[1]);
    }
    @Test
    public void searchRangeTwoOneNumber() {
        int[] nums = new int[] {1};
        int target = 1;
        int[] ints = new FirstAndLastInSortedArray().searchRange(nums, target);
        Assert.assertEquals(0, ints[0]);
        Assert.assertEquals(0, ints[1]);
    }
    @Test
    public void searchRangeTwoOneNumberSecondExample() {
        int[] nums = new int[] {1,3};
        int target = 1;
        int[] ints = new FirstAndLastInSortedArray().searchRange(nums, target);
        Assert.assertEquals(0, ints[0]);
        Assert.assertEquals(0, ints[1]);
    }
}
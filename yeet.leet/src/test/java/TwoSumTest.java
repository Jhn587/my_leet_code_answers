import org.junit.Assert;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class TwoSumTest {
//
//    [2,7,11,15]
//            9
//    Expected
//[0,1]
    @Test
    public void testTwoSum()throws Exception {
        TwoSum twoSum = new TwoSum();
        int[] actualResult = twoSum.twoSum(new int[]{2, 7, 11, 15}, 9);
        List<Integer> actualResultList = Arrays.stream(actualResult).boxed().collect(Collectors.toList());
        Integer[] result = {0, 1};
        List<Integer> expectedResultList = Arrays.asList(result);
        Assert.assertEquals(expectedResultList, actualResultList);
    }

    @Test
    public void testTwoDuplicates()throws Exception {
        TwoSum twoSum = new TwoSum();
        int[] actualResult = twoSum.twoSum(new int[]{3,3}, 6);
        List<Integer> actualResultList = Arrays.stream(actualResult).boxed().collect(Collectors.toList());
        Integer[] result = {0, 1};
        List<Integer> expectedResultList = Arrays.asList(result);
        Assert.assertEquals(expectedResultList, actualResultList);
    }
}
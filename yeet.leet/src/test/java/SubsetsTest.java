import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

import static org.junit.Assert.*;

public class SubsetsTest {
    /**
     * * Input: nums = [1,2,3]
     * * Output:
     * * [
     * * [3],
     * * [1],
     * * [2],
     * * [1,2,3],
     * * [1,3],
     * * [2,3],
     * * [1,2],
     * * []
     * * ]
     */

    @Test
    public void subsets() {

        List<List<Integer>> expectedResult = Arrays.asList(

                Collections.singletonList(3),
                Collections.singletonList(1),
                Collections.singletonList(2),
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 3),
                Arrays.asList(2, 3),
                Arrays.asList(1, 2),
                Collections.emptyList()

        );

        Subsets subsets = new Subsets();
        List<List<Integer>> resultingSubsets = subsets.subsets(new int[]{1, 2, 3});
        Assert.assertEquals(new HashSet<>(expectedResult), new HashSet<>(resultingSubsets));
    }
}
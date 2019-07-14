import org.junit.Assert;
import org.junit.Test;

import static org.junit.Assert.*;

public class TrappingRainWaterTest {
// * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
//    0,1,0,2,1,0,1,3,2,1,2,1
    @Test
    public void testOne() throws Exception {
        int[] map = new int[]{0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        int expected = 6;
        int actual = new TrappingRainWater().trap(map);
        Assert.assertEquals(expected, actual);
    }

}
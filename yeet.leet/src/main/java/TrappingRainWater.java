/**
 * 42. Trapping Rain Water
 * Hard
 * https://leetcode.com/problems/trapping-rain-water/
 * 3848
 * <p>
 * 70
 * <p>
 * Favorite
 * <p>
 * Share
 * Given n non-negative integers representing an elevation map where the width of each bar is 1, compute how much water it is able to trap after raining.
 * <p>
 * <p>
 * The above elevation map is represented by array [0,1,0,2,1,0,1,3,2,1,2,1]. In this case, 6 units of rain water (blue section) are being trapped.
 * Thanks Marcos for contributing this image!
 * <p>
 * Example:
 * <p>
 * Input: [0,1,0,2,1,0,1,3,2,1,2,1]
 * Output: 6
 */
public class TrappingRainWater {
    public int trap(int[] height) {
        int[] highestLeftValue = new int[height.length];
        for (int i = 1; i < height.length; i++) {
            highestLeftValue[i] = Math.max(highestLeftValue[i - 1], height[i - 1]);
        }

        int[] highestRightValue = new int[height.length];
        for (int i = height.length - 2; i >= 0; i--) {
            highestRightValue[i] = Math.max(highestRightValue[i + 1], height[i + 1]);
        }

        int totalRain = 0;
        for (int i = 1; i < height.length - 1; i++) {
            int min = Math.min(highestLeftValue[i], highestRightValue[i]);
            if (height[i] < min) {
                totalRain += min - height[i];
            }
        }
        return totalRain;
    }
}

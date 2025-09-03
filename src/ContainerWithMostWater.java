public class ContainerWithMostWater {
    public static void main(String[] args) {
        int[] heights = {1,8,6,2,5,4,8,3,7};
        System.out.println(maxArea(heights));
    }

    /**
     * Find the maximum area of water that can be contained.
     * The algorithm works as below:
     * 1. Initialize two pointers at both ends of the array.
     * 2. Calculate the area and update the maximum area.
     * 3. Move the pointer pointing to the shorter line inward.
     * 
     * @param height The heights of the container walls.
     * @return The maximum area of water.
     */
    private static int maxArea(int[] height) {
        int maxArea = 0;
        int left = 0;
        int right = height.length - 1;

        while (left < right) {
            int width = right - left;
            int minHeight = Math.min(height[left], height[right]);
            maxArea = Math.max(maxArea, width * minHeight);

            // Move the pointer pointing to the shorter line
            if (height[left] < height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return maxArea;
    }
}

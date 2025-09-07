package dynamicprogramming;

public class HouseRobberII {
    public static void main(String[] args) {
        int[] nums = {1,2,3,1};
        int maxAmount = rob(nums);
        System.out.println("Maximum amount that can be robbed: " + maxAmount);
    }

    /**
     * This method calculates the maximum amount of money that can be robbed from a circular arrangement of houses.
     * The algorithm works as below:
     * 1. If there are no houses, return 0.
     * 2. If there is only one house, return the amount in that house.
     * 3. Create two scenarios: one excluding the first house and one excluding the last house.
     * 4. Use a helper method to calculate the maximum amount that can be robbed for both scenarios.
     * 5. Return the maximum of the two scenarios.
     *
     * @param nums an array representing the amount of money in each house
     * @return the maximum amount of money that can be robbed
     */
    private static int rob(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }
        if (nums.length == 1) {
            return nums[0];
        }
        // Case 1: Exclude last house
        int max1 = robLinear(nums, 0, nums.length - 2);
        // Case 2: Exclude first house
        int max2 = robLinear(nums, 1, nums.length - 1);
        return Math.max(max1, max2);
    }

    // Helper for linear house robber
    private static int robLinear(int[] nums, int start, int end) {
        if(start == end) {
            return nums[start];
        }
        int[] dp = new int[end - start + 1];
        dp[0] = nums[start];
        dp[1] = Math.max(nums[start], nums[start + 1]);
        for (int i = 2; i <= end - start; i++) {
            dp[i] = Math.max(dp[i - 2] + nums[start + i], dp[i - 1]);
        }
        return dp[end - start];
    }
}

package dynamicprogramming;

public class HouseRobber {
    public static void main(String[] args) {
        int[] nums = {2, 7, 9, 3, 1};
        int maxAmount = rob(nums);
        System.out.println("Maximum amount that can be robbed: " + maxAmount);
    }

    /**
     * This method calculates the maximum amount of money that can be robbed without robbing two adjacent houses.
     * The algorithm works as below:
     * 1. If there are no houses, return 0.
     * 2. If there is only one house, return the amount in that house.
     * 3. Create a dp array where dp[i] represents the maximum amount that can be robbed from the first i houses.
     * 4. Initialize dp[0] to nums[0] and dp[1] to the maximum of nums[0] and nums[1].
     * 5. For each house from the third to the last, calculate the maximum amount that can be robbed by either 
     *    robbing the current house and adding it to the amount from two houses ago, or skipping the current house 
     *    and taking the amount from the previous house.
     * 6. Return the value in dp corresponding to the last house.
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
        int[] dp = new int[nums.length];
        dp[0] = nums[0];
        dp[1] = Math.max(nums[0], nums[1]);
        for (int i = 2; i < nums.length; i++) {
            dp[i] = Math.max(dp[i - 1], dp[i - 2] + nums[i]);
        }
        return dp[nums.length - 1];
    }
}

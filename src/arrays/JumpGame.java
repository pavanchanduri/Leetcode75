package arrays;

public class JumpGame {
    public static void main(String[] args) {
        int[] nums = {2,3,1,1,4};
        boolean canJump = canJump(nums);
        System.out.println("Can jump to the last index: " + canJump);
    }
    /**
     * This method determines if you can reach the last index of the array starting from the first index.
     * The algorithm works as below:
     * 1. Initialize a variable to keep track of the farthest reachable index.
     * 2. Iterate through each index of the array.
     * 3. For each index, check if it is reachable from the previous indices.
     * 4. If it is reachable, update the farthest reachable index.
     * 5. If at any point the farthest reachable index is greater than or equal to the last index, return true.
     * 6. If the loop ends and the last index is not reachable, return false.
     *
     * @param nums an array where each element represents the maximum jump length at that position
     * @return true if you can reach the last index, false otherwise
     */
    private static boolean canJump(int[] nums) {
        int farthest = 0;
        for (int i = 0; i < nums.length; i++) {
            if (i > farthest) { // If the current index is beyond the farthest reachable index
                return false;
            }
            farthest = Math.max(farthest, i + nums[i]); // Update the farthest reachable index
            if (farthest >= nums.length - 1) { // If we can reach or exceed the last index
                return true;
            }
        }
        return false;
    }
}

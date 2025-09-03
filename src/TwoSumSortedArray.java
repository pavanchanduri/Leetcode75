public class TwoSumSortedArray {
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15};
        int target = 9;
        int[] result = twoSum(nums, target);
        if (result != null) {
            System.out.println("Indices found: " + result[0] + ", " + result[1]);
        } else {
            System.out.println("No two sum solution found.");
        }
    }

    /**
     * Find two numbers in a sorted array that add up to a target sum.
     * The algorithm works as below:
     * 1. Initialize two pointers: left and right.
     * 2. While left is less than right, check the sum of the two numbers.
     * 3. If the sum is equal to the target, return the indices.
     * 4. If the sum is less than the target, move the left pointer to the right.
     * 5. If the sum is greater than the target, move the right pointer to the left.
     *
     * @param nums The input array.
     * @param target The target sum.
     * @return An array containing the indices of the two numbers, or null if not found.
     */
    private static int[] twoSum(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int sum = nums[left] + nums[right];
            if (sum == target) {
                return new int[]{left, right};
            } else if (sum < target) {
                left++;
            } else {
                right--;
            }
        }
        return null; // No solution found
    }
}

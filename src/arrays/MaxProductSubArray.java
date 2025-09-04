package arrays;
public class MaxProductSubArray {

    public static void main(String[] args) {
        int[] arr = {2, 3, -2, 4};
        int result = maxProductSubArray(arr);
        System.out.println(result);
    }


    /**
     * Find the maximum product subarray in a given array.
     * The algorithm works as below:
     * 1. Initialize three variables: maxSoFar, minSoFar, and maxProduct.
     * 2. Iterate through the array, updating maxSoFar and minSoFar at each step.
     * 3. Update maxProduct if maxSoFar is greater than the current maxProduct.
     * 
     * @param nums The input array.
     * @return The maximum product of a contiguous subarray.
     */
    private static int maxProductSubArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            return 0;
        }

        int maxSoFar = nums[0];
        int minSoFar = nums[0];
        int maxProduct = nums[0];

        for(int i=1;i<nums.length;i++) {
            int current = nums[i];
            int temp = Math.max(current, Math.max(maxSoFar * current, minSoFar * current));
            minSoFar = Math.min(current, Math.min(maxSoFar * current, minSoFar * current));
            maxSoFar = temp;
            maxProduct = Math.max(maxProduct, maxSoFar);
        }

        return maxProduct;
    }
}

package arrays;
import java.util.Arrays;

public class ProductOfNumbersOtherThanItself {
    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5};
        int[] result = product(arr);
        System.out.println(Arrays.toString(result));

    }

    /**
     * Calculate the product of all numbers in the array except itself.
     * The algorithm works as below:
     * 1. Initialize an output array of the same length as the input array.
     * 2. Iterate through the input array from left to right, maintaining a running product.
     * 3. For each element, set the corresponding output element to the running product.
     * 4. Iterate through the input array from right to left, maintaining another running product.
     * 5. For each element, multiply the corresponding output element by the running product.
     * @param nums
     * @return
     */
    private static int[] product(int[] nums) {
        int n = nums.length;
        int[] result = new int[n];
        int prefix=1, postfix=1;

        for (int i = 0; i < n; i++) {
            result[i] = prefix;
            prefix *= nums[i];
        }

        for (int i = n - 1; i >= 0; i--) {
            result[i] *= postfix;
            postfix *= nums[i];
        }

        return result;
    }
}
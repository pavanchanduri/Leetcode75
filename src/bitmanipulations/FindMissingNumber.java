package bitmanipulations;
public class FindMissingNumber {
    public static void main(String[] args) {
        int[] arr = {9, 6, 4, 2, 3, 5, 7, 0, 1, 8};
        int missingNumber = findMissingNumber(arr);
        System.out.println("Missing number: " + missingNumber);
        int missingNumberXOR = findMissingNumberXOR(arr);
        System.out.println("Missing number (XOR): " + missingNumberXOR);
    }

    /**
     * Find the missing number in an array containing n distinct numbers taken from 0, 1, 2, ..., n.
     * @param nums The input array.
     * @return The missing number.
     */
    private static int findMissingNumber(int[] nums) {
        int n = nums.length;
        int expectedSum = n * (n + 1) / 2;
        int actualSum = 0;
        for (int num : nums) {
            actualSum += num;
        }
        return expectedSum - actualSum;
    }

    /**
     * Find the missing number in an array containing n distinct numbers taken from 0, 1, 2, ..., n.
     * The algorithm works as below:
     * 1. Initialize a variable `xor` to 0.
     * 2. XOR all the elements in the array with `xor`. (value xor)
     * 3. XOR all the numbers from 0 to n with `xor`. (range xor)
     * 4. The result will be the missing number, as xor with itself cancels out the numbers.
     *
     * @param nums The input array.
     * @return The missing number.
     */
    private static int findMissingNumberXOR(int[] nums) {
        int n = nums.length;
        int xor = 0;
        for (int i = 0; i < n; i++) {
            xor ^= nums[i];
        }
        for (int i = 0; i <= n; i++) {
            xor ^= i;
        }
        return xor;
    }
}

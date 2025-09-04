package binarysearch;
public class MinimumInRotatedSortedArray {

    public static void main(String[] args) {
        int[] arr = {4, 5, 6, 7, 0, 1, 2};
        int result = findMinInRotatedArray(arr);
        System.out.println(result);
    }

    /**
     * Find the minimum element in a rotated sorted array.
     * The algorithm works as below:
     * 1. Initialize two pointers: left and right.
     * 2. While left is less than right, calculate the mid index.
     * 3. If the element at mid is greater than the element at right,
     *    it means the minimum is in the right half, so update left.
     * 4. Otherwise, update right to narrow down the search.
     * 
     * @param nums The input array.
     * @return The minimum element in the array.
     */
    private static int findMinInRotatedArray(int[] nums) {
        if (nums == null || nums.length == 0) {
            throw new IllegalArgumentException("Invalid input");
        }

        int left = 0;
        int right = nums.length - 1;

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] > nums[right]) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }

        return nums[left]; // The minimum element in the rotated sorted array.
    }

}

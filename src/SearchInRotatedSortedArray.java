public class SearchInRotatedSortedArray {
    public static void main(String[] args) {
        int[] arr = {4,5,6,7,0,1,2};
        int target = 0;
        int result = search(arr, target);
        System.out.println(result);
    }

    /**
     * Search for a target value in a rotated sorted array.
     * The algorithm works as below:
     * 1. Initialize two pointers: left and right.
     * 2. While left is less than or equal to right, calculate the mid index.
     * 3. If the element at mid is equal to the target, return mid.
     * 4. If the left half is sorted, check if the target is in the left half.
     * 5. If the right half is sorted, check if the target is in the right half.
     * @param nums The input array.
     * @param target The target value to search for.
     * @return The index of the target value, or -1 if not found.
     */
    private static int search(int[] nums, int target) {
        if (nums == null || nums.length == 0) {
            return -1;
        }

        int left = 0;
        int right = nums.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            if (nums[mid] == target) {
                return mid;
            }

            // If the left half is sorted
            if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) { // Target is in the left half
                    right = mid - 1; // Search in the left half
                } else {
                    left = mid + 1; // Search in the right half
                }
            } else {
                // If the right half is sorted
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // Search in the right half
                } else {
                    right = mid - 1; // Search in the left half
                }
            }
        }
        return -1; // Target not found
    }
}

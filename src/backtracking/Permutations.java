package backtracking;

public class Permutations {
    public static void main(String[] args) {
        int[] nums = {1, 2, 3};
        System.out.println("Permutations of the array:");
        permute(nums, 0);
    }

    /**
     * Generates all permutations of the array nums starting from index start.
     * The algorithm works as follows:
     * 1. If the start index reaches the length of the array, it means we have a complete permutation,
     *    so we print the current arrangement of the array.
     * 2. Otherwise, we iterate through the array from the start index to the end.
     * 3. For each index i, we swap the element at the start index with the element at index i.
     * 4. We then recursively call the permute function with the next index (start + 1).
     * 5. After returning from the recursive call, we swap back the elements to backtrack and restore the original array state.
     * This process continues until all permutations are generated.
     * 
     * @param nums the array to permute
     * @param start the starting index for permutation
     */
    private static void permute(int[] nums, int start) {
        if (start >= nums.length) {
            printArray(nums);
            return;
        }
        for (int i = start; i < nums.length; i++) {
            swap(nums, start, i);
            permute(nums, start + 1);
            swap(nums, start, i); // backtrack
        }
    }

    private static void swap(int[] nums, int i, int j) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
    }

    private static void printArray(int[] nums) {
        for (int num : nums) {
            System.out.print(num + " ");
        }
        System.out.println();
    }
}

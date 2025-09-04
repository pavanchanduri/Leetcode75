package arrays;
import java.util.HashSet;
import java.util.Set;

public class ContainsDuplicate {
    
    public static void main(String[] args) {
        int[] nums = {1,2,2,3,4,5,6,7};
        boolean result = containsDuplicate(nums);
        System.out.println(result);
    }

    /**
     * Check if the array contains duplicates.
     * The algorithm works as below:
     * 1. Use a HashSet to track seen numbers.
     * 2. Iterate through the array.
     * 3. If a number is already in the set, return true.
     * 4. If no duplicates are found, return false.
     *
     * @param nums The input array.
     * @return True if duplicates are found, false otherwise.
     */
    private static boolean containsDuplicate(int[] nums) {
        Set<Integer> seen = new HashSet<>();
        for (int num : nums) {
            if (seen.contains(num)) {
                return true;
            }
            seen.add(num);
        }
        return false;
    }
}

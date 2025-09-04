package binarysearch;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;

public class Triplets {

    /**
     * Find all unique triplets in the array that sum up to zero.
     * The algorithm works as below:
     * 1. Sort the input array.
     * 2. Iterate through the array, fixing one element and using two pointers to find the other two.
     * 3. Skip duplicates to ensure unique triplets.
     *
     * @param arr The input array.
     * @return A list of lists containing the unique triplets.
     */
    public static List<List<Integer>> findTriplets(int[] arr) {
        Arrays.sort(arr);
        int n = arr.length;
        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && arr[i] == arr[i - 1]) continue;

            int left = i + 1, right = n - 1;
            while (left < right) {
                int sum = arr[i] + arr[left] + arr[right];
                if (sum == 0) {
                    result.add(Arrays.asList(arr[i], arr[left], arr[right]));
                    while (left < right && arr[left] == arr[left + 1]) left++;
                    while (left < right && arr[right] == arr[right - 1]) right--;
                    left++;
                    right--;
                } else if (sum < 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }

    public static void main(String[] args) {
        int[] arr = {-1,0,1,2,-1,-4};
        System.out.println(findTriplets(arr));
    }
}
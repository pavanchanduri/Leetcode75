package dynamicprogramming;

import java.util.ArrayList;
import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int lisLength = longestIncreasingSubsequence(arr);
        System.out.println("Length of Longest Increasing Subsequence: " + lisLength);
        int lisLengthOptimized = longestIncreasingSubsequenceOptimized(arr);
        System.out.println("Length of Longest Increasing Subsequence (Optimized): " + lisLengthOptimized);
    }

    /**
     * This method calculates the length of the longest increasing subsequence in the given array.
     * The algorithm works as below:
     * 1. Initialize a dp array where dp[i] represents the length of the longest increasing subsequence ending at index i.
     * 2. For each element in the array, compare it with all previous elements to find increasing subsequences.
     * 3. Update the dp array accordingly.
     * 4. Finally, return the maximum value from the dp array which represents the length of the longest increasing subsequence.
     *
     * @param arr an array of integers
     * @return the length of the longest increasing subsequence
     */
    private static int longestIncreasingSubsequence(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int n = arr.length;
        int[] dp = new int[n];
        Arrays.fill(dp, 1); // Each element is an increasing subsequence of length 1

        for (int i = 1; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (arr[i] > arr[j]) {
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int maxLength = 0;
        for (int length : dp) {
            maxLength = Math.max(maxLength, length);
        }

        return maxLength;
    }

    /**
     * This method calculates the length of the longest increasing subsequence in the given array using an optimized approach with binary search.
     * The algorithm works as below:
     * 1. Initialize an empty list to store the smallest tail of all increasing subsequences found so far.
     * 2. For each element in the array, use binary search to find the position of the element in the list.
     * 3. If the element is larger than the largest element in the list, append it to the list.
     * 4. Otherwise, replace the first element in the list which is greater than or equal to the element.   
     * 5. The length of the list at the end will be the length of the longest increasing subsequence.
     *
     * @param arr an array of integers
     * @return the length of the longest increasing subsequence
     */
    private static int longestIncreasingSubsequenceOptimized(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }
        ArrayList<Integer> sub = new ArrayList<>();
        for (int num : arr) {
            if (sub.size() == 0 || num > sub.get(sub.size() - 1)) {
                sub.add(num);
            } else {
                int idx = binarySearch(sub, num);
                sub.set(idx, num);
            }
        }
        return sub.size();
    }

    /**
     * Helper method to perform binary search on the list to find the index of the target.
     * The algorithm works as below:
     * 1. Initialize two pointers, left and right, to the start and end of the list.
     * 2. While left is less than right, calculate the mid index.
     * 3. If the element at mid is less than the target, move the left pointer to mid + 1.
     * 4. Otherwise, move the right pointer to mid.
     * 5. Return the left pointer which will be the index of the target or the
     * smallest element greater than the target.
     *
     * @param sub the list of integers
     * @param target the target integer
     * @return the index of the target or the smallest element greater than the target
     */
    private static int binarySearch(ArrayList<Integer> sub, int target) {
        int left = 0;
        int right = sub.size() - 1;
        while (left < right) {
            int mid = (left + right) / 2;
            if (sub.get(mid) < target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        return left;
    }
}

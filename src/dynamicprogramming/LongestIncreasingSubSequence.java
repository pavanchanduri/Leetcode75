package dynamicprogramming;

import java.util.Arrays;

public class LongestIncreasingSubSequence {
    public static void main(String[] args) {
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60, 80};
        int lisLength = longestIncreasingSubsequence(arr);
        System.out.println("Length of Longest Increasing Subsequence: " + lisLength);
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
}

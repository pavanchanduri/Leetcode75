package dynamicprogramming;

public class LongestCommonSubSequence {
    public static void main(String[] args) {
        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";
        System.out.println("Length of Longest Common Subsequence is: " + lcs(s1, s2));
    }


    /**
     * Function to find the length of the longest common subsequence
     * The algorithm works as follows:
     * 1. Create a 2D array dp where dp[i][j] represents the length of the longest common subsequence
     *    of the first i characters of s1 and the first j characters of s2.
     * 2. Initialize the first row and first column of dp to 0, since the longest common subsequence
     *    of any string with an empty string is 0.
     * 3. Iterate through each character of both strings.
     *    - If the characters match (s1[i-1] == s2[j-1]), then dp[i][j] = dp[i-1][j-1] + 1.
     *    - If the characters do not match, then dp[i][j] = max(dp[i-1][j], dp[i][j-1]).
     * 4. The value at dp[m][n] will be the length of the longest common subsequence of s1 and s2,
     *    where m and n are the lengths of s1 and s2 respectively.
     * 5. Return dp[m][n].
     * 
     * @param s1 first string
     * @param s2 second string
     * @return length of longest common subsequence
     */
    private static int lcs(String s1, String s2) {
        int m = s1.length();
        int n = s2.length();
        int[][] dp = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (s1.charAt(i - 1) == s2.charAt(j - 1)) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }
}

package dynamicprogramming;

public class DecodeWays {
    public static void main(String[] args) {
        String s = "226";
        int ways = numDecodings(s);
        System.out.println("Number of ways to decode: " + ways);
    }

    /**
     * This method calculates the number of ways to decode a given string of digits.
     * The algorithm works as below:
     * 1. If the string is empty or starts with '0', return 0 as it cannot be decoded.
     * 2. Create a dp array where dp[i] represents the number of ways to decode the substring of length i.
     * 3. Initialize dp[0] to 1 (an empty string has one way to be decoded) and dp[1] to 1 (a single non-zero digit can be decoded in one way).
     * 4. For each character in the string from the second character onwards, check if it can form a valid single-digit or two-digit decode.
     * 5. Update the dp array based on these checks.
     * 6. Return the value in dp corresponding to the full length of the string.
     *
     * @param s the input string of digits
     * @return the number of ways to decode the string
     */
    private static int numDecodings(String s) {
        if (s == null || s.length() == 0 || s.charAt(0) == '0') {
            return 0;   
        }
        int n = s.length();
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 2; i <= n; i++) {
            int oneDigit = Integer.parseInt(s.substring(i - 1, i));
            int twoDigits = Integer.parseInt(s.substring(i - 2, i));
            if (oneDigit >= 1) {
                dp[i] += dp[i - 1];
            }
            if (twoDigits >= 10 && twoDigits <= 26) {
                dp[i] += dp[i - 2];
            }
        }
        return dp[n];
    }
}

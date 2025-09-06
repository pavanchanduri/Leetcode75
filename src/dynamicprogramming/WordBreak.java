package dynamicprogramming;

public class WordBreak {
    public static void main(String[] args) {
        String s = "leetcode";
        String[] wordDict = {"leet", "code"};
        boolean canSegment = wordBreak(s, wordDict);
        System.out.println("Can the string be segmented? " + canSegment);
    }

    /**
     * This method checks if the given string can be segmented into a space-separated
     * sequence of one or more dictionary words.
     * The algorithm works as below:
     * 1. Initialize a dp array where dp[i] indicates if the substring s[0..i-1] can be segmented.
     * 2. Iterate through the string and for each position, check all possible previous positions
     *    to see if the substring between them is in the word dictionary.
     * 3. If a valid segmentation is found, mark dp[i] as true.
     * 4. Finally, return the value in dp corresponding to the full length of the string.
     *
     * @param s        the input string to be segmented
     * @param wordDict an array of valid words
     * @return true if the string can be segmented, false otherwise
     */
    private static boolean wordBreak(String s, String[] wordDict) {
        boolean[] dp = new boolean[s.length() + 1];
        dp[0] = true; // Base case: empty string can be segmented

        for (int i = 1; i <= s.length(); i++) {
            for (String word : wordDict) {
                int wordLen = word.length();
                if (i >= wordLen && dp[i - wordLen] && s.substring(i - wordLen, i).equals(word)) {
                    dp[i] = true;
                    break;
                }
            }
        }
        return dp[s.length()];
    }
}

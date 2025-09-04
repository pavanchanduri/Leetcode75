package arrays;

public class ClimbStairs {
    public static void main(String[] args) {
        int n = 4;
        System.out.println(climbStairs(n));
    }

    /**
     * Climb Stairs
     * The algorithm works as below:
     * 1. If there is 1 step, there is 1 way to climb it.
     * 2. If there are 2 steps, there are 2 ways to climb it.
     * 3. For more than 2 steps, the number of ways to reach the nth step 
     * is the sum of the ways to reach the (n-1)th and (n-2)th steps.
     * 
     * @param n
     * @return
     */
    private static int climbStairs(int n) {
        if (n == 1) return 1;
        if (n == 2) return 2;
        int[] dp = new int[n + 1];
        dp[1] = 1;
        dp[2] = 2;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }
}

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
        if (n == 1)
            return 1;
        int one = 1;
        int two = 2;
        int result = 0;
        for (int i = 3; i <= n; i++) {
            result = one + two;
            one = two;
            two = result;
        }
        /**
         * We return two because we are starting from the third step.
         * If we start from the first step, we would need to return one.
         * If n==2, we need to return two and not total.
         */
        return two;
    }
}

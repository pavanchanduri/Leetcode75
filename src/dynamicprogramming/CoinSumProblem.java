package dynamicprogramming;

public class CoinSumProblem {
    public static void main(String[] args) {
        int[] coins = {1, 2, 5};
        int amount = 11;
        int minCoins = coinChange(coins, amount);
        System.out.println("Minimum coins needed: " + minCoins);
    }

    /**
     * This method calculates the minimum number of coins needed to make up the given amount.
     * The algorithm works as below:
     * 1. Initialize a dp array of size (amount + 1) with a value greater than any possible answer.
     * 2. For each coin denomination, iterate from the coin value to the target amount.
     * 3. For each iteration, update the dp array with the minimum number of coins needed to make up the current amount.
     * 4. Finally, return the value in the dp array corresponding to the target amount, or -1 if it's not possible to make up the amount.
     *
     * @param coins  an array of coin denominations
     * @param amount the target amount to be made up
     * @return the minimum number of coins needed, or -1 if it's not possible to make up the amount
     */
    private static int coinChange(int[] coins, int amount) {
        int[] dp = new int[amount + 1];
        int[] lastCoin = new int[amount + 1]; // To track the last coin used for each amount
        for (int i = 1; i <= amount; i++) {
            dp[i] = amount + 1;
            lastCoin[i] = -1;
        }
        dp[0] = 0;

        for (int coin : coins) {
            for (int i = coin; i <= amount; i++) {
                if (dp[i] > dp[i - coin] + 1) {
                    dp[i] = dp[i - coin] + 1;
                    lastCoin[i] = coin;
                }
            }
        }

        if (dp[amount] > amount) {
            System.out.println("Not possible to make up the amount with given coins.");
            return -1;
        }

        // Reconstruct coins used
        System.out.print("Coins used: ");
        int curr = amount;
        while (curr > 0) {
            System.out.print(lastCoin[curr] + " ");
            curr -= lastCoin[curr];
        }
        System.out.println();
        return dp[amount];
    }
}

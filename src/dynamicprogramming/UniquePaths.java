package dynamicprogramming;

public class UniquePaths {
    public static void main(String[] args) {
        int m = 3, n = 8;
        int paths = uniquePaths(m, n);
        System.out.println("Number of unique paths: " + paths);
    }

    /**
     * This method calculates the number of unique paths from the top-left corner to the bottom-right corner of an m x n grid.
     * The algorithm works as below:
     * 1. Create a 2D dp array where dp[i][j] represents the number of unique paths to reach cell (i, j).
     * 2. Initialize the first row and first column to 1, as there is only one way to reach any cell in the first row or first column.
     * 3. For each cell in the grid, calculate the number of unique paths to that cell by summing the number of paths to the cell directly above
     *    it and the cell directly to the left of it.
     * 4. Return the value in dp[m-1][n-1], which represents the number of unique paths to the bottom-right corner.
     *
     * @param m the number of rows in the grid
     * @param n the number of columns in the grid
     * @return the number of unique paths
     */
    private static int uniquePaths(int m, int n) {
        int[][] dp = new int[m][n];
        for (int i = 0; i < m; i++) {
            dp[i][0] = 1;
        }
        for (int j = 0; j < n; j++) {
            dp[0][j] = 1;
        }
        for (int i = 1; i < m; i++) {
            for (int j = 1; j < n; j++) {
                dp[i][j] = dp[i - 1][j] + dp[i][j - 1];
            }
        }
        return dp[m - 1][n - 1];
    }
}

package bitmanipulations;
public class CountingBitsInNumberArray {
    public static void main(String[] args) {
        int num = 5;
        int[] result = countBits(num);
        for (int i = 0; i <= num; i++) {
            System.out.println("Number: " + i + ", Count of 1 bits: " + result[i]);
        }
    }

    /**
     * Count the number of 1 bits in the binary representation of each number from 0 to n.
     * The algorithm works as below:
     * 1. Initialize an array of size n+1 to store the count of 1 bits for each number.
     * 2. Iterate through each number from 1 to n and calculate the count of 1 bits using the relation:
     *    count[i] = count[i & (i - 1)] + 1
     *    E.g., count[5] = count[4] + 1 = 2
     *          count[4] = count[0] + 1 = 1
     * 3. Return the count array.
     * @param n The input integer.
     * @return An array where the i-th element is the count of 1 bits in i.
     */
    private static int[] countBits(int n) {
        int[] count = new int[n + 1];
        for (int i = 1; i <= n; i++) {
            count[i] = count[i & (i - 1)] + 1;
        }
        return count;
    }
}

package bitmanipulations;

public class CountBitOnesInNumber {

    public static void main(String[] args) {
        int num = 36;
        System.out.println("Number of 1 bits: " + countOnes(num));
        System.out.println("Number of 1 bits (Binary Representation): " + countOnesUsingBinaryRepresentation(num));
    }

    /**
     * Count the number of 1 bits in an integer.
     * Idea - When the given number is AND operated with (n - 1), it removes the lowest set bit.
     * E.g., if the given number is 36 i.e., 100100 in binary, the process will be:
     * 1st operation: 100100 (36) & 100011 (35) = 100000 (32) (removes the last 1)
     * 2nd operation: 100000 (32) & 011111 (31) = 000000 (removes the last 1)
     *
     * @param n The input integer.
     * @return The number of 1 bits.
     */
    private static int countOnes(int n) {
        int count = 0;
        while (n != 0) {
            n = n & (n - 1);
            count++;
        }
        return count;
    }

    /**
     * Count the number of 1 bits in an integer using its binary representation.
     * Idea - Convert the integer to its binary representation and count the number of 1s.
     * 
     * @param n The input integer.
     * @return The number of 1 bits.
     */
    private static int countOnesUsingBinaryRepresentation(int n) {
        String binaryString = Integer.toBinaryString(n);
        int count = 0;
        for (char bit : binaryString.toCharArray()) {
            if (bit == '1') {
                count++;
            }
        }
        return count;
    }

}

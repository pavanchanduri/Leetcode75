package bitmanipulations;
public class ReverseBits {
    public static void main(String[] args) {
        int num = 5;
        int reversed = reverseBits(num);
        System.out.println("Original: " + num + ", Reversed: " + reversed);
    }

    /**
     * Reverse the bits of a given 32-bit unsigned integer.
     * The algorithm works as below:
     * 1. Initialize a variable to store the reversed bits.
     * 2. Iterate through each bit of the input integer.
     * 3. For each bit, shift the reversed variable to the left and add the current bit.
     * 4. Shift the input integer to the right to process the next bit.
     * 5. Return the reversed integer.
     *
     * @param n The input integer.
     * @return The integer with its bits reversed.
     */
    private static int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed <<= 1; // Shift reversed to the left
            reversed |= (n & 1); // Add the current bit of n to reversed
            n >>= 1; // Shift n to the right
        }
        return reversed;
    }
}

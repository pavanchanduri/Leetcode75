package bitmanipulations;
public class ReverseBits {
    public static void main(String[] args) {
        int num = 5;
        int reversed = reverseBits(num);
        System.out.println("Original: " + num + ", Reversed: " + reversed);
    }

    /**
     * Reverse the bits of a given 32-bit unsigned integer.
     * @param n The input integer.
     * @return The integer with its bits reversed.
     */
    private static int reverseBits(int n) {
        int reversed = 0;
        for (int i = 0; i < 32; i++) {
            reversed <<= 1;
            reversed |= (n & 1);
            n >>= 1;
        }
        return reversed;
    }
}

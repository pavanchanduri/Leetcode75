public class SumOfTwoNumbers {
    public static void main(String[] args) {
        int a = 5, b=3;
        System.out.println("Sum: " + sum(a, b));
    }

    /**
     * Calculate sum of two numbers without using + or -
     * The algorithm works as below:
     * 1. Use bitwise XOR to add the numbers without carrying.
     * 2. Use bitwise AND and left shift to calculate the carry.
     * 3. Repeat until there is no carry.
     * 
     * @param a
     * @param b
     * @return
     */
    private static int sum(int a, int b) {
        
        while (b != 0) {
            int carry = a & b;
            a = a ^ b;
            b = carry << 1;
        }
        return a;
    }
}

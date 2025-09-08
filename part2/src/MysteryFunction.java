public class MysteryFunction {
    public static void main(String[] args) {
        int[] data = {12, 4, 6, 9, 2};
        for (int i = 0; i < data.length; i++) {
            data[i] = sumOfDigitSquares(data[i]);
        }
        for (int value : data) {
            System.out.println(value);
        }
    }

    /**
     * Calculate sum of the squares of all digits.
     * For example: 12 -> 1^2 + 2^2 = 5
     *
     * @param input
     * @return
     */
    public static int sumOfDigitSquares(int input) {
        input = Math.abs(input);  // Handle negative number
        int result = 0;
        while (input > 0) {
            result += Math.pow(input % 10, 2);  // leverage built-in Math function instead of computing twice
            input /= 10;
        }
        return result;
    }
}

public class Solution {
    public int romanToInt(String s) {
        int result = 0;

        // Iterate through the Roman numeral from right to left
        for (int i = s.length() - 1; i >= 0; i--) {
            char currentChar = s.charAt(i);

            switch (currentChar) {
                case 'I':
                    result += (result >= 5) ? -1 : 1;
                    break;
                case 'V':
                    result += 5;
                    break;
                case 'X':
                    result += 10 * ((result >= 50) ? -1 : 1);
                    break;
                case 'L':
                    result += 50;
                    break;
                case 'C':
                    result += 100 * ((result >= 500) ? -1 : 1);
                    break;
                case 'D':
                    result += 500;
                    break;
                case 'M':
                    result += 1000;
                    break;
                default:
                    // Handle invalid characters if needed
                    break;
            }
        }

        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        // Example usage:
        String romanNumeral = "XXVII";
        int result = solution.romanToInt(romanNumeral);
        System.out.println(result); // Output: 27
    }
}

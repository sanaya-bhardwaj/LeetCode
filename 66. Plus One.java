//You are given a large integer represented as an integer array digits, where each digits[i] is the ith digit of the integer. 
//The digits are ordered from most significant to least significant in left-to-right order. 
//The large integer does not contain any leading 0's.
//Increment the large integer by one and return the resulting array of digits.

//SOLUTION:

 class Solution {
    public int[] plusOne(int[] digits) {
        int n = digits.length;

        // Iterate from right to left
        for (int i = n - 1; i >= 0; i--) {
            // Increment the current digit
            digits[i]++;
            
            // Check for carry
            if (digits[i] <= 9) {
                // If no carry, return the modified array
                return digits;
            } else {
                // If there's a carry, set the current digit to 0 and continue the loop
                digits[i] = 0;
            }
        }

        // If there's still a carry after the loop, we need to add a new digit at the beginning
        int[] result = new int[n + 1];
        result[0] = 1;

        return result;
    }
}

//This solution iterates through the digits from right to left, incrementing each digit and checking for a carry. 
//If there is a carry, it sets the current digit to 0 and continues the loop.
//If there's still a carry after the loop, it means a new digit needs to be added at the beginning of the array.

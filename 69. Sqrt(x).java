//Given a non-negative integer x, return the square root of x rounded down to the nearest integer. The returned integer should be non-negative as well.
//You must not use any built-in exponent function or operator.
//For example, do not use pow(x, 0.5) in c++ or x ** 0.5 in python.

//Solution:
class Solution {
    public int mySqrt(int x) {
        // Base case: 0 and 1 have the same square root
        if (x == 0 || x == 1) {
            return x;
        }

        // Binary search to find the square root
        long left = 1;
        long right = x;
        long result = 0;

        while (left <= right) {
            long mid = left + (right - left) / 2;

            // Check if mid^2 is less than or equal to x
            if (mid * mid <= x) {
                // Update the result and move to the right half
                result = mid;
                left = mid + 1;
            } else {
                // Move to the left half
                right = mid - 1;
            }
        }

        // Convert the result to an integer and return
        return (int) result;
    }
}

//This code performs a binary search between 1 and x to find the square root. 
//The key idea is to check whether the square of the middle value (mid * mid) is less than or equal to x. 
//If true, update the result and search in the right half; otherwise, search in the left half. 
//The result is rounded down to the nearest integer.
//Note: The result variable is declared as long to handle cases where the square root is large and could overflow the int range.

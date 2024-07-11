You are given a string s that consists of lower case English letters and brackets.

Reverse the strings in each pair of matching parentheses, starting from the innermost one.

Your result should not contain any brackets.

class Solution {
    public String reverseParentheses(String s) {
        int length = s.length(); // Length of the input string.
        int[] pairIndex = new int[length]; // Array to keep track of the indices of matching parentheses.
        Deque<Integer> stack = new ArrayDeque<>(); // Stack to hold the indices of the '(' characters.

        // First pass: Find pairs of parentheses and record their indices.
        for (int i = 0; i < length; ++i) {
            if (s.charAt(i) == '(') {
                // When we encounter an opening parenthesis, we push its index onto the stack.
                stack.push(i);
            } else if (s.charAt(i) == ')') {
                // When we encounter a closing parenthesis, we pop the index of the corresponding
                // opening parenthesis from the stack and record the pairing in the pairIndex array.
                int j = stack.pop();
                pairIndex[i] = j;
                pairIndex[j] = i;
            }
        }

        StringBuilder result = new StringBuilder(); // StringBuilder to construct the resulting string.
        int index = 0; // Current index in the input string.
        int direction = 1; // Direction of iteration: 1 for forward, -1 for backward.

        // Second pass: Construct the result using the paired indices to reverse substrings as needed.
        while (index < length) {
            if (s.charAt(index) == '(' || s.charAt(index) == ')') {
                // If the current character is a parenthesis, we switch direction and jump to its pair.
                index = pairIndex[index];
                direction = -direction;
            } else {
                // Otherwise, we append the current character to the result.
                result.append(s.charAt(index));
            }
            index += direction; // Move to the next character in the current direction.
        }

        return result.toString(); // Convert the StringBuilder to a String and return it.
    }
}

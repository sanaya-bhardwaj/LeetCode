//Write a function to find the longest common prefix string amongst an array of strings.
//If there is no common prefix, return an empty string "".

public class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        }

        // Sort the strings to make it easier to find the common prefix
        Arrays.sort(strs);

        // Take the first and last strings after sorting
        String firstStr = strs[0];
        String lastStr = strs[strs.length - 1];

        // Find the common prefix between the first and last strings
        StringBuilder commonPrefix = new StringBuilder();
        for (int i = 0; i < firstStr.length(); i++) {
            if (i < lastStr.length() && firstStr.charAt(i) == lastStr.charAt(i)) {
                commonPrefix.append(firstStr.charAt(i));
            } else {
                break;
            }
        }

        return commonPrefix.toString();
    }

    // Example usage:
    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] inputStrings = {"flower", "flow", "flight"};
        String result = solution.longestCommonPrefix(inputStrings);
        System.out.println("Longest common prefix: " + result);
    }
}

//In this example, the function first sorts the input array of strings. 
//Then, it compares the first and last strings in the sorted list to find the common prefix. 
//If there is no common prefix, the function returns an empty string.

//Given a string s consisting of words and spaces, return the length of the last word in the string.
//A word is a maximal substring consisting of non-space characters only.

 SOLUTION:

class Solution {
    public int lengthOfLastWord(String s) {
        // Split the string by spaces
        String[] words = s.split(" ");
        
        // Find the last non-empty word
        for (int i = words.length - 1; i >= 0; i--) {
            if (!words[i].isEmpty()) {
                // Return the length of the last word found
                return words[i].length();
            }
        }
        
        // If no non-empty word is found, return 0
        return 0;
    }
}


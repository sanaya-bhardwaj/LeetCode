//Given a string s consisting of words and spaces, return the length of the last word in the string.
//A word is a maximal substring consisting of non-space characters only.

//SOLUTION:

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

//This approach utilizes the split method to break the input string into an array of words based on spaces. 
//Then, it iterates from the end of the array to find the last non-empty word and returns its length. 
//If there are no non-empty words, it returns 0.

//You are given two strings word1 and word2. Merge the strings by adding letters in alternating order, starting with word1. 
//If a string is longer than the other, append the additional letters onto the end of the merged string.
//Return the merged string.

//Approach 1: Brute Force Approach

//Iterate through both strings and concatenate characters alternately to a result string. 
//This method involves direct string concatenation, which can be inefficient.

//Time complexity: O(n^2)
//Space complexity: O(n)

//Code:

class Solution {
   public String mergeAlternately(String word1, String word2) {
       
       String result = "";
       int len1 = word1.length();
       int len2 = word2.length();
       int maxLength = Math.max(len1, len2);

       for (int i = 0; i < maxLength; i++) {
           if (i < len1) {
               result += word1.charAt(i);
           }
           if (i < len2) {
               result += word2.charAt(i);
           }
       }
       return result;
   }
}

//Approach 2: Using StringBuilder

//Using StringBuilder is more efficient for string manipulation since it allows appending characters in constant time. 
//This approach builds the merged string in a more optimal way compared to direct string concatenation.

//Time complexity: O(n)
//Space complexity: O(n)

//Code

class Solution {
    public String mergeAlternately(String word1, String word2) {
        
        StringBuilder result = new StringBuilder();
        int len1 = word1.length();
        int len2 = word2.length();
        int maxLength = Math.max(len1, len2);

        for (int i = 0; i < maxLength; i++) {
            if (i < len1) {
                result.append(word1.charAt(i));
            }
            if (i < len2) {
                result.append(word2.charAt(i));
            }
        }
        return result.toString();
    }
}

//Approach 3: Two-pointers Approach

//Using two pointers to iterate through both strings simultaneously is the most efficient approach. 
//This method ensures that each character is processed only once, and the pointers help in managing the traversal of both strings.

//Time complexity: O(n)
//Space complexity: O(n)

//Code:

class Solution {
    public String mergeAlternately(String word1, String word2) {
        StringBuilder result = new StringBuilder();
        int i = 0, j = 0;

        while (i < word1.length() && j < word2.length()) {
            result.append(word1.charAt(i++));
            result.append(word2.charAt(j++));
        }

        while (i < word1.length()) {
            result.append(word1.charAt(i++));
        }

        while (j < word2.length()) {
            result.append(word2.charAt(j++));
        }

        return result.toString();
    }
}

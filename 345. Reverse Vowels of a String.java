Given a string s, reverse only all the vowels in the string and return it.

The vowels are 'a', 'e', 'i', 'o', and 'u', and they can appear in both lower and upper cases, more than once.

Approach
Convert the input string s to an array of characters word. This step is necessary because strings are immutable in Java, and we need to modify the vowels' positions.

Initialize two pointers, start and end, to the first and last characters of the string, respectively.

Create a String variable vowels containing all the vowel characters (both lowercase and uppercase).

Use a while loop to iterate until start is no longer less than end. This loop ensures that the pointers will not cross each other, and we process the characters in the middle of the string only once.

Inside the loop:

Move the start pointer towards the end of the string until it points to a vowel character. We do this by using the indexOf method to find the index of the character in the vowels string. If the character is not a vowel, we keep moving the start pointer.

Similarly, move the end pointer towards the beginning of the string until it points to a vowel character. Again, we use the indexOf method to check if the character is a vowel and keep moving the end pointer if it is not.

Swap the vowels found at the start and end positions in the word array.

Move the start pointer one step ahead and the end pointer one step back to continue searching for more vowels.

After the loop finishes, the word array will contain the string with the reversed vowels. Convert the character array back to a String and return the result.

Complexity
Time complexity:
The time complexity of this solution is O(n), where n is the length of the input string s. The two pointers start and end move towards each other, and each character is processed once.

Space complexity:
The space complexity of this solution is O(n) because we create a character array word to store the characters of the input string. The space used is proportional to the length of the input string. Other than that, we use a constant amount of extra space for the vowels string and a few integer variables, which doesn't depend on the input size.

Code
class Solution {
    public String reverseVowels(String s) {
        char[] word = s.toCharArray();
        int start = 0;
        int end = s.length() - 1;
        String vowels = "aeiouAEIOU";
        
        while (start < end) {
            // Move start pointer until it points to a vowel
            while (start < end && vowels.indexOf(word[start]) == -1) {
                start++;
            }
            
            // Move end pointer until it points to a vowel
            while (start < end && vowels.indexOf(word[end]) == -1) {
                end--;
            }
            
            // Swap the vowels
            char temp = word[start];
            word[start] = word[end];
            word[end] = temp;
            
            // Move the pointers towards each other
            start++;
            end--;
        }
        
        String answer = new String(word);
        return answer;
    }
}

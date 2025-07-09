//A phrase is a palindrome if, after converting all uppercase letters into lowercase letters and removing all non-alphanumeric characters, 
//it reads the same forward and backward. Alphanumeric characters include letters and numbers.
//Given a string s, return true if it is a palindrome, or false otherwise.

class Solution {
    public boolean isPalindrome(String s) {
        String cleanStr = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase();
        return cleanStr.equals(new StringBuilder(cleanStr).reverse().toString());
    }
}


class Solution {
    String str;

    public boolean isPalindrome(String s) {
        str = s.toLowerCase().replaceAll("[^a-z0-9]", "");
        return f(0);
    }

    private boolean f(int i) {
        int j = str.length() - 1 - i;
        if (i >= j) return true;
        if (str.charAt(i) != str.charAt(j)) return false;
        return f(i + 1);
    }
}

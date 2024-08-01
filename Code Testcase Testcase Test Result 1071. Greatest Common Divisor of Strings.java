//For two strings s and t, we say "t divides s" if and only if s = t + t + t + ... + t + t (i.e., t is concatenated with itself one or more times).
//Given two strings str1 and str2, return the largest string x such that x divides both str1 and str2.

class Solution {
    public String gcdOfStrings(String str1, String str2) {
        if(!(str1+str2).equals(str2+str1)) return "";
        int gcd = getGcd(str1.length(), str2.length());
        return str1.substring(0, gcd);
    }

    public int getGcd(int a, int b) {
        if (b==0) return a;
        return getGcd(b,a%b);
    }
}

//An integer x is numerically balanced if for every digit d in the number x, there are exactly d occurrences of that digit in x.
//Given an integer n, return the smallest numerically balanced number strictly greater than n.

class Solution {
    public boolean solve(int x){
        String s = String.valueOf(x);
        int[] vec = new int[10];
        for (char ch : s.toCharArray()) vec[ch - '0']++;
        for (char ch : s.toCharArray()){
            int c = ch - '0';
            if (c == 0 || vec[c] != c) return false;
        }
        return true;
    }
    public int nextBeautifulNumber(int n) {
        for (int i = n + 1; ; i++) if (solve(i)) return i;
    }
}

//Hercy wants to save money for his first car. He puts money in the Leetcode bank every day.
//He starts by putting in $1 on Monday, the first day. Every day from Tuesday to Sunday, he will put in $1 more than the day before. 
//On every subsequent Monday, he will put in $1 more than the previous Monday.
//Given n, return the total amount of money he will have in the Leetcode bank at the end of the nth day.

class Solution {
    public int totalMoney(int n) {
        final int q=n/7, r=n%7;
        return 28*q+7*q*(q-1)/2+(2*q+r+1)*r/2;
    }
}

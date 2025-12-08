//A square triple (a,b,c) is a triple where a, b, and c are integers and a2 + b2 = c2.
//Given an integer n, return the number of square triples such that 1 <= a, b, c <= n.

class Solution {
    public int countTriples(int n) {
        int ans = 0;
        for(int i = 3; i <= 3 * n / 4; i++) {
            for(int j = i + 1; j < n; j++) {
                int sum = i*i + j*j;
                int k = (int)Math.sqrt(sum);
                if(k <= n) {
                    if(k*k == sum) ans += 2;
                } else break;
            }
        }   
        return ans;
    }
}

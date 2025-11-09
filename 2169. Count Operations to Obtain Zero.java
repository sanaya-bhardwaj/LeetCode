//You are given two non-negative integers num1 and num2.
//In one operation, if num1 >= num2, you must subtract num2 from num1, otherwise subtract num1 from num2.
//For example, if num1 = 5 and num2 = 4, subtract num2 from num1, thus obtaining num1 = 1 and num2 = 4. However, if num1 = 4 and num2 = 5, after one operation, num1 = 4 and num2 = 1.
//Return the number of operations required to make either num1 = 0 or num2 = 0.

class Solution {
    public int countOperations(int n1, int n2) {
        int c = 0;
        while (n1 > 0 && n2 > 0) {
            c += n1 / n2;
            n1 %= n2;
            // swap num1 and num2
            int temp = n1;
            n1 = n2;
            n2 = temp;
        }
        return c;
    }
}

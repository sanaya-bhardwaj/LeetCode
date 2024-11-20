//The Tribonacci sequence Tn is defined as follows: 
//T0 = 0, T1 = 1, T2 = 1, and Tn+3 = Tn + Tn+1 + Tn+2 for n >= 0.
//Given n, return the value of Tn.

class Solution {
    public int tribonacci(int n) {
        int[] arr={0,1,1};

        if (n<=2)
            return arr[n];
        for( int i=3; i<=n;i++){
            int tmp=arr[0]+arr[1] +arr[2];
            arr[0]=arr[1];
            arr[1]=arr[2];
            arr[2]=tmp;
        }
        return arr[2];
    }
}

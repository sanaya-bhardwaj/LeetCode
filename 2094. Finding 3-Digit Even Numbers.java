//You are given an integer array digits, where each element is a digit. The array may contain duplicates.
//You need to find all the unique integers that follow the given requirements:
//The integer consists of the concatenation of three elements from digits in any arbitrary order.
//The integer does not have leading zeros.
//The integer is even.
//For example, if the given digits were [1, 2, 3], integers 132 and 312 follow the requirements.
//Return a sorted array of the unique integers.

class Solution {
    public int[] findEvenNumbers(int[] digits) {
        int[] ans;
        int n = digits.length;
        int[] freq = new int[10];
        for (int i : digits) freq[i]++;

        int[] last = new int[10];
        int[] middle = new int[10];
        int[] first = new int[10];
        int[] res = new int[900];
        int n1 = 0, n2 = 0, n3 = 0, size = 0;

        for (int i = 0; i < 10; i++) {
            if (freq[i] == 0) continue;
            if (i % 2 == 0) last[n3++] = i;
            if (i > 0) first[n1++] = i;
            middle[n2++] = i;
        }

        for (int i = 0; i < n1; i++) {
            for (int j = 0; j < n2; j++) {
                for (int k = 0; k < n3; k++) {
                    int a = first[i], b = middle[j], c = last[k];
                    int x = a * 100 + b * 10 + c;
                    if (a != b && b != c && a != c) {
                        res[size++] = x;
                    } else if ((a == b && b != c) || (a == c && a != b)) {
                        if (freq[a] > 1) res[size++] = x;
                    } else if (b == c && a != b) {
                        if (freq[b] > 1) res[size++] = x;
                    } else if (freq[a] > 2) {
                        res[size++] = x;
                    }
                }
            }
        }

        ans = new int[size];
        for (int i = 0; i < size; i++) ans[i] = res[i];
        return ans;
    }
}

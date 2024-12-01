//Given an array arr of integers, check if there exist two indices i and j such that :

//i != j
//0 <= i, j < arr.length
//arr[i] == 2 * arr[j]


import java.util.HashSet;

public class Solution {
    public boolean checkIfExist(int[] arr) {
        HashSet<Integer> set = new HashSet<>();
        for (int num : arr) {
            if (set.contains(num * 2) || (num % 2 == 0 && set.contains(num / 2))) {
                return true;
            }
            set.add(num);
        }
        return false;
    }
}

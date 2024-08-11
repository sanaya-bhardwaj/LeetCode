//Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

public class Solution {
    public boolean uniqueOccurrences(int[] arr) {
       HashMap<Integer, Integer> map = new HashMap<>();//O(n)
        HashSet<Integer> set = new HashSet<>();
        HashSet<Integer> set1 = new HashSet<>();
        for (int i = 0; i < arr.length; i++) {
            map.put(arr[i], map.getOrDefault(arr[i], 0) + 1);
            set.add(arr[i]);
        }
        for (int value : map.values()) {
            set1.add(value);

        }
        if(set1.size()==set.size())
            return true;
            else
                return false;
    }
}

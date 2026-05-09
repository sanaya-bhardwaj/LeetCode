//Given an array nums of size n, return the majority element.
//The majority element is the element that appears more than ⌊n / 2⌋ times. 
//You may assume that the majority element always exists in the array.

//Better Solution
class Solution {
    public int majorityElement(int[] nums) {
        HashMap<Integer, Integer> hash = new HashMap<>();
        int res = 0;
        int majority = 0;

        for (int n : nums) {
            hash.put(n, 1 + hash.getOrDefault(n, 0));
            if (hash.get(n) > majority) {
                res = n;
                majority = hash.get(n);
            }
        }

        return res;        
    }
}
//Optimal solution using Moore's Voting Algorithm
class Solution {
    public int majorityElement(int[] nums) {
       int n = nums.length;
        
        // Count variable
        int cnt = 0;
        
        // Candidate element
        int el = 0;
        
        // Step 1: Find the potential majority element
        for (int i = 0; i < n; i++) {
            if (cnt == 0) {
                cnt = 1;
                el = nums[i];
            } else if (el == nums[i]) {
                cnt++;
            } else {
                cnt--;
            }
        }
        
        // Step 2: Verify the candidate
        int cnt1 = 0;
        for (int i = 0; i < n; i++) {
            if (nums[i] == el) {
                cnt1++;
            }
        }
        
        // Return the element if it's a majority
        if (cnt1 > (n / 2)) {
            return el;
        }
        
        // No majority found
        return -1;
     
    }
}

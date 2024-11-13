//You are given two 0-indexed integer arrays nums1 and nums2 of equal length n and a positive integer k. 
//You must choose a subsequence of indices from nums1 of length k.
//For chosen indices i0, i1, ..., ik - 1, your score is defined as:
//The sum of the selected elements from nums1 multiplied with the minimum of the selected elements from nums2.
//It can defined simply as: (nums1[i0] + nums1[i1] +...+ nums1[ik - 1]) * min(nums2[i0] , nums2[i1], ... ,nums2[ik - 1]).
//Return the maximum possible score.
//A subsequence of indices of an array is a set that can be derived from the set {0, 1, ..., n-1} by deleting some or no elements.

class Solution {
    public long maxScore(int[] nums1, int[] nums2, int k) {
        int n = nums1.length; 
        int[][] aug = new int[n][2]; 
        for (int i = 0; i < n; ++i) {
            aug[i][0] = nums1[i]; 
            aug[i][1] = nums2[i]; 
        }
        Arrays.sort(aug, new Comparator<int[]>(){
            public int compare(int[] lhs, int[] rhs) {
                return -Integer.compare(lhs[1], rhs[1]); 
            }
        }); 
        PriorityQueue<Integer> pq = new PriorityQueue(); 
        long ans = 0, total = 0; 
        for (int i = 0; i < aug.length; ++i) {
            total += aug[i][0]; 
            pq.add(aug[i][0]); 
            if (i >= k) total -= pq.poll(); 
            if (i >= k-1) ans = Math.max(ans, total * aug[i][1]); 
        }
        return ans; 
    }
}

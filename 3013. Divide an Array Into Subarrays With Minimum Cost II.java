/*You are given a 0-indexed array of integers nums of length n, and two positive integers k and dist.
The cost of an array is the value of its first element. For example, the cost of [1,2,3] is 1 while the cost of [3,4,1] is 3.
You need to divide nums into k disjoint contiguous subarrays, such that the difference between the starting index of the second subarray and the starting index of the kth subarray should be less than or equal to dist. In other words, if you divide nums into the subarrays nums[0..(i1 - 1)], nums[i1..(i2 - 1)], ..., nums[ik-1..(n - 1)], then ik-1 - i1 <= dist.
Return the minimum possible sum of the cost of these subarrays.*/

class Solution {
    static class SmartWindow {
        int K;
        TreeMap<Integer, Integer> low = new TreeMap<>();
        TreeMap<Integer, Integer> high = new TreeMap<>();
        long sumLow = 0;
        int szLow = 0, szHigh = 0;
        SmartWindow(int k){
            this.K = k;
        }
        int windowSize(){
            return szLow + szHigh;
        }
        private void addMap(TreeMap<Integer, Integer> mp, int x){
            mp.put(x, mp.getOrDefault(x, 0) + 1);
        }
        private boolean removeMap(TreeMap<Integer, Integer> mp, int x){
            Integer c = mp.get(x);
            if (c == null) return false;
            if (c == 1) mp.remove(x);
            else mp.put(x, c - 1);
            return true;
        }
        private int popLast(TreeMap<Integer, Integer> mp){
            int x = mp.lastKey();
            removeMap(mp, x);
            return x;
        }
        private int popFirst(TreeMap<Integer, Integer> mp){
            int x = mp.firstKey();
            removeMap(mp, x);
            return x;
        }
        void rebalance(){
            int need = Math.min(K, windowSize());
            while(szLow > need){
                int x = popLast(low);
                szLow --;
                sumLow -= x;
                addMap(high, x);
                szHigh ++;
            }
            while(szLow < need && szHigh > 0){
                int x = popFirst(high);
                szHigh --;
                addMap(low, x);
                szLow ++;
                sumLow += x;
            }
        }
        void add(int x){
            if(szLow == 0){
                addMap(low, x);
                szLow ++;
                sumLow += x;
            }
            else{
                int mxLow = low.lastKey();
                if(x <= mxLow){
                    addMap(low, x);
                    szLow ++;
                    sumLow += x;
                }
                else {
                    addMap(high, x);
                    szHigh ++;
                }
            }
            rebalance();
        }
        void remove(int x){
            if(removeMap(low, x)){
                szLow --;
                sumLow -= x;
            }
            else if(removeMap(high, x)){
                szHigh --;
            }
            rebalance();
        }
        long query(){
            return sumLow;
        }
    }

    public long minimumCost(int[] nums, int k, int dist) {
        int n = nums.length;
        k -= 1;
        SmartWindow window = new SmartWindow(k);

        for(int i = 1; i <= 1 + dist; i ++){
            window.add(nums[i]);
        }
        long ans = window.query();

        for(int i = 2; i + dist < n; i ++){
            window.remove(nums[i - 1]);
            window.add(nums[i + dist]);
            ans = Math.min(ans, window.query());
        }
        return ans + nums[0];
    }
}

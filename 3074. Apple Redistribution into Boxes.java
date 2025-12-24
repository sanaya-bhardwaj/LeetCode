//You are given an array apple of size n and an array capacity of size m.
//There are n packs where the ith pack contains apple[i] apples. There are m boxes as well, and the ith box has a capacity of capacity[i] apples.
//Return the minimum number of boxes you need to select to redistribute these n packs of apples into boxes.
//Note that, apples from the same pack can be distributed into different boxes.

class Solution {
    public int minimumBoxes(int[] apple, int[] capacity) {
        Arrays.sort(capacity);
        int ans = 0, sum = 0;
        for(int i = 0; i < apple.length; i++) sum += apple[i];
        for(int i = capacity.length - 1; i >= 0; i--) {
            sum -= capacity[i];
            ans++;
            if(sum <= 0) return ans;
        }
        return ans;
    }
}

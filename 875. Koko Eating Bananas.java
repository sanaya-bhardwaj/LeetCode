//Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. 
//The guards have gone and will come back in h hours.
//Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. 
//If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.
//Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.
//Return the minimum integer k such that she can eat all the bananas within h hours.

//Complexity
//Time complexity: O(N * log M)
//Space complexity: O(1)



class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        long left = 1;
        long right = 0;
        
        // Find maximum pile as upper bound
        for (int pile : piles) {
            right = Math.max(right, pile);
        }
        
        while (left < right) {
            long mid = left + (right - left) / 2;
            
            if (canEatAll(piles, h, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        
        return (int) left;
    }
    
    private boolean canEatAll(int[] piles, int h, long k) {
        long hours = 0;
        for (int pile : piles) {
            hours += (pile + k - 1) / k;
            if (hours > h) return false;
        }
        return true;
    }
}

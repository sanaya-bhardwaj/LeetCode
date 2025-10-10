//In a mystic dungeon, n magicians are standing in a line. 
//Each magician has an attribute that gives you energy. Some magicians can give you negative energy, which means taking energy from you.
//You have been cursed in such a way that after absorbing energy from magician i, you will be instantly transported to magician (i + k). 
//This process will be repeated until you reach the magician where (i + k) does not exist.
//In other words, you will choose a starting point and then teleport with k jumps until you reach the end of the magicians' sequence, absorbing all the energy during the journey.
//You are given an array energy and an integer k. Return the maximum possible energy you can gain.
//Note that when you are reach a magician, you must take energy from them, whether it is negative or positive energy.

class Solution {
    public int maximumEnergy(int[] energy, int k) {
        int l = energy.length;
        int[] dp = new int[l];
        int result = Integer.MIN_VALUE;
        for (int i = l - 1; i >= 0; i--) {
            dp[i] = energy[i] + (i + k < l ? dp[i + k] : 0);
            result = Math.max(result, dp[i]);
        }
        return result;
    }
}

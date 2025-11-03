//Alice has n balloons arranged on a rope. You are given a 0-indexed string colors where colors[i] is the color of the ith balloon.
//Alice wants the rope to be colorful. She does not want two consecutive balloons to be of the same color, so she asks Bob for help. Bob can remove some balloons from the rope to make it colorful. You are given a 0-indexed integer array neededTime where neededTime[i] is the time (in seconds) that Bob needs to remove the ith balloon from the rope.
//Return the minimum time Bob needs to make the rope colorful.

class Solution {
    public int minCost(String colors, int[] neededTime) {
        int l=0, r;
        final int n=colors.length();
        int removes=0, locMax=0;
        for (r=0; r<n; ){
            while (r<n && colors.charAt(r)==colors.charAt(l)) {
                removes+=neededTime[r];
                locMax=Math.max(locMax, neededTime[r]);
                r++;
            }
            removes-= locMax;
            locMax=0;
            l=r; 
        }
        return  removes;
    }
}

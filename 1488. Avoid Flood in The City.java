//Your country has an infinite number of lakes. Initially, all the lakes are empty, but when it rains over the nth lake, the nth lake becomes full of water. 
//If it rains over a lake that is full of water, there will be a flood. Your goal is to avoid floods in any lake.
//Given an integer array rains where:
//rains[i] > 0 means there will be rains over the rains[i] lake.
//rains[i] == 0 means there are no rains this day and you can choose one lake this day and dry it.
//Return an array ans where:
//ans.length == rains.length
//ans[i] == -1 if rains[i] > 0.
//ans[i] is the lake you choose to dry in the ith day if rains[i] == 0.
//If there are multiple valid answers return any of them. If it is impossible to avoid flood return an empty array.
//Notice that if you chose to dry a full lake, it becomes empty, but if you chose to dry an empty lake, nothing changes.

import java.util.*;

class Solution {
    public int[] avoidFlood(int[] rains) {
        int n = rains.length;
        int[] ans = new int[n];
        HashMap<Integer, Integer> full = new HashMap<>(); // lake -> last rain day
        TreeSet<Integer> dryDays = new TreeSet<>();       // indices of days we can dry

        for (int i = 0; i < n; i++) {
            if (rains[i] == 0) {
                dryDays.add(i);
                ans[i] = 1; // default, will change later if needed
            } else {
                ans[i] = -1;
                int lake = rains[i];

                if (full.containsKey(lake)) {
                    Integer dryDay = dryDays.higher(full.get(lake)); // find next dry day
                    if (dryDay == null) return new int[0]; // no day to dry -> flood

                    ans[dryDay] = lake; // dry this lake on that day
                    dryDays.remove(dryDay);
                }
                full.put(lake, i);
            }
        }
        return ans;
    }
}

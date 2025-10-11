//A magician has various spells.
//You are given an array power, where each element represents the damage of a spell. Multiple spells can have the same damage value.
//It is a known fact that if a magician decides to cast a spell with a damage of power[i], they cannot cast any spell with a damage of power[i] - 2, power[i] - 1, power[i] + 1, or power[i] + 2.
//Each spell can be cast only once.
//Return the maximum possible total damage that a magician can cast.

class Solution {
    public long maximumTotalDamage(int[] power) {
        int n = power.length;
        Arrays.sort(power);

        List<Integer> uniquePowers = new ArrayList<>();
        List<Long> totalDamages = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            int currentPower = power[i];
            long sum = currentPower;
    
            while (i + 1 < n && power[i + 1] == currentPower) {
                i++;
                sum += currentPower;
            }
    
            uniquePowers.add(currentPower);
            totalDamages.add(sum);
        }

        long[] dp = new long[uniquePowers.size() + 1];

        for (int j = uniquePowers.size() - 1; j >= 0; j--) {
            long skip = dp[j + 1];
            long take = totalDamages.get(j);
    
            int nextIndex = j + 1;
            while (nextIndex < uniquePowers.size() && 
                uniquePowers.get(nextIndex) - uniquePowers.get(j) <= 2) {
                nextIndex++;
            }
            take += dp[nextIndex];
    
            dp[j] = Math.max(skip, take);
        }

        return dp[0];
    }
}   

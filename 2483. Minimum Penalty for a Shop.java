//You are given the customer visit log of a shop represented by a 0-indexed string customers consisting only of characters 'N' and 'Y':
//if the ith character is 'Y', it means that customers come at the ith hour
//whereas 'N' indicates that no customers come at the ith hour.
//If the shop closes at the jth hour (0 <= j <= n), the penalty is calculated as follows:
//For every hour when the shop is open and no customers come, the penalty increases by 1.
//For every hour when the shop is closed and customers come, the penalty increases by 1.
//Return the earliest hour at which the shop must be closed to incur a minimum penalty.

class Solution {
    public int bestClosingTime(String customers) {
        int bestTime = 0;
        int minPenalty = 0;
        int prefix = 0;
        
        for (int i = 0; i < customers.length(); i++) {
            char ch = customers.charAt(i);
            prefix += ch == 'Y' ? -1 : 1;
            
            if (prefix < minPenalty) {
                bestTime = i + 1;
                minPenalty = prefix;
            }
        }
        
        return bestTime;
    }
}

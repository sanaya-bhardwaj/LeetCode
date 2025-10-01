//There are numBottles water bottles that are initially full of water. 
//You can exchange numExchange empty water bottles from the market with one full water bottle.
//The operation of drinking a full water bottle turns it into an empty bottle.
//Given the two integers numBottles and numExchange, return the maximum number of water bottles you can drink.

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int ans = numBottles;
        for (; numBottles >= numExchange; ++ans) {
            numBottles -= (numExchange - 1);
        }
        return ans;
    }
}

//2nd Solution
class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int drinked = 0;
        int eb = 0; // empty bottles
        
        while (numBottles > 0) {
            drinked += numBottles;   // drink all current bottles
            eb += numBottles;        // get empty bottles
            
            numBottles = eb / numExchange; // exchange empties for new bottles
            eb = eb % numExchange;         // leftover empties
        }
        return drinked;
    }
}

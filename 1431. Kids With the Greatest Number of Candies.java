//There are n kids with candies. 
//You are given an integer array candies, where each candies[i] represents the number of candies the ith kid has, and an integer extraCandies, denoting the number of extra candies that you have.
//Return a boolean array result of length n, where result[i] is true if, after giving the ith kid all the extraCandies, they will have the greatest number of candies among all the kids, or false otherwise.
//Note that multiple kids can have the greatest number of candies.

//Approach
//Find the Maximum Candies:
//Iterate through the candies array to find the current maximum number of candies any child has.

//Evaluate Each Child:
//Create a result list to store boolean values.
//For each child, add extraCandies to their current candy count.
//Compare this new count with the maximum number of candies.
//Add true to the result list if the new count is greater than or equal to the maximum, otherwise add false.

//Complexity
//Time complexity:
//Finding the maximum number of candies takes (O(n)), where (n) is the length of the candies array.
//Evaluating each child's candies with the extra candies also takes (O(n)).
//Therefore, the total time complexity is (O(n)).
//Space complexity:
//The space complexity is (O(n)) for storing the result list which contains boolean values for each child.

//Code
class Solution {
    public List<Boolean> kidsWithCandies(int[] candies, int extraCandies) {
        // Step 1: Find the maximum number of candies any child currently has
        int max = 0;
        for (int candy : candies) {
            if (candy > max) {
                max = candy;
            }
        }
        
        // Step 2: Create a list to store the result
        List<Boolean> result = new ArrayList<>();
        
        // Step 3: Evaluate each child's candies with the extra candies
        for (int candy : candies) {
            if (candy + extraCandies >= max) {
                result.add(true);
            } else {
                result.add(false);
            }
        }
        
        return result;
    }
}

//Explanation

//Finding the Maximum Candies:
//We initialize max to 0.
//We use a for-each loop to iterate through the candies array.
//If the current candy count is greater than max, we update max.

//Evaluating Each Child:
//We create a List<Boolean> to store the result.
//For each child's candy count, we add extraCandies to it and check if this new value is greater than or equal to max.
//Depending on the result of this comparison, we add true or false to the result list.

//Returning the Result:
//Finally, we return the result list containing the boolean values for each child.

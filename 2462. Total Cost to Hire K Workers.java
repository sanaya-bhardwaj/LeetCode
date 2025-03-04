//You are given a 0-indexed integer array costs where costs[i] is the cost of hiring the ith worker.
//You are also given two integers k and candidates. We want to hire exactly k workers according to the following rules:
//You will run k sessions and hire exactly one worker in each session.
//In each hiring session, choose the worker with the lowest cost from either the first candidates workers or the last candidates workers. Break the tie by the smallest index.
//For example, if costs = [3,2,7,7,1,2] and candidates = 2, then in the first hiring session, we will choose the 4th worker because they have the lowest cost [3,2,7,7,1,2].
//In the second hiring session, we will choose 1st worker because they have the same lowest cost as 4th worker but they have the smallest index [3,2,7,7,2]. Please note that the indexing may be changed in the process.
//If there are fewer than candidates workers remaining, choose the worker with the lowest cost among them. Break the tie by the smallest index.
//A worker can only be chosen once.
//Return the total cost to hire exactly k workers.

//Intuition:
//To Intuition is to maintains two priority queues (pq1 and pq2) that store the candidates smallest costs from the beginning and end of the list.
//In each iteration, the code compares the smallest costs from pq1 and pq2 and selects the one with the lowest value. The corresponding cost is added to the total cost (ans), and the element is removed from the respective priority queue.
//This process continues for k iterations, and at the end, the accumulated ans value represents the minimum total cost required to hire k workers.
    
//Explanation:
//Two integer variables i and j are initialized to track the start and end indices of the costs vector, respectively. These indices will be used to iterate over the vector.
//Two priority queues, pq1 and pq2, are created. Priority queues are data structures that allow efficient insertion and retrieval of elements while maintaining a specific order. In this case, the elements are integers, and the order is ascending (greater<int>).
//A long long variable ans is initialized to store the total cost.
//The code enters a loop that executes k times, where k is the number of workers to be hired.
//Inside the loop, two nested while loops are used to populate pq1 and pq2 with candidates from the costs vector. The conditions for these loops are as follows:
//pq1 should contain at most candidates elements, and i should be less than or equal to j.
//pq2 should also contain at most candidates elements, and i should be less than or equal to j.
//These loops essentially fill the priority queues with the smallest candidates elements from the costs vector, taking elements from both ends of the vector (i and j).
//After the while loops, the code compares the top elements (t1 and t2) of pq1 and pq2 to determine which one is smaller. If both queues are empty, INT_MAX (maximum value for an int) is used as a placeholder.
//If t1 is smaller than or equal to t2, the cost of the worker represented by t1 is added to ans, and the top element is removed from pq1 using pq1.pop(). Otherwise, the cost of the worker represented by t2 is added to ans, and the top element is removed from pq2 using pq2.pop().
//The loop continues until k workers have been hired.
//Finally, the function returns the accumulated total cost (ans).


class Solution {
    public long totalCost(int[] costs, int k, int candidates) {
        int i = 0;
        int j = costs.length - 1;
        PriorityQueue<Integer> pq1 = new PriorityQueue<>();
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();

        long ans = 0;
        while (k-- > 0) {
            while (pq1.size() < candidates && i <= j) {
                pq1.offer(costs[i++]);
            }
            while (pq2.size() < candidates && i <= j) {
                pq2.offer(costs[j--]);
            }

            int t1 = pq1.size() > 0 ? pq1.peek() : Integer.MAX_VALUE;
            int t2 = pq2.size() > 0 ? pq2.peek() : Integer.MAX_VALUE;

            if (t1 <= t2) {
                ans += t1;
                pq1.poll();
            } else {
                ans += t2;
                pq2.poll();
            }
        }
        return ans;
    }
}

//You have n jobs and m workers. You are given three arrays: difficulty, profit, and worker where:
//difficulty[i] and profit[i] are the difficulty and the profit of the ith job, and
//worker[j] is the ability of jth worker (i.e., the jth worker can only complete a job with difficulty at most worker[j]).
//Every worker can be assigned at most one job, but one job can be completed multiple times.
//For example, if three workers attempt the same job that pays $1, then the total profit will be $3. If a worker cannot complete any job, their profit is $0.
//Return the maximum profit we can achieve after assigning the workers to the jobs.

class Solution {
    public int maxProfitAssignment(int[] difficulty, int[] profit, int[] worker) {
        int n = difficulty.length;
        int[][] jobs = new int [n][2];

        //Pairing difficulty and profit and sorting by difficulty
        for ( int i =0; i<n; i++) {
            jobs[i][0] = difficulty [i];
            jobs[i][1]= profit[i];
        } 
        Arrays.sort(jobs, (a,b) -> a[0] - b[0]);

        //Sorting workers by thier abilities 
        Arrays.sort(worker);

        int maxProfit = 0;
        int totalProfit= 0; 
        int jobIndex= 0;

        //Assign jobs to workers
        for (int w : worker) {
            //Move jobIndex to the best job this worker can do
            while (jobIndex < n && jobs[jobIndex][0] <= w){
                maxProfit = Math.max(maxProfit, jobs[jobIndex][1]);
                jobIndex++;
            }
            totalProfit += maxProfit;
        }
        return totalProfit;
    }
}

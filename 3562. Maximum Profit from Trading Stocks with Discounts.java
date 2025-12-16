//You are given an integer n, representing the number of employees in a company. Each employee is assigned a unique ID from 1 to n, and employee 1 is the CEO. You are given two 1-based integer arrays, present and future, each of length n, where:
//present[i] represents the current price at which the ith employee can buy a stock today.
//future[i] represents the expected price at which the ith employee can sell the stock tomorrow.
//The company's hierarchy is represented by a 2D integer array hierarchy, where hierarchy[i] = [ui, vi] means that employee ui is the direct boss of employee vi.
//Additionally, you have an integer budget representing the total funds available for investment.
//However, the company has a discount policy: if an employee's direct boss purchases their own stock, then the employee can buy their stock at half the original price (floor(present[v] / 2)).
//Return the maximum profit that can be achieved without exceeding the given budget.
//Note:
//You may buy each stock at most once.
//You cannot use any profit earned from future stock prices to fund additional investments and must buy only from budget.


class Solution {
    private List<Integer>[] children;
    private int[] parent, present, future;
    private int budget;
    
    private void createHierarchy(int n, int[][] hierarchy) {
        children = new ArrayList[n + 1];
        parent = new int[n + 1];
        
        for (int i = 1; i <= n; i++) {
            children[i] = new ArrayList<>();
        }
        
        for (int[] relation : hierarchy) {
            int boss = relation[0];
            int subordinate = relation[1];
            children[boss].add(subordinate);
            parent[subordinate] = boss;
        }
        
        parent[1] = 0;
    }
    
    private int[] combine(int[] dp1, int[] dp2) {
        int[] newDp = new int[budget + 1];
        for (int b1 = 0; b1 <= budget; b1++) {
            for (int b2 = 0; b1 + b2 <= budget; b2++) {
                newDp[b1 + b2] = Math.max(newDp[b1 + b2], dp1[b1] + dp2[b2]);
            }
        }
        return newDp;
    }
    
    private int[][] dfs(int employee) {
        int costWithoutDiscount = present[employee - 1];
        int profitWithoutDiscount = future[employee - 1] - costWithoutDiscount;
        int costWithDiscount = present[employee - 1] / 2;
        int profitWithDiscount = future[employee - 1] - costWithDiscount;
        
        int[] dpChildrenNo = new int[budget + 1]; 
        int[] dpChildrenYes = new int[budget + 1]; 
        
        dpChildrenNo[0] = 0;
        dpChildrenYes[0] = 0;
        
        List<int[][]> childResults = new ArrayList<>();
        for (int child : children[employee]) {
            childResults.add(dfs(child));
        }
        
        for (int[][] childRes : childResults) {
            int[] childNoDiscount = childRes[0];
            int[] childWithDiscount = childRes[1];
            
            dpChildrenNo = combine(dpChildrenNo, childNoDiscount);
            dpChildrenYes = combine(dpChildrenYes, childWithDiscount);
        }
        
        int[] dpNoDiscount = new int[budget + 1];
        for (int b = 0; b <= budget; b++) {
            dpNoDiscount[b] = dpChildrenNo[b];
        }

        for (int b = costWithoutDiscount; b <= budget; b++) {
            int newProfit = dpChildrenYes[b - costWithoutDiscount] + profitWithoutDiscount;
            if (newProfit > dpNoDiscount[b]) {
                dpNoDiscount[b] = newProfit;
            }
        }
        
        int[] dpWithDiscount = new int[budget + 1];
        for (int b = 0; b <= budget; b++) {
            dpWithDiscount[b] = dpChildrenNo[b];
        }

        for (int b = costWithDiscount; b <= budget; b++) {
            int newProfit = dpChildrenYes[b - costWithDiscount] + profitWithDiscount;
            if (newProfit > dpWithDiscount[b]) {
                dpWithDiscount[b] = newProfit;
            }
        }
        
        return new int[][]{dpNoDiscount, dpWithDiscount};
    }
    
    public int maxProfit(int n, int[] present, int[] future, int[][] hierarchy, int budget) {
        this.present = present;
        this.future = future;
        this.budget = budget;
        
        createHierarchy(n, hierarchy);
        
        int[][] result = dfs(1);
        
        int maxProfit = 0;
        for (int b = 0; b <= budget; b++) {
            maxProfit = Math.max(maxProfit, result[0][b]);
        }
        
        return maxProfit;
    }
}

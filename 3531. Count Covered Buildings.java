//You are given a positive integer n, representing an n x n city. You are also given a 2D grid buildings, where buildings[i] = [x, y] denotes a unique building located at coordinates [x, y].
//A building is covered if there is at least one building in all four directions: left, right, above, and below.
//Return the number of covered buildings.

class Solution {
    public int countCoveredBuildings(int n, int[][] buildings) {
        int[] minr=new int[n+1];
        int[] maxr=new int[n+1];
        int[] minc=new int[n+1];
        int[] maxc=new int[n+1];
        Arrays.fill(minr,Integer.MAX_VALUE);
        Arrays.fill(minc,Integer.MAX_VALUE);
        for(int[] p:buildings){
            int x=p[0];
            int y=p[1];
            maxr[y]=Math.max(maxr[y],x);
            minr[y]=Math.min(minr[y],x);
            maxc[x]=Math.max(maxc[x],y);
            minc[x]=Math.min(minc[x],y);
        }
        int ct=0;
        for (int[] p : buildings) {
            int x = p[0];
            int y = p[1];
            if (
                x > minr[y] && x < maxr[y] && y > minc[x] && y < maxc[x]
            ) {
                ct++;
            }
        }
        return ct;
    }
}

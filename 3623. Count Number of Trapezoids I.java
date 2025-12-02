//You are given a 2D integer array points, where points[i] = [xi, yi] represents the coordinates of the ith point on the Cartesian plane.
//A horizontal trapezoid is a convex quadrilateral with at least one pair of horizontal sides (i.e. parallel to the x-axis). Two lines are parallel if and only if they have the same slope.
//Return the number of unique horizontal trapezoids that can be formed by choosing any four distinct points from points.
//Since the answer may be very large, return it modulo 109 + 7.

class Solution {
    public int countTrapezoids(int[][] points) {
        long mod=1000000007L;
        Map<Integer,Long> mapy=new HashMap<>();
        for(int []row:points){
            mapy.put(row[1],mapy.getOrDefault(row[1],0L)+1);
        }
        List<Long> height=new ArrayList<>();
        for(long val:mapy.values()){
            if(val>=2){
                long ways=(val*(val-1))/2;
                height.add(ways%mod);
            }
        }
        long ans=0,sum=0;
        for(long val:height){
            ans=(ans+(val*sum)%mod)%mod;
            sum=(sum+val)%mod;
        }
        return (int)ans;
    }
}

//You are given a 2D integer array points where points[i] = [xi, yi] represents the coordinates of the ith point on the Cartesian plane.
//Return the number of unique trapezoids that can be formed by choosing any four distinct points from points.
//A trapezoid is a convex quadrilateral with at least one pair of parallel sides. Two lines are parallel if and only if they have the same slope.

class Solution {
    public int countTrapezoids(int[][] points) {
        int n = points.length;
        double inf = 1e9 + 7;
        Map<Double, List<Double>> slopeToIntercept = new HashMap<>();
        Map<Integer, List<Double>> midToSlope = new HashMap<>();
        int ans = 0;
        
        // Step 1: Generate all line segments between pairs of points
        for (int i = 0; i < n; i++) {
            int x1 = points[i][0];
            int y1 = points[i][1];
            for (int j = i + 1; j < n; j++) {
                int x2 = points[j][0];
                int y2 = points[j][1];
                int dx = x1 - x2;
                int dy = y1 - y2;
                double k;  // slope
                double b;  // y-intercept
                
                // Calculate slope and intercept
                if (x2 == x1) {
                    k = inf;  // vertical line (infinite slope)
                    b = x1;   // use x-coordinate as "intercept"
                } else {
                    k = (1.0 * (y2 - y1)) / (x2 - x1);
                    b = (1.0 * (y1 * dx - x1 * dy)) / dx;
                }
                
                // Normalize negative zero to positive zero
                if (k == -0.0) k = 0.0;
                if (b == -0.0) b = 0.0;
                
                // Encode midpoint as integer
                int mid = (x1 + x2) * 10000 + (y1 + y2);
                
                // Store in hash structures
                slopeToIntercept
                    .computeIfAbsent(k, key -> new ArrayList<>())
                    .add(b);
                midToSlope
                    .computeIfAbsent(mid, key -> new ArrayList<>())
                    .add(k);
            }
        }
        
        // Step 3: Count all pairs of parallel segments (trapezoids + parallelograms)
        for (List<Double> sti : slopeToIntercept.values()) {
            if (sti.size() == 1) continue;  // need at least 2 segments
            
            // Count segments by intercept
            Map<Double, Integer> cnt = new TreeMap<>();
            for (double b : sti) {
                cnt.put(b, cnt.getOrDefault(b, 0) + 1);
            }
            
            // Combinatorial counting: pairs from different intercepts
            int sum = 0;
            for (int count : cnt.values()) {
                ans += sum * count;  // current count × all previous counts
                sum += count;
            }
        }
        
        // Step 4: Subtract parallelograms (segments sharing midpoint with different slopes)
        for (List<Double> mts : midToSlope.values()) {
            if (mts.size() == 1) continue;  // need at least 2 segments
            
            // Count segments by slope
            Map<Double, Integer> cnt = new TreeMap<>();
            for (double k : mts) {
                cnt.put(k, cnt.getOrDefault(k, 0) + 1);
            }
            
            // Combinatorial counting: pairs with different slopes
            int sum = 0;
            for (int count : cnt.values()) {
                ans -= sum * count;  // subtract parallelogram count
                sum += count;
            }
        }
        
        return ans;
    }
}

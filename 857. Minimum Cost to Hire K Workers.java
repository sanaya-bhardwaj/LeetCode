//There are n workers. You are given two integer arrays quality and wage where quality[i] is the quality of the ith worker and wage[i] is the minimum wage expectation for the ith worker.
//We want to hire exactly k workers to form a paid group. To hire a group of k workers, we must pay them according to the following rules:
//Every worker in the paid group must be paid at least their minimum wage expectation.
//In the group, each worker's pay must be directly proportional to their quality. This means if a worker’s quality is double that of another worker in the group, then they must be paid twice as much as the other worker.
//Given the integer k, return the least amount of money needed to form a paid group satisfying the above conditions. Answers within 10-5 of the actual answer will be accepted.

class Solution {
  public double mincostToHireWorkers(int[] quality, int[] wage, int k) {
    double ans = Double.MAX_VALUE;
    int qualitySum = 0;
    // (wagePerQuality, quality) sorted by wagePerQuality
    Pair<Double, Integer>[] workers = new Pair[quality.length];
    Queue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());

    for (int i = 0; i < quality.length; ++i)
      workers[i] = new Pair<>((double) wage[i] / quality[i], quality[i]);

    Arrays.sort(workers, (a, b) -> Double.compare(a.getKey(), b.getKey()));

    for (Pair<Double, Integer> worker : workers) {
      final double wagePerQuality = worker.getKey();
      final int q = worker.getValue();
      maxHeap.offer(q);
      qualitySum += q;
      if (maxHeap.size() > k)
        qualitySum -= maxHeap.poll();
      if (maxHeap.size() == k)
        ans = Math.min(ans, qualitySum * wagePerQuality);
    }

    return ans;
  }
}

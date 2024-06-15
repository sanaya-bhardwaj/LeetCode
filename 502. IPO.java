//Suppose LeetCode will start its IPO soon. In order to sell a good price of its shares to Venture Capital, LeetCode would like to work on some projects to increase its capital before the IPO. Since it has limited resources, it can only finish at most k distinct projects before the IPO. 
//Help LeetCode design the best way to maximize its total capital after finishing at most k distinct projects.
//You are given n projects where the ith project has a pure profit profits[i] and a minimum capital of capital[i] is needed to start it.
//Initially, you have w capital. When you finish a project, you will obtain its pure profit and the profit will be added to your total capital.
//Pick a list of at most k distinct projects from given projects to maximize your final capital, and return the final maximized capital.
//The answer is guaranteed to fit in a 32-bit signed integer.

class T {
  public int pro;
  public int cap;
  public T(int pro, int cap) {
    this.pro = pro;
    this.cap = cap;
  }
}

class Solution {
  public int findMaximizedCapital(int k, int W, int[] Profits, int[] Capital) {
    Queue<T> minHeap = new PriorityQueue<>((a, b) -> a.cap - b.cap);
    Queue<T> maxHeap = new PriorityQueue<>((a, b) -> b.pro - a.pro);

    for (int i = 0; i < Capital.length; ++i)
      minHeap.offer(new T(Profits[i], Capital[i]));

    while (k-- > 0) {
      while (!minHeap.isEmpty() && minHeap.peek().cap <= W)
        maxHeap.offer(minHeap.poll());
      if (maxHeap.isEmpty())
        break;
      W += maxHeap.poll().pro;
    }

    return W;
  }
}

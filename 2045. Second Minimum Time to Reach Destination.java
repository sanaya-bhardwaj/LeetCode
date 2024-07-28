//A city is represented as a bi-directional connected graph with n vertices where each vertex is labeled from 1 to n (inclusive). 
//The edges in the graph are represented as a 2D integer array edges, where each edges[i] = [ui, vi] denotes a bi-directional edge between vertex ui and vertex vi. 
//Every vertex pair is connected by at most one edge, and no vertex has an edge to itself. The time taken to traverse any edge is time minutes.
//Each vertex has a traffic signal which changes its color from green to red and vice versa every change minutes. All signals change at the same time. 
//You can enter a vertex at any time, but can leave a vertex only when the signal is green. You cannot wait at a vertex if the signal is green.
//The second minimum value is defined as the smallest value strictly larger than the minimum value.
//For example the second minimum value of [2, 3, 4] is 3, and the second minimum value of [2, 2, 4] is 4.
//Given n, edges, time, and change, return the second minimum time it will take to go from vertex 1 to vertex n.

Notes:

You can go through any vertex any number of times, including 1 and n.
You can assume that when the journey starts, all signals have just turned green.

class Solution {
    public int secondMinimum(int n, int[][] edges, int time, int change) {
        /**
            1. traffic light is global
                - if a departs before b, a will always arrive first
                    - if a delays bc of red light, b will be delayed as well 
                - carry the time forward
                - round=curTime/change
                    - if round is even, then it is green
                        - nextTime=curTime+time
                    - if round is odd, then it is red
                        - wait
                        - nextTime=curTime+2*time, (round+1)*change+time
            2. the question is asking for second minimum time
                - if A->...->B1->...->C, a second minumum time would be
                    - A->...->B1->...->B2->...-->C
                    - a node can be visited twice
            3. use an timeArr to keep track of the 2nd minimum time for every node
                - bfs into next only timeArr[i]<nextTime
         */

        List<Integer>[] graph=new ArrayList[n+1];
        for(int i=0;i<n+1;i++) graph[i]=new ArrayList<>();
        for(int[] edge:edges){
            graph[edge[0]].add(edge[1]);
            graph[edge[1]].add(edge[0]);
        }
        
        Deque<int[]> deque=new LinkedList<>();
        int[] visitedNum=new int[n+1];
        int[] timeArr=new int[n+1];
        Arrays.fill(timeArr,-1);
        deque.offerLast(new int[]{1,0});
        timeArr[0]=0;

        while(deque.size()>0){
            int curSize=deque.size();
            for(int i=0;i<curSize;i++){
                int[] cur=deque.pollFirst();
                //if(cur[0]==n && visitedNum[cur[0]]==2) return cur[1];
                
                int nextTime=0;
                int curLight=cur[1]/change;
                if(curLight%2==0){
                    nextTime=cur[1]+time;
                }
                //nextTime=(curLight+1)*change+time;
                else nextTime=(curLight+1)*change+time;

                for(int nextNode:graph[cur[0]]){
                    if(visitedNum[nextNode]<2 && timeArr[nextNode]<nextTime){
                        deque.offerLast(new int[]{nextNode,nextTime});
                        visitedNum[nextNode]++;
                        timeArr[nextNode]=nextTime;
                        if(nextNode==n && visitedNum[nextNode]==2) return nextTime; 
                    }    
                }
                
            }
        }
        return -1;
    }
}

import java.util.*;
class Solution {
    static boolean[] visit;
    public int solution(int[] cards) {
        visit=new boolean[cards.length];
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        
        for(int i=0;i<cards.length;i++){
            if(visit[i]) continue;
            pq.offer(DFS(i,cards,0));
        }
        if(pq.size()<=1)return 0;
        else return pq.poll()*pq.poll();
    }
    public static int DFS(int idx,int[] cards,int N){
        if(visit[idx])return N;
        
        visit[idx]=true;
        return DFS(cards[idx]-1,cards,N+1);
    }
}
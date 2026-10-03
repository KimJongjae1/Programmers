import java.util.*;
class Solution {
    public int solution(int N, int[][] road, int K) {
        int answer = 0;
        int[] dp=new int[N+1];
        Arrays.fill(dp,Integer.MAX_VALUE);
        dp[1]=1;
        List<int[]>[] list=new ArrayList[N+1];
        for(int i=1;i<=N;i++)list[i]=new ArrayList<>();
        
        for(int[] r:road){
            list[r[0]].add(new int[]{r[1],r[2]});
            list[r[1]].add(new int[]{r[0],r[2]});
        }
        
        //PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
         //   @Override
        //    public int compare(int[] a,int[] b){
         //       return a[1]-b[1];
        //    }
       // });
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{1,0});
        while(!qu.isEmpty()){
            int[] cur=qu.poll();
            if(dp[cur[0]]<cur[1])continue;
            
            for(int[] next:list[cur[0]]){
                if(dp[next[0]]<=cur[1]+next[1])continue;
                if(cur[1]+next[1]>K)continue;
                
                dp[next[0]]=cur[1]+next[1];
                qu.offer(new int[]{next[0],dp[next[0]]});
            }
        }
        for(int i=1;i<=N;i++){
            if(dp[i]<=K)answer++;
        }
        return answer;
    }
}
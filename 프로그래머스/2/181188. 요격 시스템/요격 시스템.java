import java.util.*;
class Solution {
    public int solution(int[][] targets) {
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                if(a[0]!=b[0])return a[0]-b[0];
                return a[1]-b[1];
            }
        });
        
        for(int[] n:targets){
            pq.offer(n);
        }
        
        int[] range=new int[]{-1,0};
        int ans=0;
        while(!pq.isEmpty()){
            int[] target=pq.poll();
     
            if(range[1]<=target[0]){
                range=target;
                ans++;
            }
            else{
                range[0]=target[0];
                range[1]=Math.min(range[1],target[1]);
            }

        }   
        return ans;
    }
    
}
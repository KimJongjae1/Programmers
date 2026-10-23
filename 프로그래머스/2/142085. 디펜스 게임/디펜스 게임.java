import java.util.*;
class Solution {
    public int solution(int n, int k, int[] enemy) {
        
        PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
        for(int i=0;i<enemy.length;i++){
            int e=enemy[i];
            
            if(e<=n){
                n-=e;
                pq.offer(e);
            }else{
                if(k>0){
                    // 까망권을 e에 쓴다 2. pq에서 뽑아서 쓴다 
                    k--;
                    if(!pq.isEmpty()){
                        if(pq.peek()>e){
                            n+=pq.poll()-e;
                            pq.offer(e);
                        }
                    }
                    
                }else return i;
                
            }
        }
            
        return enemy.length;
    }
}
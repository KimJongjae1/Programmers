import java.util.*;
class Solution {
    public int solution(int bridge_length, int weight, int[] truck_weights) {
        Deque<Integer> dq=new LinkedList<>();
        
        int idx=0;
        int ret=0;
        int sum=0;
        
        for(int i=0;i<bridge_length;i++){
            dq.offerLast(0);
        }
        
        while(idx<truck_weights.length){
            ret++;
            sum-=dq.pollFirst();
            if(sum+truck_weights[idx]<=weight){
                dq.offerLast(truck_weights[idx]);
                sum+=truck_weights[idx];
                idx++;
            }else{
                dq.offerLast(0);
            }

        }
        
        ret+=bridge_length;

        return ret;
        
    }
}
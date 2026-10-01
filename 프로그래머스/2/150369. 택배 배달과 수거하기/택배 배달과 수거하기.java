class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        int didx=n-1;
        int pidx=n-1;
        

        long ans=0;
        while(pidx>=0||didx>=0){
            int d=cap;
            int p=cap;
            while(pidx>=0){
                if(pickups[pidx]>0)break;
                pidx--;
            }
            while(didx>=0){
                if(deliveries[didx]>0)break;
                didx--;
            }
       
            
            ans+=Math.max(pidx+1,didx+1)*2;
 
            while(didx>=0&&d>0){
                if(deliveries[didx]>d){
                    deliveries[didx]-=d;
                    break;
                }
                else{
                   d-=deliveries[didx];
                   deliveries[didx--]=0;
                }
            }
            
             while(pidx>=0&&p>0){
                if(pickups[pidx]>p){
                    pickups[pidx]-=p;
                    break;
                }
                else{
                   p-=pickups[pidx];
                   pickups[pidx--]=0;
                }
            }
             
        }
           return ans; 
    }
}
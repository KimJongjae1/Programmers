class Solution {
    public int solution(int n, int[] stations, int w) {
        int ret=0;
        int s=1;
        int idx=0;
        while(idx<stations.length){
            int len=stations[idx]-w-s;
            if(len>0){
                ret+=len/(2*w+1);
                if(len%(2*w+1)>0)ret++;
            }
            
            s=stations[idx++]+w+1;
        }
        if(n>=s){
            ret+=(n-s+1)/(2*w+1);
            if((n-s+1)%(2*w+1)>0)ret++;
        }
        
        return ret;
        
    }
}
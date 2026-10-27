import java.util.*;
class Solution {
    public int[] solution(int n, long k) {
        long[] dp=new long[n+1];
        List<Integer> list=new ArrayList<>();
        dp[1]=1;
        list.add(1);
        for(int i=2;i<=n;i++){
            dp[i]=dp[i-1]*i;
            list.add(i);
        }

        int idx=0;
        int id=n-1;
        int[] ans=new int[n];
        while(idx<n&&k>0){
            
            int i=(int)((k-1)/dp[id]);

            ans[idx]=list.get(i);
            list.remove(i);
            k%=dp[id];
            
            idx++;
            id--;

        }
        
        int i=list.size()-1;
        while(idx<n){
            ans[idx++]=list.get(i--);
         }
        return ans;
    }
    
}
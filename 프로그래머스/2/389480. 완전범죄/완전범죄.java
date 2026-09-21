class Solution {
    public int solution(int[][] info, int n, int m) {
        
        int[][] dp=new int[info.length+1][m+1];
        for(int i=0;i<dp.length;i++){
            for(int k=0;k<m;k++){
                dp[i][k]=120;
            }
        }
        
        dp[0][0]=0;
        
        for(int i=0;i<info.length;i++){
            for(int k=0;k<m;k++){
                
                
                if(dp[i][k]==120)continue;
                
                int A=info[i][0]+dp[i][k];
                if(A<n){
                    dp[i+1][k]=Math.min(dp[i+1][k],A);
                }
                
                int B=info[i][1]+k;
                if(B<m){
                    dp[i+1][B]=Math.min(dp[i+1][B],dp[i][k]);
                }
            }
        }
        
        int ans=120;
        for(int i=0;i<m;i++){
            ans=Math.min(ans,dp[info.length][i]);
        }
        if(ans==120)return -1;
        return ans;
        
        
    }
}
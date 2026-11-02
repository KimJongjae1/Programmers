class Solution {
    static int MAX=1000000000;
    static int ans;
    public int solution(int storey) {
        ans=MAX;
       
        DFS(storey,0);
        return ans;
    }
    public static void DFS(int storey,int sum){
        if(storey<0||storey>MAX)return;
        if(ans<=sum)return;
        if(storey/10==0){
            ans=Math.min(Math.min(10-storey+1,storey)+sum,ans);
            return;
        }
        DFS(storey/10+1,sum+10-storey%10);
        DFS(storey/10,sum+storey%10);
        
    }
}
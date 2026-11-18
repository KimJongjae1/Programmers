class Solution {
    static boolean[] visit;
    static int ans;
    public int solution(int k, int[][] dungeons) {
        visit=new boolean[dungeons.length];
        ans=0;
        DFS(k,0,dungeons);
        return ans;
    }
    public void DFS(int k,int level,int[][] dungeons){
        if(k==0||level==dungeons.length){
             ans=level;
             return;    
            
        }
        
        for(int i=0;i<dungeons.length;i++){
            if(visit[i])continue;
            
            visit[i]=true;
            
            if(k>=dungeons[i][0]){
                DFS(k-dungeons[i][1],level+1,dungeons);
            }
            visit[i]=false;
            
        }
        ans=Math.max(ans,level);
    }
}
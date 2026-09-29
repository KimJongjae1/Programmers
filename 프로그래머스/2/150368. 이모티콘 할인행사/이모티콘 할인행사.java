class Solution {
    static int[] userSum;
    static int[] dis={10,20,30,40};
    static int[] ans;
    public int[] solution(int[][] users, int[] emoticons) {
        userSum=new int[users.length];
        ans=new int[2];
        BACK(0,users,emoticons);
        return ans;
    }
    public static void BACK(int level,int[][] users,int[] emoticons){
        if(level==emoticons.length){
            int plus=0;
            int cost=0;
            for(int i=0;i<users.length;i++){
                if(userSum[i]>=users[i][1]){
                    plus++;
                }else{
                    cost+=userSum[i];
                }
            }
            if(ans[0]==plus&&cost>ans[1]){
                ans[1]=cost;
            }else if(ans[0]<plus){
                ans[0]=plus;
                ans[1]=cost;
            }
            return;
        }
        
        int[] C=new int[users.length];
        for(int d=0;d<4;d++){
           for(int i=0;i<users.length;i++){
                int mindis=users[i][0];
                if(mindis>dis[d])continue;
               
                int cost=emoticons[level]*(100-dis[d])/100;
                C[i]=cost;
                userSum[i]+=cost;
           } 
            BACK(level+1,users,emoticons);
            for(int i=0;i<users.length;i++){
                userSum[i]-=C[i];
            } 
            
        }
        
    }
   
    
}
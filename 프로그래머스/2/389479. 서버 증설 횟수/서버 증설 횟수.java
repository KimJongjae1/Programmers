class Solution {
    public int solution(int[] players, int m, int k) {
        int[] finish=new int[24];
        int server=0;
        int ans=0;
        for(int i=0;i<players.length;i++){
            int t=players[i];
            server-=finish[i];
            
            int min=server*m;
            int max=(server+1)*m;
            if(max<=t){
                int AddServer=t/m-server;
                ans+=AddServer;
                server+=AddServer;
                if(i+k<24){
                    finish[i+k]+=AddServer;
                }
            }
            
        }
        return ans;
    }
}
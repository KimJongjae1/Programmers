import java.util.*;
class Solution {
    static int[] ans;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    public int solution(int[][] land) {
        ans=new int[land[0].length];
        for(int i=0;i<land.length;i++){
            for(int k=0;k<land[0].length;k++){
                if(land[i][k]==1){
                    land[i][k]=0;
                    BFS(i,k,land);
                }
            }
        }
        int ret=0;
        for(int i=0;i<ans.length;i++){
            ret=Math.max(ret,ans[i]);
        }
        System.out.println();
        return ret;
        
    }
    public static void BFS(int Y,int X,int[][] land){
        Queue<int[]> qu=new LinkedList<>();
        Set<Integer> set=new HashSet<>();
        set.add(X);
        qu.offer(new int[]{Y,X});
        int cnt=1;
        while(!qu.isEmpty()){
            int[] cur=qu.poll();
            
            for(int i=0;i<4;i++){
                int y=cur[0]+diy[i];
                int x=cur[1]+dix[i];
                if(y<0||y>=land.length||x<0||x>=land[0].length)continue;
                if(land[y][x]!=1)continue;
                land[y][x]=0;
                cnt++;
                set.add(x);
                qu.offer(new int[]{y,x});
                
            }
        }
        for(int x:set){
            ans[x]+=cnt;
        }
    }
}
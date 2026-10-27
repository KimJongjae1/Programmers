import java.util.*;
class Solution {
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    public int solution(String[] maps) {
        int answer=-1;
        for(int i=0;i<maps.length;i++){
            for(int k=0;k<maps[i].length();k++){
                if(maps[i].charAt(k)=='S'){
                    return BFS(maps,i,k);
                }
            }
        }

        
        return answer;
    }
    public static int BFS(String[] maps,int a,int b){
        Queue<int[]> qu=new LinkedList<>();
        int N=maps.length;
        int M=maps[0].length();
        boolean[][] visit=new boolean[N][M];
        visit[a][b]=true;
        boolean found=false;
        qu.offer(new int[]{a,b,0,0});
        while(!qu.isEmpty()){
            int[] cur=qu.poll();
            int y=cur[0];int x=cur[1];
            int cost=cur[2];
            int CheckFound=cur[3];
            
            if(found&&CheckFound==0)continue;
            
            char curStatus=maps[y].charAt(x);
            if(!found&&curStatus=='L'){
                visit=new boolean[N][M];
                visit[y][x]=true;
                found=true;
            }
            if(found&&curStatus=='E'){
                return cost;
            }
            for(int i=0;i<4;i++){
                int Y=y+diy[i];
                int X=x+dix[i];
                if(Y>=N||Y<0||X<0||X>=M)continue;
                if(visit[Y][X])continue;
                visit[Y][X]=true;
                char next=maps[Y].charAt(X);
                if(next=='X')continue;
                
                if(found)qu.offer(new int[]{Y,X,cost+1,1});
                else qu.offer(new int[]{Y,X,cost+1,0});
            }

        }
        return -1;
    }
}
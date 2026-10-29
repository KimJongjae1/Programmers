import java.util.*;
class Solution {
    static int N;
    static int M;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    static boolean[][] visit;
    public int[] solution(String[] maps) {
        N=maps.length;
        M=maps[0].length();
        visit=new boolean[N][M];
        List<Integer> list=new ArrayList<>();
        for(int i=0;i<N;i++){
            for(int k=0;k<M;k++){
                if(!visit[i][k]&&maps[i].charAt(k)!='X'){
                    list.add(BFS(i,k,maps));
                }
            }
        }
        if(list.size()==0)return new int[]{-1};
        Collections.sort(list);
        int[] ans=new int[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        
        return ans;
        
        
    }
    public static int BFS(int y,int x,String[] maps){
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{y,x});
        int ret=maps[y].charAt(x)-'0';
        visit[y][x]=true;
        while(!qu.isEmpty()){
            int[] cur=qu.poll();
            
            for(int i=0;i<4;i++){
                int Y=cur[0]+diy[i];
                int X=cur[1]+dix[i];
                if(Y<0||Y>=N||X<0||X>=M)continue;
                if(visit[Y][X])continue;
                visit[Y][X]=true;
                if(maps[Y].charAt(X)=='X')continue;
                ret+=maps[Y].charAt(X)-'0';
                qu.offer(new int[]{Y,X});
            }
        }
        return ret;
    }
    
}
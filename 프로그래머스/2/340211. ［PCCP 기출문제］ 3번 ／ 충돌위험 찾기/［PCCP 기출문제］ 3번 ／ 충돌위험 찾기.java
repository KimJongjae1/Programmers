import java.util.*;
class Solution {
    static int answer;
    public int solution(int[][] points, int[][] routes) {
        answer = 0;
        BFS(points,routes);
        return answer;
    }
    public static void BFS(int[][] points,int[][] routes){
        Queue<int[]> qu=new LinkedList<>();
        for(int i=0;i<routes.length;i++){
            int sy=points[routes[i][0]-1][0];
            int sx=points[routes[i][0]-1][1];
            qu.offer(new int[]{i,sy,sx,1});
            //i은 로봇의 인덱스// 위치 y,x   //다음 point(0 포인트에서 시작해서 1포인트로간다)
        }
        answer+=count(qu);
        while(!qu.isEmpty()){
            int size=qu.size();
            
            for(int t=0;t<size;t++){
                int[] cur=qu.poll();
                int robotIdx=cur[0];
                int y=cur[1];
                int x=cur[2];
                if(routes[robotIdx].length<=cur[3])continue;
                int nextP=routes[robotIdx][cur[3]]-1;
     
                int nxtY=points[nextP][0];
                int nxtX=points[nextP][1];

                if(nxtY!=y){
                   int diy=1;
                    if(nxtY<y)diy=-1;
                    y+=diy;
                }else {
                    int dix=1;
                    if(nxtX<x)dix=-1;
                    x+=dix;
                    
                }
                
                if(y==nxtY&&nxtX==x){
                    qu.offer(new int[]{robotIdx,y,x,cur[3]+1});
                }else{
                    qu.offer(new int[]{robotIdx,y,x,cur[3]});
                }
   
            }
           
            answer+=count(qu);
        }
    }
    public static int count(Queue<int[]> qu){
        Map<Integer,Integer> map=new HashMap<>();
        int cnt=0;
            for(int[] P:qu){
                int hash=P[1]*1000+P[2];
                map.putIfAbsent(hash,0);
                int n=map.get(hash);
                if(n==1)cnt++;
                map.put(hash,n+1);
            }
        return cnt;
    }
}
import java.util.*;
class Solution {
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    static Map<Integer,List<Integer>> map;
    public int solution(String[] board) {

        int N=board.length;
        int M=board[0].length();
        map=new HashMap<>();
        int sy=0;
        int sx=0;
        int ey=0;
        int ex=0;
        
        for(int i=0;i<N;i++){
            for(int k=0;k<M;k++){
                if(board[i].charAt(k)=='G'){
                    ey=i;ex=k;
                }else if(board[i].charAt(k)=='R'){
                    sy=i;sx=k;
                }
                
            }
        }
        for(int i=0;i<N;i++){
            for(int k=0;k<M;k++){
                
                if(board[i].charAt(k)=='D'){
                    for(int q=0;q<4;q++){
                        DFS(i+diy[q],k+dix[q],N,M,board);
                    }
                }
                else if(i==0||i==N-1||k==0||k==M-1||board[i].charAt(k)=='R'){
                    DFS(i,k,N,M,board);
                    
                }
               
                
            }
        }
  
        
        Set<Integer> set=new HashSet<>();
        set.add(sy*M+sx);
        Queue<int[]> qu=new LinkedList<>();
        qu.offer(new int[]{sy,sx,0});
        while(!qu.isEmpty()){
            int[] cur=qu.poll();
          
            if(cur[0]==ey&&cur[1]==ex){
                return cur[2];
            }
            
            List<Integer> l=map.get(cur[0]*M+cur[1]);
 
            
            for(int i=0;i<4;i++){
                int next=l.get(i);
  
                if(set.contains(next))continue;
                set.add(next);
                int Y=next/M;
                int X=next%M;
                qu.offer(new int[]{Y,X,cur[2]+1});
            }
        }
        
        return -1;
    }
    public static void DFS(int sy,int sx,int N,int M,String[] board){
        if(sy<0||sy>=N||sx<0||sx>=M)return;
        if(map.containsKey(sy*M+sx))return;
        
        map.put(sy*M+sx,new ArrayList<>());
        
        for(int i=0;i<4;i++){
            int y=sy;
            int x=sx;
            while(true){
                y+=diy[i];
                x+=dix[i];
                if(y<0||y>=N||x<0||x>=M||board[y].charAt(x)=='D'){
                    map.get(sy*M+sx).add((y-diy[i])*M+x-dix[i]);
                    break;
                } 

                
            }
            
            
        }
        
        
        
        
    }
}
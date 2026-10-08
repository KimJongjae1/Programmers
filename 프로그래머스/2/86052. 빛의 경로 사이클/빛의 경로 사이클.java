import java.util.*;
class Solution {
    static int[] diy={-1,0,1,0};
    static int[] dix={0,1,0,-1};
    static int N;
    static int M;
    static Map<Character,List<Integer>> map;
    static List<Integer> ans;
    static boolean[][][] visit;
    static boolean[] start;
    public int[] solution(String[] grid) {
        map=new HashMap<>();
        N=grid.length;
        M=grid[0].length();
        ans=new ArrayList<>();
        map.put('S',new ArrayList<>());
        map.put('L',new ArrayList<>());
        map.put('R',new ArrayList<>());
        
        List<Integer> temp=map.get('S');
        temp.add(0);temp.add(1);temp.add(2);temp.add(3);
        
        temp=map.get('L');
        temp.add(3);temp.add(0);temp.add(1);temp.add(2);
        
        temp=map.get('R');
        temp.add(1);temp.add(2);temp.add(3);temp.add(0);
        
        visit=new boolean[N][M][4];

        for(int i=0;i<4;i++){
            for(int k=0;k<N;k++){
                for(int q=0;q<M;q++){
                    if(visit[k][q][i])continue;
                    Light(0,grid,k,q,i); 
                }
            }
           

        }
        Collections.sort(ans);
        int[] ret=new int[ans.size()];
        for(int i=0;i<ans.size();i++){
            ret[i]=ans.get(i);
        }
        return ret;
    }
    public static void Light(int len, String[] grid, int y, int x, int dir) {
        while (true) {
            if (visit[y][x][dir]) {
                ans.add(len);
                return;
            }
            visit[y][x][dir] = true;
            int Y = y + diy[dir];
            int X = x + dix[dir];

            if (Y < 0) Y = N - 1;
            if (Y == N) Y = 0;
            if (X < 0) X = M - 1;
            if (X == M) X = 0;
            
            dir = map.get(grid[Y].charAt(X)).get(dir);    
            y = Y;
            x = X;
            len++;
        }
    }
}
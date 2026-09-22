import java.util.*;
class Solution {
    static int N;
    static int M;
    static int ans;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    static int idx;
    public int solution(String[] storage, String[] requests) {
        
        N=storage.length;
        M=storage[0].length();
        ans=N*M;
        idx=0;
        int[][] arr=new int[N+2][M+2];
        Map<Character,List<Integer>> map=new HashMap<>();
        for(int i=1;i<=N;i++){
            for(int k=1;k<=M;k++){
                char temp=storage[i-1].charAt(k-1);
                arr[i][k]=temp;
                map.putIfAbsent(temp,new ArrayList<>());
                map.get(temp).add(i*100+k);
                
            }
        }
        
        for(String re:requests){
            char a=re.charAt(0);
            if(re.length()==1){
               BFS(a,arr); 
            }else{
                if(!map.containsKey(a))continue;
                for(int n:map.get(a)){
                    int y=n/100;
                    int x=n%100;
                    
                    if(arr[y][x]>0) ans--;
                    arr[y][x]=idx-1;
                }
            }
            idx--;
        }
    return ans;
        
    }
    public static void BFS(int n,int[][] arr){
       Queue<int[]> qu=new LinkedList<>();
       qu.offer(new int[]{0,0});
        arr[0][0]=idx-1;

        while(!qu.isEmpty()){
            int[] cur=qu.poll();
   
            for(int i=0;i<4;i++){
                int Y=cur[0]+diy[i];
                int X=cur[1]+dix[i];
                if(Y<0||Y>N+1||X<0||X>M+1)continue;
                if(arr[Y][X]<idx)continue;

                if(arr[Y][X]==n){
                  arr[Y][X]=idx-1;
                  ans--;
                }else if(arr[Y][X]<=0&&arr[Y][X]>=idx){
                    arr[Y][X]=idx-1;
                    qu.offer(new int[]{Y,X});
                }
                
            }
        }
    }
}
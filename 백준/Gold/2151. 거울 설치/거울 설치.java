import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int N;
    static int H=100000000;
    static char[][] arr;
    static int[] diy={-1,1,0,0};
    static int[] dix={0,0,-1,1};
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        PriorityQueue<int[]> pq=new PriorityQueue<>(new Comparator<int[]>(){
            @Override
            public int compare(int[] a,int[] b){
                return a[3]-b[3];
            }
        });

        N=Integer.parseInt(br.readLine());
        arr=new char[N][N];
        int[][][] visit=new int[N][N][4];
        for(int i=0;i<N;i++){
            String str=br.readLine();
            for(int k=0;k<N;k++){
                Arrays.fill(visit[i][k],Integer.MAX_VALUE);
                arr[i][k]=str.charAt(k);
                if(arr[i][k]=='#'&&pq.isEmpty()){
                    pq.offer(new int[]{i,k,0,0});
                    pq.offer(new int[]{i,k,1,0});
                    pq.offer(new int[]{i,k,2,0});
                    pq.offer(new int[]{i,k,3,0});
                    visit[i][k][0]=0;
                    visit[i][k][1]=0;
                    visit[i][k][2]=0;
                    visit[i][k][3]=0;
                    arr[i][k]='.';
                }
            }
        }
        
    while(!pq.isEmpty()){
            int[] cur=pq.poll();
            int dir=cur[2];
            int y=cur[0];
            int x=cur[1];

            if(y<0||y>=N||x<0||x>=N||arr[y][x]=='*')continue;
            if(visit[y][x][dir]<cur[3])continue;
            visit[y][x][dir]=cur[3];
            if(arr[y][x]=='#'){
                System.out.println(cur[3]);
                return;
            }
            if(arr[y][x]=='!'){
                if(dir<=1){
                    pq.offer(new int[]{y+diy[2],x+dix[2],2,cur[3]+1});
                    pq.offer(new int[]{y+diy[3],x+dix[3],3,cur[3]+1});
                }else{
                    pq.offer(new int[]{y+diy[0],x+dix[0],0,cur[3]+1});
                    pq.offer(new int[]{y+diy[1],x+dix[1],1,cur[3]+1});
                }
            }
            pq.offer(new int[]{y+diy[dir],x+dix[dir],dir,cur[3]});
        }
        
   
    }
}
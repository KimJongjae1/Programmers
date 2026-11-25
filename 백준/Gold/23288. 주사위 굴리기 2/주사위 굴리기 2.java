import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static int[] diy={0,1,0,-1};
    static int[] dix={1,0,-1,0};
    static int[] row1={2,1,5,6};
    static int[] row2={4,1,3};
    static int[][] arr;
    static int dir;
    static int y;
    static int x;
    static int ans;
    static int N;
    static int M;
    static int K;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        N=Integer.parseInt(st.nextToken());
        M=Integer.parseInt(st.nextToken());
        K=Integer.parseInt(st.nextToken());
        arr=new int[N][M];
        ans=0;
        for(int i=0;i<N;i++){
            st=new StringTokenizer(br.readLine());
            for(int k=0;k<M;k++){
                arr[i][k]=Integer.parseInt(st.nextToken());
            }
        }
        move();
        System.out.println(ans);
        
    }
    public static void move(){
        y=0;
        x=0;
        dir=0;
        while(K>0){
            y+=diy[dir];
            x+=dix[dir];
            if(y<0||x<0||x>=M|y>=N){
                y-=diy[dir];
                x-=dix[dir];
                dir+=2;
                dir%=4;
                continue;
            }

            if(dir==0){
                int n=row2[2];
                row2[2]=row2[1]; row2[1]=row2[0];
                row2[0]=row1[3];
                row1[3]=n;
                row1[1]=row2[1];
            }else if(dir==2){
                int n=row2[0];
                row2[0]=row2[1]; row2[1]=row2[2];
                row2[2]=row1[3];
                row1[3]=n;
                row1[1]=row2[1];
            }else if(dir==3){
                int n=row1[0];
                row1[0]=row1[1];row1[1]=row1[2];row1[2]=row1[3];
                row1[3]=n;
                row2[1]=row1[1];
            }else{
                int n=row1[3];
                row1[3]=row1[2];row1[2]=row1[1];row1[1]=row1[0];
                row1[0]=n;
                row2[1]=row1[1];
            }
            if(arr[y][x]>row1[3]){
                dir--;
                dir=(dir+4)%4;
            }else if(arr[y][x]<row1[3]){
                dir++;
                dir=dir%4;
            }
            ans+=score()*arr[y][x];
 
            K--;
        }
        
    }
    public static int score(){
        Queue<int[]> qu =new LinkedList<>();
        qu.offer(new int[]{y,x});
        boolean[][] visit=new boolean[N][M];
        visit[y][x]=true;
        int cnt=1;
        
        while(!qu.isEmpty()){
            int[] cur=qu.poll();

            for(int i=0;i<4;i++){
                int Y=cur[0]+diy[i];
                int X=cur[1]+dix[i];
                if(Y<0||X<0||X>=M|Y>=N)continue;
                if(visit[Y][X])continue;
                
                if(arr[y][x]!=arr[Y][X])continue;
                visit[Y][X]=true;
                cnt++;
                qu.offer(new int[]{Y,X});
                
            }
        }
        return cnt;
    }
}
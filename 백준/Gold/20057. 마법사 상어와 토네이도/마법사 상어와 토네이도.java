import java.util.*;
import java.io.*;

public class Main{
    static int[] diy={0,1,0,-1};
    static int[] dix={-1,0,1,0};
    static int ans;
    static int N;
    public static void main(String args[]) throws IOException{
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        N=Integer.parseInt(br.readLine());
        int[][] arr=new int[N][N];
        ans=0;
        for(int i=0;i<N;i++){
            StringTokenizer st=new StringTokenizer(br.readLine());
            for(int k=0;k<N;k++){
                arr[i][k]=Integer.parseInt(st.nextToken());
            }
        }

        move(arr);
        System.out.println(ans);


    }
    public static void move(int[][] arr){
        int y=N/2;
        int x=N/2;
        int cnt=0;
        int len=1;
        int dir=0;
      Loop:while(true){
            int L=len;
            while(L>0){
                y+=diy[dir];
                x+=dix[dir];
                wind(arr,dir,y,x);
                if(y==0&&x==0)break Loop;
                L--;
                
            }
            cnt++;
            dir=(dir+1)%4;
            if(cnt==2){
                cnt=0;
                len++;
            }

        }

    }
    public static void wind(int[][] arr,int dir,int y,int x){
        int left=arr[y][x];
        int use=0;

        if(dir==0){
            use+=calculate(arr,y-1,x-1,10,arr[y][x]);
            use+=calculate(arr,y+1,x-1,10,arr[y][x]);
            use+=calculate(arr,y-1,x+1,1,arr[y][x]);
            use+=calculate(arr,y+1,x+1,1,arr[y][x]);

            use+=calculate(arr,y+1,x,7,arr[y][x]);
            use+=calculate(arr,y-1,x,7,arr[y][x]);

            use+=calculate(arr,y+2,x,2,arr[y][x]);
            use+=calculate(arr,y-2,x,2,arr[y][x]);
            use+=calculate(arr,y,x-2,5,arr[y][x]);
            leftover(arr,y+diy[dir],x+dix[dir],left-use);
        }
        else if(dir==1){
            use+=calculate(arr,y+1,x+1,10,arr[y][x]);
            use+=calculate(arr,y+1,x-1,10,arr[y][x]);
            use+=calculate(arr,y-1,x-1,1,arr[y][x]);
            use+=calculate(arr,y-1,x+1,1,arr[y][x]);

            use+=calculate(arr,y,x+1,7,arr[y][x]);
            use+=calculate(arr,y,x-1,7,arr[y][x]);

            use+=calculate(arr,y,x+2,2,arr[y][x]);
            use+=calculate(arr,y,x-2,2,arr[y][x]);
            use+=calculate(arr,y+2,x,5,arr[y][x]);
            leftover(arr,y+diy[dir],x+dix[dir],left-use);
        }
        else if(dir==2){
            use+=calculate(arr,y-1,x-1,1,arr[y][x]);
            use+=calculate(arr,y+1,x-1,1,arr[y][x]);
            use+=calculate(arr,y-1,x+1,10,arr[y][x]);
            use+=calculate(arr,y+1,x+1,10,arr[y][x]);

            use+=calculate(arr,y+1,x,7,arr[y][x]);
            use+=calculate(arr,y-1,x,7,arr[y][x]);

            use+=calculate(arr,y+2,x,2,arr[y][x]);
            use+=calculate(arr,y-2,x,2,arr[y][x]);
            use+=calculate(arr,y,x+2,5,arr[y][x]);
            leftover(arr,y+diy[dir],x+dix[dir],left-use);
        }
        else{
            use+=calculate(arr,y+1,x+1,1,arr[y][x]);
            use+=calculate(arr,y+1,x-1,1,arr[y][x]);
            use+=calculate(arr,y-1,x-1,10,arr[y][x]);
            use+=calculate(arr,y-1,x+1,10,arr[y][x]);

            use+=calculate(arr,y,x+1,7,arr[y][x]);
            use+=calculate(arr,y,x-1,7,arr[y][x]);

            use+=calculate(arr,y,x+2,2,arr[y][x]);
            use+=calculate(arr,y,x-2,2,arr[y][x]);
            use+=calculate(arr,y-2,x,5,arr[y][x]);
            leftover(arr,y+diy[dir],x+dix[dir],left-use);
        }
        
       
    }
    public static int calculate(int[][] arr,int y,int x,int per,int sand){
        if(y<0||x<0||x>=N||y>=N){
            ans+=(sand*per)/100;
        }else{
            arr[y][x]+=(sand*per)/100;
        }
        return (sand*per)/100;
    }
    public static void leftover(int[][] arr,int y,int x,int sand){
        if(y<0||x<0||x>=N||y>=N){
            ans+=sand;
        }else{
            arr[y][x]+=sand;
        }

    }
}
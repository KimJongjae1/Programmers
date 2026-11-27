import java.util.*;
import java.lang.*;
import java.io.*;

// The main method must be in a class named "Main".
class Main {
    static Set<Integer> set;
    public static void main(String[] args)throws IOException {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st=new StringTokenizer(br.readLine());
        int N=Integer.parseInt(st.nextToken());
        int M=Integer.parseInt(st.nextToken());
        int K=Integer.parseInt(st.nextToken());

        set=new HashSet<>();
        Queue<int[]>qu=new LinkedList<>();
        qu.offer(new int[]{N,M,K,0});
        while(!qu.isEmpty()){
            int[] cur=qu.poll();

            if(cur[0]==cur[1]&&cur[1]==cur[2]){
                System.out.println(1);
                return;
            }
            
            for(int i=0;i<3;i++){
                for(int k=i+1;k<3;k++){
                    int[] a=new int[3];
                    for(int q=0;q<3;q++)
                        a[q]=cur[q];

                    if(divide(a,i,k)){
                        qu.offer(a);
                    }
                }
            }
        }
        System.out.println(0);
    }
    public static boolean check(int[] arr){
        Arrays.sort(arr);
        int hash=arr[0]*1000000+arr[1]*1000+arr[2];
        if(set.contains(hash))return false;
        
        set.add(hash);
        return true;
        
    }
    public static boolean divide(int[] cur,int i,int k){
        int temp1=Math.min(cur[i],cur[k]);
        int temp2=Math.max(cur[i],cur[k]);
        cur[i]=temp1*2;
        cur[k]=temp2-temp1;
        return check(cur);
    }
}
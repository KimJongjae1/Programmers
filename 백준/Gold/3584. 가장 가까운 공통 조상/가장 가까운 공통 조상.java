import java.io.*;
import java.util.*;


public class Main {
     public static void main(String[] args) throws Exception{
    	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	 
    	 int T=Integer.parseInt(br.readLine());
    	 
    	 for(int t=0;t<T;t++) {
    		 int N=Integer.parseInt(br.readLine());
    	
        	 int[] arr=new int[N+1];
        	 
        	 for(int i=0;i<N-1;i++) {
        		 StringTokenizer st=new StringTokenizer(br.readLine());
        		 int A=Integer.parseInt(st.nextToken());
        		 int B=Integer.parseInt(st.nextToken());
        		 arr[B]=A;
        		 
        	 }
        	
        	 StringTokenizer st=new StringTokenizer(br.readLine());
    		 int A=Integer.parseInt(st.nextToken());
    		 int B=Integer.parseInt(st.nextToken());
        	 findParent(A,B,arr);
    	 }
    	 
     }
    public static int findDepth(int a,int[] arr) {
    	if(arr[a]==0) return 0;
    	return findDepth(arr[a],arr)+1;
    }

    public static void findParent(int A,int B,int[] arr) {
    	int DepA=findDepth(A,arr);
    	int DepB=findDepth(B,arr);
    	while(DepA!=DepB) {
    		if(DepA>DepB) {
    			A=arr[A];
    			DepA--;
    		}
    		else {
    			B=arr[B];
    			DepB--;
    		}
    	}
    	
    	while(A!=B) {
    		A=arr[A];
    		B=arr[B];
    	}
    	
    	System.out.println(A);
    }
     
}
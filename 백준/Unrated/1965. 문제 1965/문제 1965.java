import java.io.*;
import java.util.*;


public class Main {
     public static void main(String[] args) throws Exception{
    	 BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
    	 
    	 int N=Integer.parseInt(br.readLine());
    	 List<Integer> list=new ArrayList<>();
    	 StringTokenizer st=new StringTokenizer(br.readLine());
    	 for(int i=0;i<N;i++) {
    		 int n=Integer.parseInt(st.nextToken());
    		 
    		 int idx=binary(n,list);
    		 if(list.size()==idx)list.add(n);
    		 else list.set(idx,n);

    		 
    	 }
   
    	  System.out.println(list.size());
    	 
     }
     public static int binary(int n,List<Integer> list) {
    	 int max=list.size();
    	 int min=0;
    	 while(min<max) {
    		 int mid=(max+min)/2;
    		 
    		 if(list.get(mid)<n) {
    			 min=mid+1;
    		 }else {
    			 max=mid;
    		 }
    	 }
    	 return min;
    	 
     }
}
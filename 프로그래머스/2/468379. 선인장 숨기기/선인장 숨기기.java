import java.util.*;
class Solution {
    public int[] solution(int m, int n, int h, int w, int[][] drops) {
         int[][] arr=new int[m][n];
        int N=500002;
         for(int i=0;i<m;i++){
             Arrays.fill(arr[i],N);
         }
        for(int i=0;i<drops.length;i++){
            arr[drops[i][0]][drops[i][1]]=i+1;
        }
        
        Deque<Integer> dq=new ArrayDeque<>();
        for(int i=0;i<m;i++){
            
            for(int k=0;k<n;k++){
                
                while(!dq.isEmpty()&&arr[i][dq.peekLast()]>arr[i][k]){
                    dq.pollLast();
                }
                
                while(!dq.isEmpty()&&k-dq.peekFirst()>=w){
                    dq.pollFirst();
                }
                
                dq.offerLast(k);

                if(k>=w-1){
                    arr[i][k-w+1]=arr[i][dq.peekFirst()];
                }
            }
            dq.clear();
        }
        

        
        for(int k=0;k<n-w+1;k++){
             for(int i=0;i<m;i++){ 
                 
                 while(!dq.isEmpty()&&arr[dq.peekLast()][k]>arr[i][k]){
                    dq.pollLast();
                 }
                
                while(!dq.isEmpty()&&i-dq.peekFirst()>=h){
                    dq.pollFirst();
                 }
                
                dq.offerLast(i);
                
                if(i>=h-1){
                    arr[i-h+1][k]=arr[dq.peekFirst()][k];
                }
                
            }
            dq.clear();
        }
        
        int[] ans=new int[2];
        int max=0;
        for(int i=0;i<m-h+1;i++){
            for(int k=0;k<n-w+1;k++){
                if(arr[i][k]>max){
                    max=arr[i][k];
                    ans[0]=i;
                    ans[1]=k;
                }
            }
        }

        return ans;
    }
}
import java.util.*;
class Solution {
    static int ans;
    static Map<String,Integer> map;
    static int[][] arr;
    public int solution(int[] picks, String[] minerals) {
        ans=Integer.MAX_VALUE;
        map=new HashMap<>();
        map.put("diamond",0);
        map.put("iron",1);
        map.put("stone",2);
        arr=new int[3][3];
        Arrays.fill(arr[0],1);
        Arrays.fill(arr[1],1);
        arr[1][0]=5;
        arr[2][0]=25;
        arr[2][1]=5;
        arr[2][2]=1;
        int cnt=picks[0]+picks[1]+picks[2];
       
            if(picks[0]>0){
                picks[0]--;
                BACK(picks,minerals,cnt-1,0,0,0);
                picks[0]++;
            }
            if(picks[1]>0){
                picks[1]--;
                BACK(picks,minerals,cnt-1,0,0,1);
                picks[1]++;
            }
            if(picks[2]>0){
                picks[2]--;
                BACK(picks,minerals,cnt-1,0,0,2);
                picks[2]++;
            }
            

        return ans;
    }
    public static void BACK(int[] picks,String[] minerals,int cnt,int stress,int idx,int shovel){

        if(idx>=minerals.length){
            ans=Math.min(ans,stress);
            return;
        }
        
     
            
          for(int i=idx;i<idx+5&&i<minerals.length;i++){
               int x=map.get(minerals[i]);
               stress+=arr[shovel][x];
          } 

          if(cnt==0){
             ans=Math.min(ans,stress);
              return;
          }  
            if(picks[0]>0){
                picks[0]--;
                BACK(picks,minerals,cnt-1,stress,idx+5,0);
                picks[0]++;
            }
            if(picks[1]>0){
                picks[1]--;
                BACK(picks,minerals,cnt-1,stress,idx+5,1);
                picks[1]++;
            }
            if(picks[2]>0){
                picks[2]--;
                BACK(picks,minerals,cnt-1,stress,idx+5,2);
                picks[2]++;
            }
        
        
        
        
        
    }
}
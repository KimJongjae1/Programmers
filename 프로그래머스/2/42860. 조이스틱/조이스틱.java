import java.util.*;
class Solution {
    static int ans;
    static Map<Character,Integer> map;
    public int solution(String name) {
        ans=Integer.MAX_VALUE;
        map=new HashMap<>();
        for(char i='A';i<='Z';i++){
            int a=i-'A';
            int z='Z'-i+1;
            map.put(i,Math.min(a,z));
        }
        int cnt=0;
        for(int i=0;i<name.length();i++){
            if(name.charAt(i)!='A')cnt++;
        }
        
        
        char[] S=new char[name.length()];
        Arrays.fill(S,'A');
        DFS(S,name,0,0,1,cnt);
        Arrays.fill(S,'A');
        DFS(S,name,0,0,-1,cnt);
        
        return ans;
    }
    public static void DFS(char[] S,String name,int idx,int sum,int dir,int cnt){
        if(sum-1>=ans)return;
        if(cnt==0){
            ans=Math.max(sum-1,0);
            return;
        }
        if(idx<0)idx=name.length()-1;
        if(idx==name.length())idx=0;
        
        char change=name.charAt(idx);
        
        if(S[idx]==change){
            DFS(S,name,idx+dir,sum+1,dir,cnt);
        }
        else {
            int n=map.get(change);
            char ori=S[idx];
            S[idx]=change;      
        
        
            DFS(S,name,idx+1,sum+n+1,1,cnt-1);
            DFS(S,name,idx-1,sum+n+1,-1,cnt-1);
            S[idx]=ori;
        }
        
        
    }
    public static boolean check(char[] S,String name){
        for(int i=0;i<S.length;i++){
            if(name.charAt(i)!=S[i])return false;
        }
        return true;
    }
   
}
import java.util.*;
class Solution {
    static int[] order;
    static int N;
    static int ans;
    static Set<Integer> set;
    public int solution(String[][] relation) {
        N=relation[0].length;
        ans=0;
        order=new int[N];
        set=new HashSet<>();
        
      for(int n=1;n<=N;n++){
        for(int i=0;i<N;i++){
            DFS(i,relation,n); 
        }
      }

        return ans;
    }
    public static void DFS(int level,String[][] s,int cnt){
        if(cnt==0){
            boolean uniq=unique(s);
            if(uniq){
                boolean ret=check();
  
                if(ret)ans++;  
            }
            return;
        }
        if(level==N)return;
        
        order[level]=1;
        DFS(level+1,s,cnt-1);
        
        order[level]=0;
        DFS(level+1,s,cnt);

    }
    public static boolean check(){
        int num=0;
        int multi=1;
        for(int i=0;i<N;i++){
            if(order[i]==1){
                num=num+order[i]*multi;
            }
            multi*=2;
        }
        for(int hash:set){
            if((hash&num)==hash)
                return false;
        }
        set.add(num);
        return true;
    }
    
    
    public static boolean unique(String[][] s){
        Set<String> set=new HashSet<>();
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<s.length;i++){
            
            for(int k=0;k<s[i].length;k++){
                if(order[k]==0)continue;
                String att=s[i][k];
                sb.append(att);
            }
            String hash=new String(sb.toString());
            
            if(set.contains(hash))return false;
            set.add(hash);
            sb.delete(0,sb.length());
        }

        return true;
    }
}
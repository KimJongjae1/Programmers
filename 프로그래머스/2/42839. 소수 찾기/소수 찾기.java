import java.util.*;
class Solution {
    static int N;
    static int ans;
    static boolean[] visit;
    static Set<Integer> set;
    public int solution(String numbers) {
        N=0;
        ans=0;
        set=new HashSet<>();
        visit=new boolean[numbers.length()];
        ALL(numbers,0,0);
        return ans;
    }public static void ALL(String numbers,int sum,int level){
        if(level==numbers.length()){
            if(sum<=1)return;
            if(!check(sum)||set.contains(sum))return;
            set.add(sum);
            ans++;
            return;
        }
        ALL(numbers,sum,level+1);
        for(int i=0;i<numbers.length();i++){
            if(visit[i])continue;
            visit[i]=true;
            int n=numbers.charAt(i)-'0';
            ALL(numbers,sum*10+n,level+1);
            visit[i]=false;
            
        }
        
    }
    public static boolean check(int n){
        int H=(int)Math.sqrt(n)+1;
        for(int i=2;i<H;i++){
            if(n%i==0)return false;
        }
        return true;
    }
}
import java.util.*;
class Solution {
    static List<Integer>[] list;
    static Set<Integer> set;
    public int solution(int n, int[][] wires) {
 
        list=new ArrayList[n+1];
        set=new HashSet<>();
        for(int i=1;i<=n;i++){
            list[i]=new ArrayList<>();
        }
        for(int[] w:wires){
            list[w[0]].add(w[1]);
            list[w[1]].add(w[0]);
        }
       return  BFS(n);

    }
    public static int BFS(int n){
        Queue<Integer> qu=new LinkedList<>();
        qu.offer(1);
        boolean[] visit=new boolean[n+1];
        boolean[] v=new boolean[n+1];
        int ret=1000000;
        visit[1]=true;
        while(!qu.isEmpty()){
            int cur=qu.poll();
            
            for(int next:list[cur]){
                if(visit[next])continue;
                visit[next]=true;
                if(CheckIfNotCheck(cur,next)){
                    int diff=Math.abs(CheckGroup(cur,next,v)-CheckGroup(next,cur,v));
     
                    ret=Math.min(ret,diff);
                }
                qu.offer(next);
                
            }
        }
        return ret;
    }
    public static boolean CheckIfNotCheck(int cur,int next){
        int hash1=cur*1000+next;
        if(set.contains(hash1))return false;
        set.add(hash1);
        set.add(next*1000+cur);
        return true;
    }
    public static void MakeVisit(int cur,int next,boolean[] v){
        Arrays.fill(v,false);
        v[cur]=true;
        v[next]=true;

    }
    public static int CheckGroup(int c,int n,boolean[] v){
        Queue<Integer> qu=new LinkedList<>();
        MakeVisit(c,n,v);
        qu.offer(c);
        int cnt=1;
        while(!qu.isEmpty()){
            int cur=qu.poll();
             
             for(int next:list[cur]){
                if(v[next])continue;
                 v[next]=true;
                 cnt++;
                 qu.offer(next);
            }
         }
        return cnt;
    }
}
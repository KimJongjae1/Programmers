import java.util.*;
class Solution {
    static int max;
    static List<int[]>[] list;
    static Set<Integer> set;
    public int solution(int n, int infection, int[][] edges, int k) {
        max=1;
        list=new ArrayList[n+1];
        set=new HashSet<>();
        set.add(infection);
        for(int i=1;i<=n;i++)
            list[i]=new ArrayList<>();
        
        for(int i=0;i<edges.length;i++){
            list[edges[i][0]].add(new int[]{edges[i][1],edges[i][2]});
            list[edges[i][1]].add(new int[]{edges[i][0],edges[i][2]});
        }
        BACK(k);
        return max;
    }
    public static void BACK(int k){
        if(k==0){
            max=Math.max(max,set.size());
            return;
        }

        for(int i=1;i<=3;i++){
            Queue<Integer> qu=new LinkedList<>(set);
            List<Integer> remove=new ArrayList<>();
            while(!qu.isEmpty()){
                int cur=qu.poll();
                
                for(int[] next:list[cur]){
                    if(next[1]!=i)continue;
                    if(set.contains(next[0]))continue;
                    set.add(next[0]);
                    remove.add(next[0]);
                    qu.offer(next[0]);
                }
            }
            
            BACK(k-1);
            for(int re:remove){
                set.remove(re);
            }
           
            
        }
        
    }
}
import java.util.*;
class Solution {
    static Set<Integer>[] Q;
    static int[] temp;
    static int answer;
    public int solution(int n, int[][] q, int[] ans) {
        answer = 0;
        Q=new HashSet[q.length];
        for(int i=0;i<q.length;i++){
            Q[i]=new HashSet<>();
            for(int k=0;k<5;k++){
                Q[i].add(q[i][k]);
            }
        }
        temp=new int[5];
        BACK(0,ans,n,1);
        return answer;
    }
    public static void BACK(int level,int[] ans,int n,int N){
        if(level==5){
            if(check(ans))answer++;
            return;
        }
        
        for(int i=N;i<=n;i++){
            temp[level]=i;
            BACK(level+1,ans,n,i+1);
        }
    }
    public static boolean check(int[] ans){
        
        for(int i=0;i<ans.length;i++){
            int cnt=0;
            for(int k=0;k<5;k++){
                if(Q[i].contains(temp[k]))cnt++;
            }
            if(ans[i]!=cnt)return false;
        }
        return true;
        
    }
}
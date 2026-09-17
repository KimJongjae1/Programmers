class Solution {
    static int c;
    static int N;
    static int K;
    static int[] h;
    public int solution(int[][] cost, int[][] hint) {
        N=cost.length;
        K=hint[0].length;
        c=Integer.MAX_VALUE;
        h=new int[N+1];
        BACK(cost,hint,0,0);
        return c;
    }
    public static void BACK(int[][] cost,int[][] hint,int level,int sum){
        if(level==N){
            c=Math.min(c,sum);
            return;
        }
        int hintcnt=Math.min(h[level],N-1);
        if(level==N-1){
            BACK(cost,hint,level+1,sum+cost[level][hintcnt]);
            return;
        }
        
        
        BACK(cost,hint,level+1,sum+cost[level][hintcnt]);
        
        for(int i=1;i<K;i++){
            h[hint[level][i]-1]++;
        }
        BACK(cost,hint,level+1,sum+cost[level][hintcnt]+hint[level][0]);
        for(int i=1;i<K;i++){
            h[hint[level][i]-1]--;
        }
        
    }
}
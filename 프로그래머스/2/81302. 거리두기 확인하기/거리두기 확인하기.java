class Solution {
    public int[] solution(String[][] places) {
        int[] ans=new int[places.length];

      Loop:for(int i=0;i<5;i++){
            for(int k=0;k<5;k++){
                for(int q=0;q<5;q++){
                    if(places[i][k].charAt(q)!='P')continue;
                    
                    char R=check(k,q+1,places[i]);
                    char D=check(k+1,q,places[i]);
                    char RD=check(k+1,q+1,places[i]);
                    char RR=check(k,q+2,places[i]);
                    char DD=check(k+2,q,places[i]);
                    char U=check(k-1,q,places[i]);
                    char UR=check(k-1,q+1,places[i]);
                    
                    if(R=='P'||D=='P'){
                        continue Loop;
                    }else if(RD=='P'&&!(R=='X'&&D=='X')){
                        continue Loop;
                    }else if(RR=='P'&&R!='X'){
                        continue Loop;
                    }else if(DD=='P'&&D!='X')
                        continue Loop;     
                    else if(UR=='P'&&!(U=='X'&&R=='X'))
                        continue Loop;
                    
                }
            }
            ans[i]=1;
        }
        return ans;
        
    }
    public static char check(int y,int x,String[] s){
        if(y<0||y>=5||x>=5)return 'X';
        else return s[y].charAt(x);
    }
}
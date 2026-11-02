class Solution {
    static StringBuilder ans;
    public String solution(String number, int k) {
        ans =new StringBuilder();
        
        int len=number.length()-k;
        int idx=0;
        while(idx<number.length()&&len>0){
            
            int n=-1;
            int id=0;
            for(int i=idx;i<=number.length()-len;i++){
                int N=number.charAt(i)-'0';
                if(n<N){
                    n=N;
                    id=i;
                }
            }
            ans.append((char)(n+'0'));
            idx=id+1;
            len--;
        }
        

        return ans.toString();
    }

}
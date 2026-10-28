class Solution {
    public int solution(int[] queue1, int[] queue2) {
        int N=queue1.length;
        int M=queue2.length;
        int one=0;
        int two=N;
        long sum1=0;
        long sum2=0;
        
        int[] arr=new int[N+M];
        for(int i=0;i<N;i++){
            sum1+=queue1[i];
            arr[i]=queue1[i];
        }
        for(int i=0;i<M;i++){
            sum2+=queue2[i];
            arr[i+N]=queue2[i];
        }
        long sum=sum1+sum2;
        if(sum%2>0)return -1;

        int ans=0;
        int len=N+M;
        boolean O=false;
        boolean T=false;
        while(ans<len*3){
            if(sum1<sum2){
                sum1+=arr[two];
                sum2-=arr[two];
                two++;
            }else if(sum1>sum2){
                sum1-=arr[one];
                sum2+=arr[one];
                one++;
            }else{
                break;
            }
            if(one>=len) O=true;
            if(two==N)T=true;
            
            one%=len;
            two%=len;
            ans++;
        }
      
        if(sum1==sum2)return ans;
       
        return -1;
        
        
    }
}
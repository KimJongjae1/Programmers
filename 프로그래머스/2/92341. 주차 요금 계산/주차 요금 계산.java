import java.util.*;
class Solution {
    public int[] solution(int[] fees, String[] records) {
        Map<Integer,Integer> InOut =new HashMap<>();
        TreeMap<Integer,Integer> SumTime=new TreeMap<>();
        
        for(String r:records){
            StringTokenizer st=new StringTokenizer(r);
            
            String Time=st.nextToken();
            int H=Integer.parseInt(Time.substring(0,2));
            int M=Integer.parseInt(Time.substring(3,5));
            
            int CarNum=Integer.parseInt(st.nextToken());
            char a= st.nextToken().charAt(0);
            if(a=='I'){
                InOut.put(CarNum,H*100+M);
            }else{
                int T=InOut.get(CarNum);
                int t=(H-T/100)*60+M-T%100;
                InOut.remove(CarNum);
                
                SumTime.putIfAbsent(CarNum,0);
                SumTime.put(CarNum,SumTime.get(CarNum)+t);
            }
        }
        
        for(int CarNum:InOut.keySet()){
            int T=InOut.get(CarNum);
            int t=(23-T/100)*60+59-T%100;

            SumTime.putIfAbsent(CarNum,0);
            SumTime.put(CarNum,SumTime.get(CarNum)+t);
        }
     
        Integer CarNum=SumTime.higherKey(-1);
        int[] ans=new int[SumTime.size()];
        int idx=0;
        while(CarNum!=null){
            int T=SumTime.get(CarNum);
            int cost=GetCost(T,fees);
            ans[idx++]=cost;
            
            CarNum=SumTime.higherKey(CarNum);
        }
        return ans;
        
        
    }
    public int GetCost(int t,int[] fees){
        int ret=fees[1];
        t-=fees[0];
        if(t>0){
           if(t%fees[2]>0) ret+= (t/fees[2]+1)*fees[3];
           else ret+= (t/fees[2])*fees[3];
        }
        return ret;
    }
}
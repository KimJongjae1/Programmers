import java.util.*;
class Solution {
   class pair implements Comparable<pair>{
        String name;
        int T;
        int taskTime;
        
        pair(String name,int T,int taskTime){
            this.name=name;
            this.T=T;
            this.taskTime=taskTime;
        }
        
        public int compareTo(pair a){
            return this.T-a.T;

        }
    }
    public String[] solution(String[][] plans) {
        PriorityQueue<pair> pq=new PriorityQueue<>();
        
        for(int i=0;i<plans.length;i++){
            String name=plans[i][0];
            StringTokenizer st=new StringTokenizer(plans[i][1],":",false);
            int H=Integer.parseInt(st.nextToken());
            int M=Integer.parseInt(st.nextToken());
            int taskTime=Integer.parseInt(plans[i][2]);
            int T=H*60+M;
            pair P=new pair(name,T,taskTime);
            pq.offer(P);
        }
        
        pair BeforeTask=pq.poll();
        int BTime=BeforeTask.T+BeforeTask.taskTime;
        Stack<pair> stack=new Stack<>();
 
        List<String> list=new ArrayList<>();
        
        while(!pq.isEmpty()){
            pair next=pq.poll();

            int ATime=next.T+next.taskTime;
            if(BTime>next.T){
                BeforeTask.taskTime-=next.T-BeforeTask.T;
                stack.push(BeforeTask);
            }else {
                int Left=next.T-BTime;
                list.add(BeforeTask.name);
                
                while(!stack.isEmpty()){
                    pair L=stack.pop();
                    if(L.taskTime<=Left){
                        list.add(L.name);
                        Left-=L.taskTime;
                    }else{
                        L.taskTime-=Left;
                        stack.push(L);
                        Left=0;
                    }
                    
                    if(Left<=0)break;
                }
            }
            BeforeTask=next;
            BTime=BeforeTask.T+BeforeTask.taskTime;
            
        }
        
        list.add(BeforeTask.name);
        while(!stack.isEmpty()){
            list.add(stack.pop().name);
        }
        String[] ans=new String[list.size()];
        for(int i=0;i<list.size();i++){
            ans[i]=list.get(i);
        }
        return ans;
        
    }
}
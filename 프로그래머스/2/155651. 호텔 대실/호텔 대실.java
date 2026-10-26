import java.util.*;
class Solution {
    class pair{
        int S;
        int E;
            
        pair(int S,int E){
            this.S=S;
            this.E=E;
        }

    }
    public int solution(String[][] book_time) {
        List<pair> list=new ArrayList<>();
        for(int i=0;i<book_time.length;i++){
            StringTokenizer st=new StringTokenizer(book_time[i][0],":");
            int S=Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken());
            st=new StringTokenizer(book_time[i][1],":");
            int E=Integer.parseInt(st.nextToken())*100+Integer.parseInt(st.nextToken());
            
            list.add(new pair(S,E));
        }
        Collections.sort(list,new Comparator<pair>(){
            @Override
            public int compare(pair a,pair b){
                if(b.S!=a.S)return a.S-b.S;
                return a.E-b.E; 
            }
        });
        
        PriorityQueue<pair> pq=new PriorityQueue<>(new Comparator<pair>(){
            @Override
            public int compare(pair a,pair b){
                return a.E-b.E; 
            }
        });
        int max=1;
        for(int i=0;i<list.size();i++){
            pair cur=list.get(i);
            
            while(!pq.isEmpty()){
                int E=pq.peek().E+10;
                if(E%100>=60){
                     E += 40;
                }
                
                if(E<=cur.S)pq.poll();
                else break;
            }
         
            pq.offer(cur);
            max=Math.max(max,pq.size());
        }
        return max;
    }
}
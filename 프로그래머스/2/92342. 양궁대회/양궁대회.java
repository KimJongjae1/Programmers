class Solution {
    static int[] ans;
    static int diff;
    public int[] solution(int n, int[] info) {
        diff=0;
        ans=new int[11];
        int appeach=0;
        for(int i=0;i<11;i++){
            if(info[i]>0){
                appeach+=10-i;
            }
        }
        back(n,info,0,appeach,0,new int[11]);
        if(diff==0)return new int[]{-1};
        else return ans;
        
    }
    public static void back(int arrow,int[] info,int idx,int appeach,int rion,int[] arr){
        if(arrow==0||idx==11){
             if(arrow>0){
                arr[10]+=arrow;
             }
            if(appeach<rion){
                if(diff<rion-appeach){
                    diff=rion-appeach;
                    for(int i=0;i<11;i++){
                        ans[i]=arr[i];
                    }
 
                }else if(diff==rion-appeach){
   
                     for(int i=10;i>=0;i--){
                        if(arr[i]>ans[i]){
                            for(int k=0;k<11;k++){
                                ans[k]=arr[k];
                             }
                            break;
                        }else if(arr[i]<ans[i])break;
                     }  
                    
                    
                    
                }
            }
            return;
        }
        
        if(info[idx]==0){           
            arr[idx]=1;
            back(arrow-1,info,idx+1,appeach,rion+10-idx,arr);
        }
        else{
            if(info[idx]<arrow){
                arr[idx]=info[idx]+1;
                back(arrow-info[idx]-1,info,idx+1,appeach-10+idx,rion+10-idx,arr);
            }
        }
        
        arr[idx]=0;
        back(arrow,info,idx+1,appeach,rion,arr);
        arr[idx]=0;
    }
}
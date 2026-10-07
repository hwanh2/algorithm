class Solution {
    public long solution(int cap, int n, int[] deliveries, int[] pickups) {
        long answer = 0;
        int di = -1;
        int pi = -1;
        
        for(int i=0; i<deliveries.length; i++){
            if(deliveries[i]!=0){
                di = i;
            }
            if(pickups[i]!=0){
                pi = i;
            }
        }
        
        while(di>=0 || pi>=0){
            int len = Math.max(di,pi)+1;
            answer+=len*2;
            
            int tmp = cap;
            while(di>=0 && tmp>0){
                if(deliveries[di]<=tmp){
                    tmp-=deliveries[di];
                    deliveries[di]=0;
                }
                else{
                    deliveries[di]-=tmp;
                    tmp = 0;
                }
                while (di >= 0 && deliveries[di] == 0) di--;
            }
            
            tmp = cap;
            while(pi>=0 && tmp>0){
                if(pickups[pi]<=tmp){
                    tmp-=pickups[pi];
                    pickups[pi]=0;
                }
                else{
                    pickups[pi]-=tmp;
                    tmp = 0;
                }
                while (pi >= 0 && pickups[pi] == 0) pi--;
            }
            
        }
        
        return answer;
    }
}
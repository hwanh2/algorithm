class Solution {
    public int solution(int[] diffs, int[] times, long limit) {
        int start = 1;
        int end = 100000;
        
        while(start<=end){
            int level = (start+end)/2;
            long count = times[0];
            
            for(int i=1; i<diffs.length; i++){
                if(diffs[i]<level){
                    count+=times[i];
                }
                else{
                    count+=(diffs[i]-level) * (times[i]+times[i-1]) + times[i];
                }
            }
            
            if(count>limit){
                start = level+1;
            }
            else{
                end = level-1;
            }
        }
        return end+1;
    }
}
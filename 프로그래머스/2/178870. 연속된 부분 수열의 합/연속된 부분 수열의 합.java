class Solution {
    public int[] solution(int[] sequence, int k) {
        int[] answer = new int[2];
        
        int len = 1000001;
        
        int left = 0;
        int sum = 0;
        
        for(int right=0; right<sequence.length; right++){
            sum+=sequence[right];
            
            while(sum > k) {
                sum -= sequence[left];
                left++;
            }
            
            if(sum==k && (right-left<len)){
                answer[0] = left;
                answer[1] = right;
                len = right-left;
            }
        }
        
        return answer;
        
    }
}
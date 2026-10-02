class Solution {
    public int solution(int n, int[] stations, int w) {
        int answer = 0;
        int dist = w*2+1;
        int start = 1;
        
        for(int station : stations){
            int end = station-w-1;
            if (start <= end) { 
                int range = end - start+1;
                answer += (range-1) / dist+1;
            }
            start = station+w+1;
        }

        if (start <= n) {
            int range = n-start+1;
            answer += (range-1) / dist+1;
        }
        
        return answer;
    }
}
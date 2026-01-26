class Solution {
    static int change(int time){
        time+=10;
        if(time%100>=60){
            time+=100;
            time-=60;
        }
        return time;
    }
    public int solution(int[] schedules, int[][] timelogs, int startday) {
        int answer = 0;
        
        for(int i=0; i<timelogs.length; i++){
            boolean flag = true;
            int day = 0;
            for(int j=0; j<timelogs[i].length; j++){
                if((startday+day)%7!=6 && (startday+day)%7!=0){
                    if(change(schedules[i])<timelogs[i][j]){
                        flag = false;
                    }
                }
                day++;
            }
            if(flag){
                answer++;
            }
        }
        
        return answer;
    }
}
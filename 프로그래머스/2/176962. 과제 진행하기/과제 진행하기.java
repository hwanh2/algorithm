import java.util.*;
class Solution {
    static PriorityQueue<Work> pq = new PriorityQueue<>();
    static Stack<Work> stop = new Stack<>();
    static class Work implements Comparable<Work> {
        String name;
        int startTime;
        int playTime;
        
        public Work(String name,int startTime,int playTime){
            this.name = name;
            this.startTime = startTime;
            this.playTime = playTime;
        }
        
        @Override
        public int compareTo(Work o){
            return this.startTime - o.startTime;
        }
        
    }
    public String[] solution(String[][] plans) {
        String[] answer = new String[plans.length];
        
        for(String plan[] : plans){
            String name = plan[0];
            String startTime = plan[1];
            int playTime = Integer.parseInt(plan[2]);
            
            StringTokenizer st = new StringTokenizer(startTime,":");
            int h = Integer.parseInt(st.nextToken())*60;
            int m = Integer.parseInt(st.nextToken());
            
            pq.add(new Work(name,h+m,playTime));
        }
        
        int index = 0;
        
        while(!pq.isEmpty()){
            Work currentWork = pq.poll();
            int currentTime = currentWork.startTime;
            if(pq.isEmpty()){
                answer[index++] = currentWork.name;
                while(!stop.isEmpty()){
                    answer[index++] = stop.pop().name;
                }
                break;
            }
            
            Work nextWork = pq.peek();
            
            int remain = nextWork.startTime - currentWork.startTime;
            
            if(currentWork.playTime>remain){
                currentWork.playTime-=remain;
                stop.push(currentWork);
            }
            else{
                answer[index++] = currentWork.name;
                currentTime += currentWork.playTime;
                
                int remainTime = nextWork.startTime - currentTime;
                
                while(remainTime > 0 && !stop.isEmpty()){
                    Work stoppedWork = stop.peek();
                    
                    if(stoppedWork.playTime <= remainTime){
                        remainTime -= stoppedWork.playTime;
                        currentTime += stoppedWork.playTime;
                        answer[index++] = stop.pop().name;
                    } else {
                        stoppedWork.playTime -= remainTime;
                        currentTime += remainTime;
                        remainTime = 0;
                    }
                }
            }
            
        }
        
        return answer;
    }
}
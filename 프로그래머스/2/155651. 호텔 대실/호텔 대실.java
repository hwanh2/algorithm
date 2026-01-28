import java.util.*;
class Solution {
    static int changeTime(String time){
        int result = 0;
        StringTokenizer st = new StringTokenizer(time,":");
        result += Integer.parseInt(st.nextToken())*100;
        result += Integer.parseInt(st.nextToken());
        
        return result;
    }
    static int changeCleanTime(int time){
        int minute = time%100;
        
        if(minute+10>=60){
            time+=110;
            time-=60;
        }
        else{
            time+=10;
        }
        
        return time;
    }
    static class BookTime implements Comparable<BookTime>{
        public int startTime;
        public int endTime;
        
        public BookTime(int startTime, int endTime){
            this.startTime = startTime;
            this.endTime = endTime;
        }
        
        @Override
        public int compareTo(BookTime o){
            return this.startTime - o.startTime;
        }
        
    }
    public int solution(String[][] book_time) {
        int answer = 0;
        
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        
        ArrayList<BookTime> list = new ArrayList<>();
        
        for(int i=0; i<book_time.length; i++){
            int startTime = changeTime(book_time[i][0]);
            int endTime = changeTime(book_time[i][1]);
            list.add(new BookTime(startTime,endTime));
        }
        
        Collections.sort(list);
        pq.add(2400);
        
        for(BookTime bookTime : list){
            int lastTime = pq.peek();
            if(lastTime>bookTime.startTime){
                answer++;
            }
            else{
                pq.poll();
            }
            pq.add(changeCleanTime(bookTime.endTime));
        }
        
        return answer;
    }
}
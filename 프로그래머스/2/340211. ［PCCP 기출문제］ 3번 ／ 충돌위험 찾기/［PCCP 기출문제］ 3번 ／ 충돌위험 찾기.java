import java.util.*;
class Solution {
    public int solution(int[][] points, int[][] routes) {
        Map<String,Integer> map = new HashMap<>();
        
        for(int i=0; i<routes.length; i++){
            int startIndex = routes[i][0]-1;
            int startR = points[startIndex][0];
            int startC = points[startIndex][1];
            int time = 0;
            String startKey = startR + "," + startC + "," + time;
            map.put(startKey, map.getOrDefault(startKey, 0) + 1);
            for(int j=1; j<routes[i].length; j++){
                int nextIndex = routes[i][j]-1;
                int nextR = points[nextIndex][0];
                int nextC = points[nextIndex][1];
                while(startR!=nextR){
                    if(startR>nextR){
                        startR--;
                    }
                    else{
                        startR++;
                    }
                    time++;
                    String key = startR+","+startC+","+time;
                    map.put(key,map.getOrDefault(key,0)+1);
                }
                while(startC!=nextC){
                    if(startC>nextC){
                        startC--;
                    }
                    else{
                        startC++;
                    }
                    time++;
                    String key = startR+","+startC+","+time;
                    map.put(key,map.getOrDefault(key,0)+1);
                }
            }
        }
        
        int answer = 0;
        for (int count : map.values()) {
            if (count >= 2) {
                answer++;
            }
        }
        return answer;
    }
}
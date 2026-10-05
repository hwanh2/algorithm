import java.util.*;

class Solution {
    static int bfs(int x,int y,int n){
        boolean[] visited = new boolean[y + 1];
        Queue<int[]> queue = new LinkedList<>();
        queue.offer(new int[] {x,0});
        int result = Integer.MAX_VALUE;
        visited[x] = true;
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[0];
            int count = cur[1];
            
            if(cx==y){
                result = Math.min(result,count);
                break;
            }
            
            if(cx+n<=y && !visited[cx+n]){
                queue.offer(new int[] {cx+n,count+1});
                visited[cx+n] = true;
            }
            if(cx*2<=y && !visited[cx*2]){
                queue.offer(new int[] {cx*2,count+1});
                visited[cx*2] = true;
            }
            if(cx*3<=y && !visited[cx*3] ){
                queue.offer(new int[] {cx*3,count+1});
                visited[cx*3] = true;
            }
        }
        if(result==Integer.MAX_VALUE){
            return -1;
        }
        return result;
    }
    public int solution(int x, int y, int n) {
        int result = bfs(x,y,n);
        
        return result;
    }
}
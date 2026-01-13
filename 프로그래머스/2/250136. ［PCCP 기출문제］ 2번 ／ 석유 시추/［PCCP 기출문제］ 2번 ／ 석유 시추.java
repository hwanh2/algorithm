import java.util.*;

class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static boolean[][] visited;
    static int[] oilSum;
    static void bfs(int[][] land, int r, int c){
        Queue<int[]> queue = new LinkedList<>();
        visited[r][c] = true;
        queue.add(new int[] {r,c});
        int count = 1;
        
        Set<Integer> col = new HashSet<>();
        col.add(c);
        
        while(!queue.isEmpty()){
            int[] tmp = queue.poll();
            int cx = tmp[1];
            int cy = tmp[0];
            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                
                if(nx>=0 && ny>=0 && nx<land[0].length && ny<land.length && land[ny][nx]==1 && !visited[ny][nx]){
                    queue.add(new int[] {ny,nx});
                    visited[ny][nx] = true;
                    col.add(nx);
                    count++;
                }
            }
        }
        for(int num : col){
            oilSum[num]+=count;
        }
        
    }
    public int solution(int[][] land) {
        int answer = 0;
        int n = land.length;
        int m = land[0].length;
        
        visited = new boolean[n][m];
        oilSum = new int[m];
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(land[i][j]==1 && !visited[i][j]){
                    bfs(land,i,j);
                }
            }
        }
        
        for(int num : oilSum){
            answer = Math.max(answer,num);
        }
        
        return answer;
    }
}
import java.util.*;
class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int bfs(String[] maps,int n,int m,boolean[][] visited, int y,int x){
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {y,x});
        visited[y][x] = true;
        int count = maps[y].charAt(x)-'0';
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[1];
            int cy = cur[0];
            
            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && ny>=0 && nx<m && ny<n && maps[ny].charAt(nx)!='X' && !visited[ny][nx]){
                    queue.add(new int[] {ny,nx});
                    visited[ny][nx] = true;
                    count+=maps[ny].charAt(nx)-'0';
                }
            }
        }
        
        return count;
    }
    public int[] solution(String[] maps) {
        ArrayList<Integer> list = new ArrayList<>();
    
        int n = maps.length;
        int m = maps[0].length();
        
        boolean[][] visited = new boolean[n][m];
        
        boolean flag = false;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j)!='X' && !visited[i][j]){
                    list.add(bfs(maps,n,m,visited,i,j));
                    flag = true;
                }
            }
        }
        
        if(!flag){
            int[] answer = {-1};
            return answer;
        }
        int[] answer = new int[list.size()];
        for(int i=0; i<list.size(); i++){
            answer[i] = list.get(i);
        }
        Arrays.sort(answer);
        return answer;
    }
}
import java.util.*;
class Solution {
    static int bfs(String[] board,int r,int c,int n,int m){
        Queue<int[]> queue = new LinkedList<>();
        int[][] visited = new int[n][m];
        visited[r][c] = 1;
        queue.add(new int[] {r,c});
        int[] dx = {0,0,1,-1};
        int[] dy = {1,-1,0,0};
        
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[1];
            int cy = cur[0];
            
            for(int i=0; i<4; i++){
                int x = cx;
                int y = cy;
                
                while(true){
                    int nx = x+dx[i];
                    int ny = y+dy[i];
                    if(nx>=0 && ny>=0 && nx<m && ny<n && board[ny].charAt(nx)!='D'){
                        x=nx;
                        y=ny;
                    }
                    else{
                        break;
                    }
                }
                if(board[y].charAt(x)=='G'){
                    return visited[cy][cx];
                }
                if(visited[y][x]==0){
                    visited[y][x] = visited[cy][cx]+1;
                    queue.add(new int[] {y,x});
                }
            }
            
        }
        return -1;
    }
    public int solution(String[] board) {
        int answer = 0;
        int n = board.length;
        int m = board[0].length();
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(board[i].charAt(j)=='R'){
                    answer = bfs(board,i,j,n,m);
                }
            }
        }
        return answer;
    }
}
import java.util.*;
class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int findL(String[] maps,int r,int c){
        int n = maps.length;
        int m = maps[0].length();
        int[][] visited = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r,c});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[1];
            int cy = cur[0];
            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && ny>=0 && nx<m && ny<n && visited[ny][nx]==0 && maps[ny].charAt(nx)!='X'){
                    if(maps[ny].charAt(nx)=='L'){
                        return visited[cy][cx]+1;
                    }
                    visited[ny][nx] = visited[cy][cx]+1;
                    queue.add(new int[] {ny,nx});
                }
            }
        }
        return -1;
    }
    
    static int findE(String[] maps,int r,int c){
        int n = maps.length;
        int m = maps[0].length();
        int[][] visited = new int[n][m];
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[] {r,c});
        
        while(!queue.isEmpty()){
            int[] cur = queue.poll();
            int cx = cur[1];
            int cy = cur[0];
            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && ny>=0 && nx<m && ny<n && visited[ny][nx]==0 && maps[ny].charAt(nx)!='X'){
                    if(maps[ny].charAt(nx)=='E'){
                        return visited[cy][cx]+1;
                    }
                    visited[ny][nx] = visited[cy][cx]+1;
                    queue.add(new int[] {ny,nx});
                }
            }
        }
        return -1;
        
    }
    public int solution(String[] maps) {
        int answer = 0;
        
        int n = maps.length;
        int m = maps[0].length();
        
        int startR = 0;
        int startC = 0;
        int lR = 0;
        int lC = 0;
        
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(maps[i].charAt(j)=='S'){
                    startR = i;
                    startC = j;
                }
                else if(maps[i].charAt(j)=='L'){
                    lR = i;
                    lC = j;
                }
            }
        }
        int path1 = findL(maps,startR,startC);
        int path2 = findE(maps,lR,lC);
        if(path1==-1){
            return -1;
        }
        if(path2==-1){
            return -1;
        }
        answer+=path1;
        answer+=path2;
        
        return answer;
        
    }
}
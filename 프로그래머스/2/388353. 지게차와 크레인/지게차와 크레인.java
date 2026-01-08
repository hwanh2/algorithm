import java.util.*;
class Solution {
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int n,m;
    static boolean[][] check;
    static Queue<int[]> queue;
    static boolean bfs(int y,int x){
        boolean[][] visited = new boolean[n][m];
        queue = new LinkedList<>();
        queue.add(new int[] {y,x});
        
        while(!queue.isEmpty()){
            int[] c = queue.poll();
            int cy = c[0];
            int cx = c[1];
            
            if(cy==0 || cx==0 || cy==n-1 || cx==m-1){
                return true;
            }
            
            for(int i=0; i<4; i++){
                int ny = cy+dy[i];
                int nx = cx+dx[i];
                if(nx>=0 && ny>=0 && nx<m && ny<n && check[ny][nx] && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    queue.add(new int[] {ny,nx});
                }
            }
        }
        return false;
    }
    public int solution(String[] storage, String[] requests) {
        n = storage.length;
        m = storage[0].length();
        int num = requests.length;
        check = new boolean[n][m];
        
        for(int i=0; i<num; i++){
            boolean[][] copy = new boolean[n][m];
            
            char current = requests[i].charAt(0);
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(requests[i].length()==2){
                        if(storage[j].charAt(k)==current){
                            copy[j][k] = true;
                        }
                    }
                    else{
                        if(storage[j].charAt(k)==current && bfs(j,k)){
                            copy[j][k] = true;
                        }
                    }
                }
            }
            for(int j=0; j<n; j++){
                for(int k=0; k<m; k++){
                    if(copy[j][k]){
                        check[j][k] = true;
                    }
                }
            }
        }
        int answer = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(!check[i][j]){
                    answer++;
                }
            }
        }
        return answer;
    }
}
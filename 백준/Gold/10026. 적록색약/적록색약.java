import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static char[][] array;
    static boolean[][] visited;
    static Queue<int[]> queue;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static void bfs1(){
        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
            for(int i=0; i<4; i++){
                int x = tmp[1]+dx[i];
                int y = tmp[0]+dy[i];
                if(x>=0 && y>=0 && x<n && y<n && array[tmp[0]][tmp[1]]==array[y][x] && visited[y][x]==false){
                    queue.offer(new int[] {y,x});
                    visited[y][x] = true;
                }
            }
        }
    }
    static void bfs2(){
        while (!queue.isEmpty()){
            int[] tmp = queue.poll();
            for(int i=0; i<4; i++) {
                int x = tmp[1] + dx[i];
                int y = tmp[0] + dy[i];
                if(x>=0 && y>=0 && x<n && y<n && visited[y][x]==false){
                    if(array[tmp[0]][tmp[1]]=='R' || array[tmp[0]][tmp[1]]=='G'){
                        if(array[y][x]=='R' || array[y][x]=='G'){
                            queue.offer(new int[] {y,x});
                            visited[y][x] = true;
                        }
                    }
                    else if(array[tmp[0]][tmp[1]]==array[y][x] && visited[y][x]==false){
                        queue.offer(new int[] {y,x});
                        visited[y][x] = true;
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        n = Integer.parseInt(br.readLine());
        array = new char[n][n];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                array[i][j] = str.charAt(j);
            }
        }
        visited = new boolean[n][n];
        queue = new LinkedList<>();
        int count1 = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]==false){
                    queue.offer(new int[] {i,j});
                    visited[i][j] = true;
                    bfs1();
                    count1++;
                }
            }
        }
        visited = new boolean[n][n];
        queue = new LinkedList<>();
        int count2 = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(visited[i][j]==false){
                    queue.offer(new int[] {i,j});
                    visited[i][j] = true;
                    bfs2();
                    count2++;
                }
            }
        }
        sb.append(count1).append(" ").append(count2);
        System.out.println(sb);

    }

}
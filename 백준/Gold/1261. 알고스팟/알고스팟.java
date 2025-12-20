import java.io.*;
import java.util.*;

public class Main {
    static int n,m;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static char[][] map;
    static boolean[][] visited;
    static int result = 0;
    static PriorityQueue<Node> pq;

    static class Node implements Comparable<Node>{
        int x;
        int y;
        int count;

        public Node(int x, int y, int count) {
            this.x = x;
            this.y = y;
            this.count = count;
        }

        @Override
        public int compareTo(Node o) {
            return this.count - o.count;
        }
    }

    static void bfs(){
        pq = new PriorityQueue<>();
        pq.add(new Node(0,0,0));
        visited[0][0] = true;

        while (!pq.isEmpty()){
            Node currnetNode = pq.poll();
            int x = currnetNode.x;
            int y = currnetNode.y;

            if(x==n-1 && y==m-1){
                result = currnetNode.count;
                return;
            }

            for(int i=0; i<4; i++){
                int nx = x+dx[i];
                int ny = y+dy[i];
                if(nx>=0 && ny>=0 && nx<n && ny<m && !visited[ny][nx]){
                    visited[ny][nx] = true;
                    if(map[ny][nx]=='1'){
                        pq.add(new Node(nx,ny,currnetNode.count+1));
                    }
                    else{
                        pq.add(new Node(nx,ny,currnetNode.count));
                    }
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        map = new char[m][n];
        visited = new boolean[m][n];

        for(int i=0; i<m; i++){
            String str = br.readLine();
            for(int j=0; j<n; j++){
                map[i][j] = str.charAt(j);
            }
        }

        bfs();

        System.out.println(result);

    }
}
import java.util.*;
import java.io.*;

class Main {
    static int n,m,k;
    static char[][] map;
    static boolean[][][] visited;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static class Node{
        public int x;
        public int y;
        public int distance;
        public int count;

        public Node(int x,int y,int distance,int count){
            this.x = x;
            this.y = y;
            this.distance = distance;
            this.count = count;
        }
    }
    static int bfs(){
        Queue<Node> queue = new LinkedList<>();
        queue.add(new Node(0,0,1,0));
        visited[0][0][0] = true;

        while(!queue.isEmpty()){
            Node node = queue.poll();
            int cx = node.x;
            int cy = node.y; 
            int cDistance = node.distance;
            int cCount = node.count;
            if(cy == n-1 && cx == m-1){
                return node.distance;
            }
            for(int i=0; i<4; i++){
                int nx = cx+dx[i];
                int ny = cy+dy[i];
                if(nx>=0 && ny>=0 && nx<m && ny<n){
                    if(map[ny][nx]=='0' && !visited[ny][nx][cCount]){
                        visited[ny][nx][cCount] = true;
                        queue.add(new Node(nx,ny,cDistance+1,cCount));
                    }
                    if(map[ny][nx]=='1' && cCount<k && !visited[ny][nx][cCount+1]){
                        visited[ny][nx][cCount+1] = true;
                        queue.add(new Node(nx,ny,cDistance+1,cCount+1));
                    }
                }
            }
        }
        return -1;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());

        map = new char[n][m];
        visited = new boolean[n][m][k+1];

        for(int i=0; i<n; i++){
            String str = br.readLine();
            for(int j=0; j<m; j++){
                map[i][j] = str.charAt(j);
            }
        }

        System.out.println(bfs());
        
    }
}
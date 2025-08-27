import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] array;
    static PriorityQueue<Node> pq;
    static final int INF = Integer.MAX_VALUE;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static int[][] distance;
    static boolean[][] visited;
    static void bfs(){
        pq = new PriorityQueue<>();
        distance = new int[n][n];
        visited = new boolean[n][n];

        for(int i=0; i<n; i++){
            Arrays.fill(distance[i],INF);
        }
        visited[0][0] = true;
        distance[0][0] = array[0][0];
        pq.offer(new Node(0,0,distance[0][0]));

        while (!pq.isEmpty()){
            Node tmp = pq.poll();
            for(int i=0; i<4; i++){
                int x = tmp.x+dx[i];
                int y = tmp.y+dy[i];
                if(x>=0 && y>=0 && x<n && y<n && !visited[y][x]){
                    visited[y][x] = true;
                    int weight = tmp.weight + array[y][x];
                    if(weight<distance[y][x]){
                        distance[y][x] = weight;
                        pq.offer(new Node(x,y,weight));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        int count = 1;
        while (true){
            n = Integer.parseInt(br.readLine());
            if(n==0){
                System.out.println(sb);
                return;
            }
            array = new int[n][n];
            for(int i=0; i<n; i++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                for(int j=0; j<n; j++){
                    array[i][j] = Integer.parseInt(st.nextToken());
                }
            }
            bfs();
            sb.append("Problem "+(count++) +": "+distance[n-1][n-1]).append("\n");
        }
    }
}

class Node implements Comparable<Node>{
    public int x;
    public int y;
    public int weight;

    public Node(int x, int y, int weight) {
        this.x = x;
        this.y = y;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
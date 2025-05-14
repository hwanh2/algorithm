import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] array;
    static int[][] visited;
    static PriorityQueue<Shark> pq;
    static Queue<Shark> queue;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static void bfs(){
        pq = new PriorityQueue<>();
        visited = new int[n][n];
        while(!queue.isEmpty()){
            Shark shark = queue.poll();
            visited[shark.y][shark.x] = 1;
             for(int i=0; i<4; i++){
                int x = shark.x+dx[i];
                int y = shark.y+dy[i];
                if(x>=0 && y>=0 && x<n && y<n && visited[y][x]==0 && array[y][x]<=shark.size){
                    queue.offer(new Shark(x,y,shark.size,shark.distance+1));
                    visited[y][x] = 1;
                    if(array[y][x]!=0 && array[y][x]<shark.size){
                        pq.add(new Shark(x,y,shark.size,shark.distance+1));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        array = new int[n][n];

        pq = new PriorityQueue<>();
        queue = new LinkedList<>();
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                if(array[i][j] == 9){
                    queue.offer(new Shark(j,i,2,0));
                    array[i][j] = 0;
                }
            }
        }
        bfs();
        int distance = 0;
        int eatingCount = 0;
        while(!pq.isEmpty()){
            Shark shark = pq.poll();
            array[shark.y][shark.x] = 0;
            if(++eatingCount==shark.size){
                shark.size++;
                eatingCount = 0;
            }
            distance+=shark.distance;
            queue = new LinkedList<>();
            queue.offer(new Shark(shark.x,shark.y,shark.size,0));
            bfs();
        }
        System.out.println(distance);
    }
}

class Shark implements Comparable<Shark>{
    public int x;
    public int y;
    public int size;
    public int distance;

    public Shark(int x, int y, int size, int distance) {
        this.x = x;
        this.y = y;
        this.size = size;
        this.distance = distance;
    }

    @Override
    public int compareTo(Shark o) {
        if (this.distance != o.distance) {
            return this.distance - o.distance;
        } else if (this.y != o.y) {
            return this.y - o.y;
        } else {
            return this.x - o.x;
        }
    }
}
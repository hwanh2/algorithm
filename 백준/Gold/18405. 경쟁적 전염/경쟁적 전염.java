import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int k;
    static int[][] array;
    static int[][] count;
    static int[] dx = {0,0,1,-1};
    static int[] dy = {1,-1,0,0};
    static Queue<Point> queue;
    static void bfs(int s){
        while (!queue.isEmpty()){
            Point p = queue.poll();
            for(int i=0; i<4; i++){
                int x = p.x+dx[i];
                int y = p.y+dy[i];
                if(x>=0 && y>=0 && x<n && y<n && array[y][x]==0 && count[p.y][p.x]<s){
                    queue.offer(new Point(x,y,array[p.y][p.x]));
                    array[y][x] = array[p.y][p.x];
                    count[y][x] = count[p.y][p.x]+1;
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        k = Integer.parseInt(st.nextToken());
        array = new int[n][n];
        count = new int[n][n];
        queue = new LinkedList<>();
        ArrayList<Point> arrayList = new ArrayList<>();

        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
                if(array[i][j]!=0){
                    arrayList.add(new Point(j,i,array[i][j]));
                }
            }
        }
        Collections.sort(arrayList);

        for(Point p : arrayList){
            queue.offer(new Point(p.x,p.y,p.node));
        }

        st = new StringTokenizer(br.readLine()," ");
        int s = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        bfs(s);

        System.out.println(array[y-1][x-1]);

    }

}
class Point implements Comparable<Point>{
    public int x;
    public int y;
    public int node;

    public Point(int x, int y, int node) {
        this.x = x;
        this.y = y;
        this.node = node;
    }

    @Override
    public int compareTo(Point o) {
        return this.node - o.node;
    }
}



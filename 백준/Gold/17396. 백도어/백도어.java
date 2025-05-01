import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static ArrayList<ArrayList<Edge>> arrayList;
    static PriorityQueue<Edge> pq;
    static int[] isShow;
    static long[] distance;
    static int[] visited;
    static final long INF = Long.MAX_VALUE;
    static void shortestPath(){
        pq = new PriorityQueue<>();
        pq.add(new Edge(0,0));
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            int tmpNode = tmp.node;
            long tmpWeight = tmp.weight;
            if(visited[tmpNode]==0){
                visited[tmpNode] = 1;
                for(Edge edge : arrayList.get(tmpNode)){

                    if((isShow[edge.node]==0 || edge.node == n-1) && distance[edge.node]>tmpWeight + edge.weight){
                        distance[edge.node] = tmpWeight + edge.weight;
                        pq.add(new Edge(edge.node,tmpWeight+edge.weight));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            arrayList.add(new ArrayList<>());
        }
        isShow = new int[n];
        distance = new long[n];
        visited = new int[n];
        Arrays.fill(distance,INF);

        st = new StringTokenizer(br.readLine());
        for(int i=0; i<n; i++){
            isShow[i] = Integer.parseInt(st.nextToken());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(new Edge(b,c));
            arrayList.get(b).add(new Edge(a,c));
        }

        shortestPath();

        if(distance[n-1]==INF){
            System.out.println(-1);
        }
        else{
            System.out.println(distance[n-1]);
        }
    }
}
class Edge implements Comparable<Edge>{
    public int node;
    public long weight;

    public Edge(int node, long weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return Long.compare(this.weight, o.weight);
    }
}

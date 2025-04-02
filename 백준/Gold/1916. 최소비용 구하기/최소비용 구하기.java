import java.io.*;
import java.util.*;

public class Main {
    static final int INF = Integer.MAX_VALUE;
    static int[] distance;
    static int[] visited;
    static PriorityQueue<Edge> pq;
    static List<List<Edge>> arrayList;
    static void shortest_path(int start){
        pq = new PriorityQueue<>();
        pq.add(new Edge(start,0));
        distance[start] = 0;
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            int tmpNode = tmp.node;
            int tmpWeight = tmp.weight;
            if(visited[tmpNode]==0){
                visited[tmpNode] = 1;
                for(Edge edge : arrayList.get(tmpNode)){
                    if(distance[edge.node]>tmpWeight+edge.weight){
                        distance[edge.node] = tmpWeight+edge.weight;
                        pq.add(new Edge(edge.node,tmpWeight+edge.weight));
                    }
                }
            }

        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());
        distance = new int[n+1];
        visited = new int[n+1];
        Arrays.fill(distance,INF);
        arrayList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            arrayList.add(new ArrayList<>());
        }
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(new Edge(b,c));
        }
        st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());
        shortest_path(start);
        System.out.println(distance[goal]);
    }
}
class Edge implements Comparable<Edge>{
    public int node;
    public int weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}


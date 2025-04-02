import java.io.*;
import java.util.*;

public class Main {
    static PriorityQueue<Edge> pq;
    static List<List<Edge>> arrayList;
    static int[] distance;
    static int[] visited;
    static final int INF = Integer.MAX_VALUE;
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
                    if(distance[edge.node]> edge.weight+tmpWeight){
                        distance[edge.node] = edge.weight + tmpWeight;
                        pq.add(new Edge(edge.node, edge.weight+tmpWeight));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        arrayList = new ArrayList<>();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        distance = new int[v+1];
        visited = new int[v+1];
        Arrays.fill(distance,INF); // distance배열 최댓값으로 설정
        for(int i=0; i<=v; i++){
            arrayList.add(new ArrayList<>());
        }
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(new Edge(b,c));
        }
        shortest_path(start);
        for(int i=1; i<=v; i++){
            if(distance[i]==INF){
                sb.append("INF").append("\n");
            }
            else{
                sb.append(distance[i]+"\n");
            }
        }
        System.out.println(sb);

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


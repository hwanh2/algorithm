import java.io.*;
import java.util.*;

public class Main {
    static List<List<Edge>> arrayList;
    static PriorityQueue<Edge> pq;
    static int[] distance;
    static int[] visited;
    static void shortestPath(int start){
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
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        distance = new int[n+1];
        visited = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

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
            arrayList.get(b).add(new Edge(a,c));
        }
        shortestPath(1);
        System.out.println(distance[n]);

    }
}

class Edge implements Comparable<Edge>{
    public int node;
    public int weight;

    public Edge(int node,int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight-o.weight;
    }
}


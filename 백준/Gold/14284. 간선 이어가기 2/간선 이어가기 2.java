import java.io.*;
import java.util.*;

public class Main {
    static List<List<Edge>> arrayList;
    static int[] distance;
    static int[] visited;
    static PriorityQueue<Edge> pq;
    static void shortestPath(int start){
        pq = new PriorityQueue<>();
        pq.add(new Edge(start,0));
        while (!pq.isEmpty()){
            Edge tmp = pq.poll();
            int tmpNode = tmp.node;
            int tmpWeight = tmp.weight;
            if(visited[tmpNode]==0){
                visited[tmpNode] = 1;
                for(Edge edge : arrayList.get(tmpNode)){
                    if(distance[edge.node]>tmpWeight+ edge.weight){
                        distance[edge.node] = tmpWeight+edge.weight;
                        pq.add(new Edge(edge.node,tmpWeight+ edge.weight));
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

        arrayList = new ArrayList<>();
        distance = new int[n+1];
        visited = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

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
        st = new StringTokenizer(br.readLine()," ");
        int start = Integer.parseInt(st.nextToken());
        int goal = Integer.parseInt(st.nextToken());

        shortestPath(start);

        System.out.println(distance[goal]);
    }
}

class Edge implements Comparable<Edge>{
    int node;
    int weight;

    public Edge(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

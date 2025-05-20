import java.io.*;
import java.util.*;

public class Main {
    static int n,m,x;
    static int[] visited;
    static int[] distance;
    static List<List<Edge>> arrayList;
    static PriorityQueue<Edge> pq;
    static int shortestPath(int start,int goal){
        visited = new int[n+1];
        distance = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);
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
                    if(distance[edge.node]>tmp.weight+edge.weight){
                        distance[edge.node] = tmpWeight+edge.weight;
                        pq.add(new Edge(edge.node,tmpWeight+edge.weight));
                    }
                }
            }
        }
        return distance[goal];
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        x = Integer.parseInt(st.nextToken());

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

        int result = 0;

        for(int i=1; i<=n; i++){
            result = Math.max(result,shortestPath(i,x)+shortestPath(x,i));
        }

        System.out.println(result);

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

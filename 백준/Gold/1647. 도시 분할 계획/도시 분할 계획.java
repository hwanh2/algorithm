import java.io.*;
import java.util.*;

public class Main {
    static List<List<Edge>> arrayList;
    static int[] visited;
    static PriorityQueue<Edge> pq;
    static int prim(){
        int count = 0;
        int max = 0;
        pq = new PriorityQueue<>();
        pq.add(new Edge(1,0));
        while (!pq.isEmpty()){
            Edge tmp = pq.poll();
            int tmpNode = tmp.node;
            int tmpWeight = tmp.weight;
            if(visited[tmpNode]==0){
                count+=tmpWeight;
                max = Math.max(max,tmpWeight);
                visited[tmpNode] = 1;
                for(Edge edge : arrayList.get(tmpNode)){
                    if(visited[edge.node]==0){
                        pq.add(new Edge(edge.node,edge.weight));
                    }
                }
            }
        }
        return count - max;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        visited = new int[n+1];
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

        System.out.println(prim());

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

import java.io.*;
import java.util.*;

public class Main {
    static int[] visited;
    static List<List<Edge>> list;
    static PriorityQueue<Edge> pq;
    static int prim(){
        pq = new PriorityQueue<>();
        pq.add(new Edge(0,0));
        int count = 0;
        while (!pq.isEmpty()){
            Edge tmp = pq.poll();
            int tmpNode = tmp.node;
            int tmpWeight = tmp.weight;
            if(visited[tmpNode]==0){
                visited[tmpNode] = 1;
                count+=tmpWeight;
                for(Edge edge : list.get(tmpNode)){
                    if(visited[edge.node]==0){
                        pq.add(new Edge(edge.node, edge.weight));
                    }
                }
            }
        }
        return count;
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        while(true){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            if(n==0 && m==0){
                break;
            }
            visited = new int[n];
            list = new ArrayList<>();
            for(int i=0; i<n; i++){
                list.add(new ArrayList<>());
            }

            int sum = 0;
            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.get(a).add(new Edge(b,c));
                list.get(b).add(new Edge(a,c));
                sum+=c;
            }

            sb.append(sum-prim()).append("\n");


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
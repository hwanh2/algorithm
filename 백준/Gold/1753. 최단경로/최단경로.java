import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Edge>> array;
    static int[] distance;
    static final int INF = Integer.MAX_VALUE;
    static PriorityQueue<Edge> pq;
    static void shortest_path(int start,int v){
        pq = new PriorityQueue<>();
        pq.add(new Edge(start,0));
        distance[start] = 0;
        while(!pq.isEmpty()){
            Edge tmp = pq.poll();
            int tmpNode = tmp.node;
            int tmpWeight = tmp.weight;
            for(Edge edge:array.get(tmpNode)){
                if(distance[edge.node]>tmpWeight+edge.weight){
                    distance[edge.node] = tmpWeight+edge.weight;
                    pq.add(new Edge(edge.node,tmpWeight+edge.weight));
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        array = new ArrayList<>();
        for (int i = 0; i <= v; i++) {
            array.add(new ArrayList<>());
        }
        distance = new int[v+1];
        Arrays.fill(distance,INF);
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            array.get(a).add(new Edge(b,c));
        }
        shortest_path(start,v);
        for(int i=1; i<=v; i++){
            if(distance[i]==INF){
                bw.write("INF"+"\n");
            }
            else{
                bw.write(distance[i]+"\n");
            }
        }
        bw.flush();
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
import java.io.*;
import java.util.*;

public class Main {
    static List<List<Edge>> arrayList;
    static int n;
    static int e;
    static int[] distance;
    static int[] visited;
    static PriorityQueue<Edge> pq;
    static int INF = 200000000;
    static void shortestPath(int start){
        pq = new PriorityQueue<>();
        pq.add(new Edge(start,0));
        distance = new int[n+1];
        visited = new int[n+1];
        Arrays.fill(distance,INF);
        distance[start] = 0;

        while (!pq.isEmpty()){
            Edge tmp = pq.poll();
            int tmpNode = tmp.node;
            int tmpWeight = tmp.weight;
            if(visited[tmpNode]==0){
                visited[tmpNode] = 1;
                for(Edge edge : arrayList.get(tmpNode)){
                    if(distance[edge.node] > tmpWeight+edge.weight){
                        distance[edge.node] = tmpWeight+edge.weight;
                        pq.add(new Edge(edge.node,tmpWeight+edge.weight));
                    }
                }
            }

        }
    }
    static int resultLen(int num1,int num2){
        shortestPath(1);
        int v1Len = distance[num1];
        shortestPath(num1);
        int v2Len = distance[num2];
        shortestPath(num2);
        int result = v1Len+v2Len+distance[n];
        return result;
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        e = Integer.parseInt(st.nextToken());
        arrayList = new ArrayList<>();
        for(int i=0; i<=n; i++){
            arrayList.add(new ArrayList<>());
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arrayList.get(a).add(new Edge(b,c));
            arrayList.get(b).add(new Edge(a,c));
        }
        st = new StringTokenizer(br.readLine()," ");
        int v1 = Integer.parseInt(st.nextToken());
        int v2 = Integer.parseInt(st.nextToken());
        int result1 = resultLen(v1,v2);
        int result2 = resultLen(v2,v1);

        int result = Math.min(result1,result2);
        if(result>=INF){
            System.out.println(-1);
        }
        else{
            System.out.println(result);
        }
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


import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static int[][] distance;
    static boolean[] visited;
    static List<List<Edge>> list;
    static PriorityQueue<Edge> pq;
    static final int INF = Integer.MAX_VALUE;
    static void dijkstra(int count, int start){
        visited = new boolean[n+1];
        pq = new PriorityQueue<>();
        pq.offer(new Edge(start,0));
        distance[count][start] = 0;
        while (!pq.isEmpty()){
            Edge tmp = pq.poll();
            if(!visited[tmp.node]){
                visited[tmp.node] = true;
                for(Edge edge : list.get(tmp.node)){
                    if(distance[count][edge.node]>tmp.weight + edge.weight){
                        distance[count][edge.node] = tmp.weight + edge.weight;
                        pq.offer(new Edge(edge.node, tmp.weight+edge.weight));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());
        for(int l=0; l<t; l++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            n = Integer.parseInt(st.nextToken());
            int m = Integer.parseInt(st.nextToken());
            list = new ArrayList<>();
            for(int i=0; i<=n; i++){
                list.add(new ArrayList<>());
            }

            for(int i=0; i<m; i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());
                int c = Integer.parseInt(st.nextToken());
                list.get(a).add(new Edge(b,c));
                list.get(b).add(new Edge(a,c));
            }
            int k = Integer.parseInt(br.readLine());
            distance = new int[k][n+1];
            for(int i=0; i<k; i++){
                Arrays.fill(distance[i],INF);
            }
            st = new StringTokenizer(br.readLine()," ");
            for(int i=0; i<k; i++){
                dijkstra(i,Integer.parseInt(st.nextToken()));
            }

            int min = INF;
            int result = 0;
            for(int i=1; i<=n; i++){
                int sum = 0;
                for(int j=0; j<k; j++){
                    sum+=distance[j][i];
                }
                if(min>sum){
                    result = i;
                    min = sum;
                }
            }
            sb.append(result).append("\n");
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

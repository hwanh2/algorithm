import java.io.*;
import java.util.*;

public class Main {
    static int n;
    static List<List<Edge>> arrayList;
    static PriorityQueue<Edge> pq;
    static int[] distance;
    static int[] visited;
    static void shortestPath(int start){
        pq = new PriorityQueue<>();
        distance = new int[n+1];
        visited = new int[n+1];
        Arrays.fill(distance,Integer.MAX_VALUE);

        pq.add(new Edge(start,0));
        distance[start] = 0;
        while (!pq.isEmpty()){
            Edge tmp = pq.poll();
            int tmpNode = tmp.node;
            int tmpWeight = tmp.weight;
            if(visited[tmpNode]==0){
                visited[tmpNode] = 1;
                for(Edge edge : arrayList.get(tmpNode)){
                    if(distance[edge.node]>tmpWeight+ edge.weight){
                        distance[edge.node] = tmpWeight+edge.weight;
                        pq.add(new Edge(edge.node,tmpWeight+edge.weight));
                    }
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int k=0; k<t; k++){
            StringTokenizer st = new StringTokenizer(br.readLine());
            n = Integer.parseInt(st.nextToken()); // 컴퓨터 개수
            int d = Integer.parseInt(st.nextToken()); // 의존성 개수
            int c = Integer.parseInt(st.nextToken()); // 해킹당한 컴퓨터 번호

            arrayList = new ArrayList<>();
            for(int i=0; i<=n; i++){
                arrayList.add(new ArrayList<>());
            }

            for(int i=0; i<d; i++){
                st = new StringTokenizer(br.readLine()," ");
                int a = Integer.parseInt(st.nextToken());
                int b = Integer.parseInt(st.nextToken());;
                int w = Integer.parseInt(st.nextToken());
                arrayList.get(b).add(new Edge(a,w));
            }

            shortestPath(c);
            int count = 0;
            int max = 0;
            for(int i=0; i<=n; i++){
                if(distance[i]!=Integer.MAX_VALUE){
                    count++;
                    max = Math.max(max,distance[i]);
                }
            }

            sb.append(count).append(" ").append(max).append("\n");
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


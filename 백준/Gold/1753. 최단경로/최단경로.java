import java.io.*;
import java.util.*;

public class Main {
    static int[] distance;
    static ArrayList<ArrayList<Node>> array = new ArrayList<>();
    static PriorityQueue<Node> pq = new PriorityQueue<>();
    static int INF = Integer.MAX_VALUE;
    static void shortestPath(int start,int v){
        pq.add(new Node(start,0));
        distance[start] = 0;
        while(!pq.isEmpty()){
            Node now = pq.poll();
            int nowNode = now.node;
            int nowWeight = now.weight;
            for(Node node : array.get(nowNode)){
                if(distance[node.node]>nowWeight+node.weight){
                    distance[node.node] = nowWeight+node.weight;
                    pq.add(new Node(node.node,nowWeight+node.weight));
                }
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());
        int start = Integer.parseInt(br.readLine());
        distance = new int[v+1];
        for(int i=0; i<=v; i++){
            array.add(new ArrayList<>());
        }
        Arrays.fill(distance,INF);
        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            array.get(a).add(new Node(b,c));
        }
        shortestPath(start,v);
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
class Node implements Comparable<Node>{
    public int node;
    public int weight;

    public Node(int node, int weight) {
        this.node = node;
        this.weight = weight;
    }

    @Override
    public int compareTo(Node o) {
        return this.weight - o.weight;
    }
}
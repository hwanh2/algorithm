import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int find(int node){
        if(node == parent[node]){
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    static void union(int a, int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb){
            parent[fa] = fb;
        }
    }

    static class Edge implements Comparable<Edge>{
        public int node1;
        public int node2;
        public int cost;

        public Edge(int node1, int node2, int cost) {
            this.node1 = node1;
            this.node2 = node2;
            this.cost = cost;
        }

        @Override
        public int compareTo(Edge o) {
            return cost - o.cost;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=0; i<=n; i++){
            parent[i] = i;
        }

        st = new StringTokenizer(br.readLine()," ");
        int firstK = Integer.parseInt(st.nextToken());
        for(int i=1; i<k; i++){
            int nextK = Integer.parseInt(st.nextToken());
            union(firstK,nextK);
        }

        ArrayList<Edge> edgeList = new ArrayList<>();

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());

            edgeList.add(new Edge(a,b,c));
        }

        Collections.sort(edgeList);

        int result = 0;
        int edgeCount = 0;

        for(Edge edge : edgeList){
            int node1 = edge.node1;
            int node2 = edge.node2;

            if(find(node1)!=find(node2)){
                union(node1, node2);
                edgeCount++;
                result+=edge.cost;
            }

            if(edgeCount==n-1){
                break;
            }
        }
        System.out.println(result);
    }
}
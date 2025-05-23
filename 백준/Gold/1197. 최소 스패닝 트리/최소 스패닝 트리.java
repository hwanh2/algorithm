import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static List<Edge> arrayList;
    static int find(int v){
        if(v==parent[v]){
            return v;
        }
        return parent[v] = find(parent[v]);
    }
    static void union(int a,int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb){
            parent[fa] = fb;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int v = Integer.parseInt(st.nextToken());
        int e = Integer.parseInt(st.nextToken());

        arrayList = new ArrayList<>();
        parent = new int[v+1];
        for(int i=1; i<=v; i++){
            parent[i] = i;
        }

        for(int i=0; i<e; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            arrayList.add(new Edge(a,b,c));
        }

        Collections.sort(arrayList);

        int result = 0;
        int edgeCount = 0;
        for(Edge edge : arrayList){
            if(edgeCount==v-1){
                break;
            }
            int fNode1 = find(edge.node1);
            int fNode2 = find(edge.node2);
            if(fNode1!=fNode2){
                union(fNode1,fNode2);
                result+=edge.weight;
                edgeCount++;
            }
        }
        System.out.println(result);
    }
}

class Edge implements Comparable<Edge>{
    public int node1;
    public int node2;
    public int weight;

    public Edge(int node1, int node2, int weight) {
        this.node1 = node1;
        this.node2 = node2;
        this.weight = weight;
    }

    @Override
    public int compareTo(Edge o) {
        return this.weight - o.weight;
    }
}

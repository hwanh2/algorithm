import java.io.*;
import java.util.*;

public class Main {
    static List<Edge> arrayList;
    static int[] parent;
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
    public static void main(String[] args)  throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[][] array = new int[n][n];
        arrayList = new ArrayList<>();
        parent = new int[n];
        for(int i = 0; i < n; i++) {
            parent[i] = i;
        }
        
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                array[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i=0; i<n; i++) {
            for (int j = i+1; j<n; j++) { // i < j로 수정하여 중복 방지
                if (array[i][j] != 0) {
                    arrayList.add(new Edge(i,j,array[i][j]));
                }
            }
        }

        Collections.sort(arrayList);

        long result = 0;
        int edgeCount = 0;

        for(Edge edge : arrayList){
            int a = find(edge.node1);
            int b = find(edge.node2);
            if(a!=b){
                union(a,b);
                result+=edge.weight;
                edgeCount++;
            }
            if(edgeCount==n-1){
                break;
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
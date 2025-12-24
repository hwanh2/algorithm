import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int find(int node){
        if(node==parent[node]){
            return node;
        }
        return parent[node] = find(parent[node]);
    }
    static void union(int a,int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb){
            parent[fa] = fb;
        }
}
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<n-2; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            union(a,b);
        }

        for(int i=1; i<=n; i++){
            if(find(i)==i){
                sb.append(i).append(" ");
            }
        }
        System.out.println(sb);
    }
}
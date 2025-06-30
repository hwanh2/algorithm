import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;
    static int find(int v){
        if(parent[v]==v){
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            union(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        int[] count = new int[n+1];
        for(int i=1; i<=n; i++){
            count[find(i)]++;
        }

        long result = 1;
        for(int i=1; i<=n; i++){
            if(parent[i]==i){
                result = (result*count[i]) % 1000000007;
            }
        }

        System.out.println(result);
    }
}

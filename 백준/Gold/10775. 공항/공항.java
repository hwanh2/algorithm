import java.io.*;
import java.util.*;

class Main {
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
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int g = Integer.parseInt(br.readLine());
        int p = Integer.parseInt(br.readLine());

        parent = new int[g+1];
        for(int i=1; i<=g; i++){
            parent[i] = i;
        }

        int result = 0;
        for(int i=0; i<p; i++){
            int airplane = Integer.parseInt(br.readLine());
            int fa = find(airplane);
            if(fa==0){
                break;
            }
            union(fa,fa-1);
            result++;
        }
        System.out.println(result);
    }
}

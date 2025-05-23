import java.io.*;
import java.util.*;


public class Main {
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
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int m = Integer.parseInt(br.readLine());

        parent = new int[n+1];
        for(int i=1; i<=n; i++){
            parent[i] = i;
        }
        for(int i=0; i<n; i++){
            StringTokenizer st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                int tmp = Integer.parseInt(st.nextToken());
                if(tmp==1){
                    union(i+1,j+1);
                }
            }
        }
        int flag = 0;
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int tmp = find(Integer.parseInt(st.nextToken()));
        for(int i=1; i<m; i++){
            if(tmp!=find(Integer.parseInt(st.nextToken()))){
                flag = 1;
                break;
            }
        }
        System.out.println(flag==1?"NO":"YES");
    }
}

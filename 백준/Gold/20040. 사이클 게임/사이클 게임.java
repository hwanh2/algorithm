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

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
        }

        int flag = 0;
        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int fa = find(Integer.parseInt(st.nextToken()));
            int fb = find(Integer.parseInt(st.nextToken()));
            if(fa==fb){
                System.out.println(i+1);
                flag = 1;
                return;
            }
            else{
                union(fa,fb);
            }
        }
        if(flag==0){
            System.out.println(0);
        }

    }
}

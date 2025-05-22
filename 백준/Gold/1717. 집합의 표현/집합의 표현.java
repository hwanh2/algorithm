import java.io.*;
import java.util.*;


public class Main {
    static int[] array;
    static int find(int v){
        if(v==array[v]){
            return v;
        }
        else{
            return array[v] = find(array[v]);
        }
    }
    static void union(int a,int b){
        int fa = find(a);
        int fb = find(b);
        if(fa!=fb){
            array[fa] = fb;
        }
    }
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        array = new int[n+1];
        for(int i=0; i<=n; i++){
            array[i] = i;
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            int c = Integer.parseInt(st.nextToken());
            if(a==0){
                union(b,c);
            }
            else{
                if(find(b)==find(c)){
                    sb.append("YES").append("\n");
                }
                else{
                    sb.append("NO").append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}

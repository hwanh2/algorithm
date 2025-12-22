import java.io.*;
import java.util.*;

public class Main {
    static ArrayList<ArrayList<Integer>> arrayList;
    static int n,m;
    static boolean[] visited;
    static boolean flag = false;
    static void dfs(int current, int depth){
        if(depth==5){
            flag = true;
            return;
        }

        for(int next : arrayList.get(current)){
            if(!visited[next]){
                visited[next] = true;
                dfs(next,depth+1);
                if(flag){
                    return;
                }
                visited[next] = false;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        visited = new boolean[n];
        arrayList = new ArrayList<>();
        for(int i=0; i<n; i++){
            arrayList.add(new ArrayList<>());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine()," ");
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            arrayList.get(a).add(b);
            arrayList.get(b).add(a);
        }

        for(int i=0; i<n; i++){
            visited[i] = true;
            dfs(i,1);
            visited[i] = false;
        }

        if(flag){
            System.out.println(1);
        }
        else{
            System.out.println(0);
        }
    }
}
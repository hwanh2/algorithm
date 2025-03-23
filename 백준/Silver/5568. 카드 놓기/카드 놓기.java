import java.io.*;
import java.util.*;

public class Main {
    static StringBuilder sb;
    static int n;
    static int k;
    static int[] array;
    static int[] visited;
    static int[] tmp;
    static HashSet<String> set;
    static void backTracking(int depth){
        if(depth==k){
            String str = "";
            for(int i=0; i<k; i++){
                str+=Integer.toString(tmp[i]);
            }
            set.add(str);
            return;
        }
        for(int i=0; i<n; i++){
            if(visited[i]==0){
                visited[i] = 1;
                tmp[depth] = array[i];
                backTracking(depth+1);
                visited[i] = 0;
            }
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        sb = new StringBuilder();
        n = Integer.parseInt(br.readLine());
        k = Integer.parseInt(br.readLine());
        array = new int[n];
        visited = new int[n];
        tmp = new int[k];
        set = new HashSet<>();
        for(int i=0; i<n; i++){
            array[i] = Integer.parseInt(br.readLine());
        }
        backTracking(0);
        System.out.println(set.size());
    }
}
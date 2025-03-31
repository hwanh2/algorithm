import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            HashSet<Integer> set = new HashSet<>();
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<n; j++){
                set.add(Integer.parseInt(st.nextToken()));
            }
            int m = Integer.parseInt(br.readLine());
            st = new StringTokenizer(br.readLine()," ");
            for(int j=0; j<m; j++){
                if(set.contains(Integer.parseInt(st.nextToken()))){
                    sb.append(1).append("\n");
                }
                else{
                    sb.append(0).append("\n");
                }
            }
        }
        System.out.println(sb);
    }
}


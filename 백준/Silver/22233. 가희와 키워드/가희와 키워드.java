import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());
        Set<String> set = new HashSet<>();

        for(int i=0; i<n; i++){
            set.add(br.readLine());
        }

        for(int i=0; i<m; i++){
            st = new StringTokenizer(br.readLine(),",");
            while(st.hasMoreTokens()){
                set.remove(st.nextToken());
            }
            sb.append(set.size()).append("\n");
        }

        System.out.println(sb);
    }
}


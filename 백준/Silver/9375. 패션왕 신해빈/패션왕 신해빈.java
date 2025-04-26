import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int t = Integer.parseInt(br.readLine());

        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            Map<String,Integer> map = new HashMap<>();
            for(int j=0; j<n; j++){
                StringTokenizer st = new StringTokenizer(br.readLine()," ");
                st.nextToken();
                String str = st.nextToken();
                map.put(str,map.getOrDefault(str,0)+1);
            }

            int count = 1;
            for(String str : map.keySet()){
                count*=(map.get(str)+1);
            }
            sb.append(count-1).append("\n");
        }
        System.out.println(sb);
    }
}

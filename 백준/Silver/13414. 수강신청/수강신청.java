import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine()," ");
        StringBuilder sb = new StringBuilder();
        int k = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());

        Set<String> set = new LinkedHashSet<>();

        for(int i=0; i<l; i++){
            String str = br.readLine();
            set.remove(str);
            set.add(str);
        }
        int count = 0;
        for(String str : set){
            if(count==k){
                break;
            }
            sb.append(str).append("\n");
            count++;
        }
        System.out.println(sb);
    }
}


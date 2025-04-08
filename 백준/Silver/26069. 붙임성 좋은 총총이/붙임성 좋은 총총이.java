import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;
        HashSet<String> set = new HashSet<>();
        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            st = new StringTokenizer(br.readLine());
            String str1 = st.nextToken();
            String str2 = st.nextToken();
            if(str1.equals("ChongChong") || str2.equals("ChongChong")){
                set.add("ChongChong");
            }
            if(set.contains(str1) || set.contains(str2)){
                set.add(str1);
                set.add(str2);
            }
        }
        System.out.println(set.size());
    }
}


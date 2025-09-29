import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int n = Integer.parseInt(br.readLine());
        for(int i=0; i<n; i++){
            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str," ");
            int len = st.countTokens();

            for(int j=0; j<len; j++){
                String tmp = st.nextToken();
                for(int k=tmp.length()-1; k>=0; k--){
                    sb.append(tmp.charAt(k));
                }
                sb.append(" ");
            }
            sb.append("\n");
        }
        System.out.println(sb);
    }
}

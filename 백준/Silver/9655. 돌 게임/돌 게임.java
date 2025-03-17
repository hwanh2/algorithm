import java.io.*;
import java.util.*;

public class Main {
    static String dp[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());
        dp = new String[n+1];
        dp[1] = "SK";
        for(int i=2; i<=n; i++){
            if(dp[i-1].equals("SK")){
                dp[i] = "CY";
            }
            else{
                dp[i] = "SK";
            }
        }
        bw.write(dp[n]+"\n");
        bw.flush();
    }
}
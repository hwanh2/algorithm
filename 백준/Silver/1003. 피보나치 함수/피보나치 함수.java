import java.io.*;
import java.util.*;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());
        for(int i=0; i<t; i++){
            int n = Integer.parseInt(br.readLine());
            switch (n){
                case 0:
                    bw.write(1+" "+0+"\n");
                    continue;
                case 1:
                    bw.write(0+" "+1+"\n");
                    continue;
            }
            int[][] dp = new int[n+1][2];

            dp[0][0] = 1;
            dp[0][1] = 0;
            dp[1][0] = 0;
            dp[1][1] = 1;

            for(int j=2; j<=n; j++){
                dp[j][0] = dp[j-1][0]+dp[j-2][0];
                dp[j][1] = dp[j-1][1]+dp[j-2][1];
            }
            bw.write(dp[n][0]+" "+dp[n][1]+"\n");
        }
        bw.flush();
    }
}

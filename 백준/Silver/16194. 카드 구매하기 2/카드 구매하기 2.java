import java.io.*;
import java.util.*;

class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        int[] array = new int[n+1];
        StringTokenizer st = new StringTokenizer(br.readLine(), " ");
        for (int i=1; i<=n; i++) {
            array[i] = Integer.parseInt(st.nextToken());
        }

        int[] dp = new int[n+1];
        Arrays.fill(dp, 10000);
        dp[0]=0;

        for (int i=1; i<=n; i++) {
            for (int j=i; j<=n; j++) { 
                dp[j] = Math.min(dp[j], dp[j-i] + array[i]);
            }
        }

        System.out.println(dp[n]);
    }
}